package lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GenericMapper {

    // 문자열 리스트를 숫자 리스트로 변환(즉, 매핑)할 때 사용할 수 있음
    public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(mapper.apply(s));
        }
        return result;
    }
}
