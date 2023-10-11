package ua.hillel.stolitnii.homeworks.homework10.phonebook;

import java.util.ArrayList;
import java.util.List;

class Record {
    private String name;
    private String phone;

    public Record(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}

class PhoneBook {
    private List<Record> records;

    public PhoneBook() {
        records = new ArrayList<>();
    }

    public void add(String name, String phone) {
        Record record = new Record(name, phone);
        records.add(record);
    }

    public Record find(String name) {
        for (Record record : records) {
            if (record.getName().equals(name)) {
                return record;
            }
        }
        return null;
    }

    public List<Record> findAll(String name) {
        List<Record> matchingRecords = new ArrayList<>();
        for (Record record : records) {
            if (record.getName().equals(name)) {
                matchingRecords.add(record);
            }
        }
        return matchingRecords.isEmpty() ? null : matchingRecords;
    }
}

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("John Smith", "123-416-7890");
        phoneBook.add("Dave Smith", "123-426-7890");
        phoneBook.add("Jane Smith", "987-654-3210");
        phoneBook.add("John Digle", "555-555-5555");
        phoneBook.add("John Travolta", "555-555-5555");
        String searchName = "Dave Smith";
        Record record = phoneBook.find(searchName);
        if (record != null) {
            System.out.println("Знайдено: " + record.getName() + " - " + record.getPhone());
        } else {
            System.out.println("Запис не знайдено.");
        }

        List<Record> records = phoneBook.findAll(searchName);
        if (records != null) {
            System.out.println("Знайдено записів з ім'ям " + searchName + ":");
            for (Record r : records) {
                System.out.println(r.getName() + " - " + r.getPhone());
            }
        } else {
            System.out.println("Записів не знайдено.");
        }
    }
}
