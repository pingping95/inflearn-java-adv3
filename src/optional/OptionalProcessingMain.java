package optional;

import java.util.Optional;

public class OptionalProcessingMain {

    public static void main(String[] args) {

        Optional<String> optValue = Optional.of("Hello");
        Optional<String> optEmpty = Optional.empty();

        // 1. 값이 존재하면 Consumer 실행 // 없으면 아무 일도 하지 않음
        System.out.println("=== 1. ifPresent() ===");
        optValue.ifPresent(v -> System.out.println("optValue: " + v));
        optEmpty.ifPresent(v -> System.out.println("optEmpty: " + v));  // 실행 안함

        // 2. 값이 있으면 Consumer 실행, 없으면 Runnable 실행
        System.out.println("=== 2. ifPresentOrElse() ===");
        optValue.ifPresentOrElse(
                v -> System.out.println("optValue : " + v),
                () -> System.out.println("optValue 비어있음")
        );

        optEmpty.ifPresentOrElse(
                v -> System.out.println("optEmpty : " + v),
                () -> System.out.println("optEmpty 비어있음")
        );

        // 3. 값이 있으면 Function 적용 후 Optional로 반환, 없으면 Optional.empty()
        System.out.println("=== 3. map() ===");
        Optional<Integer> lengthOpt1 = optValue.map(String::length);
        System.out.println("optValue.map(String::length) = " + lengthOpt1);

        Optional<Integer> lengthOpt2 = optEmpty.map(String::length);
        System.out.println("optValue.map(String::length) = " + lengthOpt2);

        // 4. map()과 유사하나, 이미 Optional을 반환하는 경우 중첩을 제거
        System.out.println("=== 4. flatMap() ===");
        System.out.println("[map]");
        // Optional[Hello] -> Optional[Optional[HELLO]]
        Optional<Optional<String>> nestedOpt = optValue.map(s -> Optional.of(s));
        System.out.println("optValue = " + optValue);
        System.out.println("nestedOpt = " + nestedOpt);

        System.out.println("[flatMap]");
        // Optional[Hello] -> Optional[HELLO]
        Optional<String> flattenedOpt = optValue.flatMap(s -> Optional.of(s));
        System.out.println("optValue = " + optValue);
        System.out.println("flattenedOpt = " + flattenedOpt);

        // 5. 값이 있고 조건을 만족하면 그 값을 그대로, 불만족시 Optional.emtpy()
        System.out.println("=== 5. filter() ===");
        Optional<String> filtered1 = optValue.filter(s -> s.startsWith("H"));
        Optional<String> filtered2 = optValue.filter(s -> s.startsWith("X"));

        System.out.println("filter(H) = " + filtered1); // Optional[Hello]
        System.out.println("filter(X) = " + filtered2); // Optional.empty

        // 6. 값이 있으면 단일 요소 스트림, 없으면 빈 스트림
        System.out.println("=== 6. stream() ===");
        optValue.stream()
                .forEach(s -> System.out.println("optValue.stream() -> " + s));

        optEmpty.stream()
                .forEach(s -> System.out.println("opeEmpty.stream() -> " + s));

    }

}
