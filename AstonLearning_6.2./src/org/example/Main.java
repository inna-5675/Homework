package org.example;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        org.example.PhoneBook phoneBook = new org.example.PhoneBook();

        phoneBook.add("Иванов", "123-456");
        phoneBook.add("Иванов", "234-567");
        phoneBook.add("Петров", "345-678");
        phoneBook.add("Сидоров", "777-888");

        printInfo("Иванов", phoneBook.get("Иванов"));
        printInfo("Петров", phoneBook.get("Петров"));
        printInfo("Сидоров", phoneBook.get("Сидоров"));
        printInfo("Смирнов", phoneBook.get("Смирнов"));
    }

    private static void printInfo(String surname, List<String> numbers) {
        if (numbers.isEmpty()) {
            System.out.println("Фамилия " + surname + " не найдена в справочнике.");
        } else {
            System.out.println("Фамилия: " + surname + ". Номера: " + numbers);
        }
    }
}