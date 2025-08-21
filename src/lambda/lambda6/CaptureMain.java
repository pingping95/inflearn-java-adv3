package lambda.lambda6;

public class CaptureMain {

    public static void main(String[] args) {

        // 명시적 final
        final int final1 = 10;

        // 사실상 final (재할당이 없기 때문)
        int final2 = 20;

        // 값이 변경되는 변수
        int changedVar = 30;

        // 1. 익명 클래스에서 캡쳐
        Runnable anonymous = new Runnable() {
            @Override
            public void run() {
                System.out.println("익명 클래스 - final1 : " + final1);
                System.out.println("익명 클래스 - final2 : " + final2);

                // 컴파일 오류
//                System.out.println("익명 클래스 - changedVar : " + changedVar);
            }
        };

        // 2. 람다 표현식에서의 캡처
        Runnable lambda = () -> {
            System.out.println("람다 - final1 : " + final1);
            System.out.println("람다 - final2 : " + final2);

            // 컴파일 오류
//            System.out.println("람다 - changedVar : " + changedVar);
        };

        // 값 변경 -> 사실상 final이 아니게 된다.
        changedVar++;

        anonymous.run();
        lambda.run();
    }
}
