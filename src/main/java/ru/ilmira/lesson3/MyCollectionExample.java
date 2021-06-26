package ru.ilmira.lesson3;
import java.util.*;

public class MyCollectionExample {
    public static void main(String[] args) {
        List<String> listWords = new ArrayList<>(Arrays.asList("Арбуз", "Дыня", "Томат", "Огурец",
                "Банан", "Арбуз", "Дыня", "Тыква", "Перец", "Арбуз", "Томат"));
        System.out.println("Исходный список:");
        listWords.forEach(System.out::println);

        Set<String> uniqueWords = new HashSet<>(listWords);
        System.out.println("Список уникальных слов:");
        uniqueWords.forEach(System.out::println);

        Map<String, Integer> countWordsMap = new HashMap<>();
        for (String word : listWords) {
            countWordsMap.put(word, Collections.frequency(listWords, word));
        }
        System.out.println("Столько раз встречается слово в списке:");
        countWordsMap.entrySet().forEach(System.out::println);
    }
}
