package lambda.lambda3;

public class GenericMain5 {

    public static void main(String[] args) {

        // 문자를 넣어서 문자를 반환
        GenericFunction<String, String> upperCase = s -> s.toUpperCase();
        String result1 = upperCase.apply("hello");
        System.out.println("result1 = " + result1);

        // 숫자를 넣어서 숫자를 반환
        GenericFunction<Integer, Integer> square = s -> s * s;
        Integer result2 = square.apply(5);
        System.out.println("result2 = " + result2);
    }
    
    // T를 받아서 R을 반환해주는 제네릭 함수
    @FunctionalInterface
    interface GenericFunction<T, R> {
        R apply(T s);
    }
}
