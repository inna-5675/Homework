import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private List<String[]> phoneBook;
    private int nextId;

    public PhoneBook() {
        phoneBook = new ArrayList<>();
        nextId = 1;
    }

    public void add(String lastName, String phoneNumber) {
        String[] entry = {String.valueOf(nextId), lastName, phoneNumber};
        phoneBook.add(entry);
        System.out.println("Добавлено: ID=" + nextId + ", " +
                lastName + ", " + phoneNumber);
        nextId++;
    }

    public void get(String lastName) {
        System.out.println("\nПоиск по фамилии: " + lastName);
        boolean found = false;

        for (String[] entry : phoneBook) {
            if (entry[1].equalsIgnoreCase(lastName)) {
                System.out.println(entry[0] + ". " +
                        entry[1] + " - " + entry[2]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Записей не найдено.");
        }
    }
}