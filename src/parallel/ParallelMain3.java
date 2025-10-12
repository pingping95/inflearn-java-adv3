package parallel;

import java.util.concurrent.*;

import static util.MyLogger.log;

public class ParallelMain3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 스레드 풀 준비
        ExecutorService es = Executors.newFixedThreadPool(2);

        long startTime = System.currentTimeMillis();

        // 1. 작업 분할
        SumTask task1 = new SumTask(1, 4);
        SumTask task2 = new SumTask(5, 8);

        // 2. 분할할 작업 처리
        Future<Integer> future1 = es.submit(task1);
        Future<Integer> future2 = es.submit(task2);

        // 3. join - 처리한 결과를 합친다. (get : 결과가 나올 때 까지 대기)
        Integer result1 = future1.get();
        Integer result2 = future2.get();

        int sum = result1 + result2;
        long endTime = System.currentTimeMillis();

        log("time : " + (endTime - startTime) + "ms, sum : " + sum);
        es.close();
    }

    static class SumTask implements Callable<Integer> {
        int startValue;
        int endValue;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public Integer call() {

            log("작업 시작");
            int sum = 0;

            for (int i = startValue; i <= endValue; i++) {
                int calculated = HeavyJob.heavyTask(i);
                sum += calculated;
            }

            log("작업 완료. result = " + sum);
            return sum;
        }
    }
}
