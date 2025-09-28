package stream.collectors;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collectors4MinMax {

    public static void main(String[] args) {

        // 비교자 (i1, i2) -> i1.compareTo(i2)
        // 스트림의 요소 중 최대값을 찾아 Optional<Integer> 반환 후 .get() 메서드로 Optional에서 실제 값 추출
        Integer max1 = Stream.of(1, 2, 3)
                .collect(Collectors.maxBy(
                        ((i1, i2) -> i1.compareTo(i2)))
                ).get();
        System.out.println("max1 = " + max1);

        // Stream API 메서드 중 .max(Comparator) 사용
        Integer max2 = Stream.of(1, 2, 3)
                .max((i1, i2) -> i1.compareTo(i2)).get();
        System.out.println("max2 = " + max2);

        // 비교자(Comparator)를 메서드 참조 방식 사용
        Integer max3 = Stream.of(1, 2, 3)
                .max((Integer::compareTo)).get();
        System.out.println("max3 = " + max3);

        // IntStream : 기본형 int 전용 스트림
        // .getAsInt() : 실제 int 값 추출
        int max4 = IntStream.of(1, 2, 3)
                .max().getAsInt();
        System.out.println("max4 = " + max4);

    }

}
