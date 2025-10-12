package parallel.forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ForkJoinMain2 {

    public static void main(String[] args) {

        int processorCount = Runtime.getRuntime().availableProcessors();
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        log("processor count: " + processorCount + ", commonPool = " + commonPool.getParallelism());

        // 1 ~ 8 까지의 숫자 리스트 생성
        List<Integer> data = IntStream.rangeClosed(1, 8)
                .boxed()
                .toList();

        log("[생성] " + data);
        SumTask task = new SumTask(data);
        Integer result = task.invoke();
        log("최종 결과 : " + result);
    }
}
