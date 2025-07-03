package lambda.start;

public class Ex0Main {

    public static void hello(String str) {
        System.out.println("프로그램 시작");
        System.out.println("Hello " + str);
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        hello("Java");
        hello("Spring");
    }

}
