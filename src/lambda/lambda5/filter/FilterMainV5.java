package lambda.lambda5.filter;

import java.util.List;

public class FilterMainV5 {

    public static void main(String[] args) {

        // 숫자 필터 사용하기
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        List<Integer> numberResult = GenericFilter.filter(numbers, n -> n % 2 == 0);
        System.out.println("numberResult = " + numberResult);

        // 문자 필터 만들기
        List<String> strings = List.of("A", "BB", "CCC");
        List<String> stringResult = GenericFilter.filter(strings, n -> n.length() >= 2);
        System.out.println("stringResult = " + stringResult);
    }
}
