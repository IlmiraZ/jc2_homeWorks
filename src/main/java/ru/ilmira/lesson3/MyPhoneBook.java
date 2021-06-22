package ru.ilmira.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyPhoneBook {
    public static void main(String[] args) {
        Subscriber phoneBook = new Subscriber();
        phoneBook.addSubscriber("Иванов", "8(123)456-78-99");
        phoneBook.addSubscriber("Петров", "8(123)456-78-78");
        phoneBook.addSubscriber("Иванов", "8(123)456-88-99");
        phoneBook.addSubscriber("Сидоров", "8(123)456-78-99");
        phoneBook.addSubscriber("Петров", "8(123)456-78-87");
        phoneBook.addSubscriber("Синицын", "8(123)456-99-99");
        phoneBook.addSubscriber("Медведев", "8(123)456-77-77");
        phoneBook.addSubscriber("Мартынов", "8(123)456-66-66");
        phoneBook.addSubscriber("Кудряшов", "8(123)456-55-44");

        System.out.println(phoneBook.getPhoneNumber("Иванов"));
        System.out.println(phoneBook.getPhoneNumber("Петров"));
        System.out.println(phoneBook.getPhoneNumber("Кудряшов"));
    }

    static class Subscriber {
        private final Map<String, List<String>> subscriber = new HashMap<>();

        public void addSubscriber(String lastName, String phoneNumber) {
            List<String> phoneNumberList;
            if (subscriber.containsKey(lastName)) {
                phoneNumberList = subscriber.get(lastName);
            } else {
                phoneNumberList = new ArrayList<>();
            }
            phoneNumberList.add(phoneNumber);
            subscriber.put(lastName, phoneNumberList);
        }

        public List<String> getPhoneNumber(String lastName) {
            return subscriber.get(lastName);
        }
    }
}
