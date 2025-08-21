package lambda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStreamV1  {

    private List<Integer> internalList;

    public MyStreamV1(List<Integer> list) {
        this.internalList = list;
    }

    public MyStreamV1 filter(Predicate<Integer> predicate) {
        List<Integer> filtered = new ArrayList<>();
        for (Integer element : internalList) {
            // 외부에서 전달해주는 lambda 식이 참일 경우
            if (predicate.test(element)) {
                filtered.add(element);
            }
        }
        return new MyStreamV1(filtered);
    }

    public MyStreamV1 map(Function<Integer, Integer> mapper) {
        List<Integer> mapped = new ArrayList<>();
        for (Integer element : internalList) {
            mapped.add(mapper.apply(element));
        }
        return new MyStreamV1(mapped);
    }

    public List<Integer> toList() {
        return internalList;
    }
}
