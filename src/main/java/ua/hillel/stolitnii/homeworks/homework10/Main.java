package ua.hillel.stolitnii.homeworks.homework10;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> mainList = new ArrayList<>();
        mainList.add("Тест");
        mainList.add("Собака");
        mainList.add("Тест");
        mainList.add("Кінь");
        mainList.add("Пес");
        mainList.add("Тест");
        mainList.add("Корова");
        mainList.add("Сроки");
        mainList.add("Горять");
        mainList.add("ААААА");
        mainList.add("Жопа");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(4);
        numbers.add(5);

        List<String> occList = new ArrayList<>();
        occList.add("Тест");
        occList.add("Собака");
        occList.add("Тест");
        occList.add("Кінь");
        occList.add("Пес");
        occList.add("Тест");
        occList.add("Кінь");
        occList.add("Корова");
        occList.add("Пес");
        occList.add("Тест");

        String[] array = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
        String inList = "Тест";
        int occurrenceCount = countOccurrence(mainList, inList);

        System.out.println("Task 1");
        System.out.println("The word '" + inList + "' occurs " + occurrenceCount + " times.");
        System.out.println("Task 2");
        System.out.println("List: " + toList(array));
        System.out.println("Task 3");
        System.out.println("Unique numbers: " + findUnique(numbers));
        System.out.println("Task 4");
        System.out.println("List: " + calcOccurance(occList));
    }

    public static int countOccurrence(List<String> mainList, String inList) {
        int count = 0;
        for (String word : mainList) {
            if (word.equals(inList)) {
                count++;
            }
        }
        return count;
    }

    public static String toList(String array[]) {
        List<String> list = new ArrayList<>();
        for (String word : array) {
            list.add(word);
        }
        return list.toString();
    }

    public static List<Integer> findUnique(List<Integer> numbers) {
        Set<Integer> uniqueSet = new HashSet<>();

        for (Integer num : numbers) {
            uniqueSet.add(num);
        }

        List<Integer> uniqueNumbers = new ArrayList<>(uniqueSet);

        return uniqueNumbers;
    }

    public static List<String> calcOccurance(List<String> occList) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : occList) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            result.add(entry.getKey() + " - " + entry.getValue());
        }

        return result;
    }


}
