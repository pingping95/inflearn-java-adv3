package stream.collectors;

public class Student {

    private String name;
    private int grade;
    private int score;

    public Student(String name, int grade, int score) {
        this.score = score;
        this.grade = grade;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                ", score=" + score +
                '}';
    }
}
