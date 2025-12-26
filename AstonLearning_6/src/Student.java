import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Student {
    private String name;
    private String group;
    private int course;
    private int[] grades;
    public Student(String name, String group, int course, int[] grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }
    public String getName() {
        return name;
    }
    public int getCourse() {
        return course;
    }
    public double getAverageGrade() {
        if (grades == null || grades.length == 0) {
            return 0.0;
        }
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }
    public void promote() {
        this.course++;
    }
    @Override
    public String toString() {
        return name + " (Group: " + group + ", Course: " + course + ")";
    }
}
