package stream.start;

import java.util.List;
import java.util.stream.Stream;

public class StreamStartMain {

    public static void main(String[] args) {

        List<String> names = List.of("Apple", "Banana", "Berry", "Tomato");

        // B로 시작하는 이름만 필터 후 대문자로 바꿔서 리스트로 수집
        Stream<String> stream = names.stream();
        List<String> result = stream
                .filter(name -> name.startsWith("B"))
                .map(name -> name.toUpperCase())
                .toList();

        System.out.println("=== 외부 반복 ===");
        for (String s : result) {
            System.out.println(s);
        }

        System.out.println("=== forEach, 내부 반복 ===");
        names.stream()
                .filter(name -> name.startsWith("B"))
                .map(name -> name.toUpperCase())
                .forEach(str -> System.out.println(str));

        System.out.println("=== 메서드 참조 ===");
        names.stream()
                .filter(name -> name.startsWith("B"))
                // 임의 객체의 인스턴스 메서드 참조 (매개변수 참조)
                .map(String::toUpperCase)
                // 특정 객체의 인스턴스 메서드 참조
                .forEach(System.out::println);
    }
}
