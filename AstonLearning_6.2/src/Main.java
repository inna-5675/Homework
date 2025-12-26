import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PhoneBook directory = new PhoneBook();

        directory.add("Иванов", "111-11-11");
        directory.add("Петров", "222-22-22");
        directory.add("Сидоров", "333-33-33");
        directory.add("Иванов", "444-44-44");
        directory.add("Иванов", "555-55-55");

        directory.get("Иванов");
        directory.get("Петров");
        directory.get("Смирнов");
    }
}