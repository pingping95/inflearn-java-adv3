package lambda.start;

import lambda.Procedure;

import java.util.Random;

// 정적 중첩 클래스를 활용한다.
public class Ex1RefMainV1 {

    // hello 메서드는 Procedure를 '구현'한 클래스를 넣을 수 있다.
    public static void hello(Procedure procedure) {
        long startNs = System.nanoTime();

        // 코드 조각 시작
        procedure.run();

        long endNs = System.nanoTime();
        System.out.println("실행 시간 : " + (endNs - startNs) + " ns");
    }

    static class Dice implements Procedure {

        @Override
        public void run() {
            int randomValue = new Random().nextInt(6) + 1;
        }
    }

    static class Sum implements Procedure {
        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println("i = " + i);
            }
        }
    }

    public static void main(String[] args) {
        Procedure dice = new Dice();
        Procedure sum = new Sum();
        hello(dice);
        hello(sum);
    }
}
