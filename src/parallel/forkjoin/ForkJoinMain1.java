package parallel.forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ForkJoinMain1 {

    public static void main(String[] args) {

        // 1 ~ 8 까지의 숫자 리스트 생성
        List<Integer> data = IntStream.rangeClosed(1, 8)
                .boxed()
                .toList();

        log("[생성] " + data);

        // ForkJoinPool 생성, 작업 수행
        ForkJoinPool pool = new ForkJoinPool(10);

        long startTime = System.currentTimeMillis();

        SumTask task = new SumTask(data);

        // 병렬로 합을 구한 후 결과 출력
        // 메인 스레드는 작업이 완료될 때까지 기다린 후 결과를 받는다.
        Integer result = pool.invoke(task);

        // 더 이상 작업이 없으므로 풀 종료
        pool.close();

        long endTime = System.currentTimeMillis();

        log("time : " + (endTime - startTime) + "ms, sum : " + result);
        log("pool : " + pool);
    }
}
