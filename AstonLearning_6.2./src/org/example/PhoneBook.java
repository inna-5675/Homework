package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class PhoneBook {
    private Map<String, List<String>> storage = new HashMap<>();
    public void add(String surname, String phoneNumber) {
        storage.computeIfAbsent(surname, k -> new ArrayList<>()).add(phoneNumber);
    }
    public List<String> get(String surname) {
        return storage.getOrDefault(surname, new ArrayList<>());
    }
}