import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Alice", "A1", 1, new int[]{4, 5, 3}));
        students.add(new Student("Bob", "A1", 1, new int[]{2, 2, 3}));
        students.add(new Student("Charlie", "A2", 2, new int[]{5, 4, 4}));
        students.add(new Student("David", "A2", 2, new int[]{1, 2, 1}));

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3) {
                iterator.remove();
            }
        }
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.promote();
            }
        }
        printStudents(students, 1);
        printStudents(students, 2);
    }
    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Students in course " + course + ":");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}
