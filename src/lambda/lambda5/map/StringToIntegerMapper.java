package lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StringToIntegerMapper {

    // 문자열 리스트를 숫자 리스트로 변환(즉, 매핑)할 때 사용할 수 있음
    public static List<Integer> map(List<String> list, Function<String, Integer> mapper) {
        List<Integer> result = new ArrayList<>();
        for (String s : list) {
            result.add(mapper.apply(s));
        }
        return result;
    }
}
