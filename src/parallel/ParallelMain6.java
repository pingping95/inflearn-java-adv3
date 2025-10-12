package parallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static util.MyLogger.log;

public class ParallelMain6 {

    public static void main(String[] args) throws InterruptedException {

        // 요청 풀
        ExecutorService requestPool = Executors.newFixedThreadPool(100);

        // 로직 처리 전용 스레드 풀
        ExecutorService logicPool = Executors.newFixedThreadPool(400);

        int nThreads = 3;   // 1, 2, 3, 10, 20

        for (int i = 1; i <= nThreads; i++) {
            String requestName = "request" + i;
            requestPool.submit(() -> logic(requestName, logicPool));
            Thread.sleep(100);  // 스레드 순서를 확인하기 위해
        }

        requestPool.close();
        logicPool.close();
    }

    private static void logic(String requestName, ExecutorService es) {
        log("[" + requestName + "] START");

        long startTime = System.currentTimeMillis();

        // 1 ~ 4 까지의 작업을 각각 스레드 풀에 제출
        Future<Integer> f1 = es.submit(() -> HeavyJob.heavyTask(1, requestName));
        Future<Integer> f2 = es.submit(() -> HeavyJob.heavyTask(2, requestName));
        Future<Integer> f3 = es.submit(() -> HeavyJob.heavyTask(3, requestName));
        Future<Integer> f4 = es.submit(() -> HeavyJob.heavyTask(4, requestName));

        int sum;
        try {
            Integer v1 = f1.get();
            Integer v2 = f2.get();
            Integer v3 = f3.get();
            Integer v4 = f4.get();
            sum = v1 + v2 + v3 + v4;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();

        log("[" + requestName + "] time: " + (endTime - startTime) + "ms, sum: " + sum);
    }
}
