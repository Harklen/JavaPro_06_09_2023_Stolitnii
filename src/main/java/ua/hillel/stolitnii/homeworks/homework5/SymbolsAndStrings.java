package ua.hillel.stolitnii.homeworks.homework5;

import java.util.Scanner;
//сорі за класи, але мені так зручніше)
public class SymbolsAndStrings {
    public static void main(String[] args) {
        System.out.println("Завдання 1. Підрахунок кількості символів у стрічці.");
        System.out.println(findSymbolOccurance.findSymbolOccurance("Hello world!", 'l'));
        System.out.println("Завдання 2. Пошук позиції слова у стрічці.");
        System.out.println(findWordPosition.findWordPosition("Apple", "plant"));
        System.out.println("Завдання 3. Реверс стрічки.");
        System.out.println(stringReverse.stringReverse("Hello world!"));
        System.out.println("Завдання 4. Перевірка на поліндром.");
        System.out.println(isPolyndrome.isPolyndrome("oppo"));
        System.out.println("Завдання 5. Вгадай слово.");
        wordGuessingGame.wordGuessingGame();
    }
}

class findSymbolOccurance {
    public static int findSymbolOccurance(String str, char symbol) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (symbol == str.charAt(i)) count++;
        }
        return count;
    }
}

class findWordPosition {
    public static int findWordPosition(String source, String target) {
        int result;
        if (source.contains(target)) {
            result = 1;
        } else {
            result = -1;
        }
        return result;
    }
}

class stringReverse {
    public static String stringReverse(String str) {
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        return reverse;
    }
}

class isPolyndrome {
    public static boolean isPolyndrome(String str) {
        String reverse = stringReverse.stringReverse(str);
        boolean result = str.equals(reverse);
        return result;
    }
}

class wordGuessingGame {
    public static void wordGuessingGame() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int randomIndex = (int) (Math.random() * words.length);
        String randomWord = words[randomIndex];
        Scanner scanner = new Scanner(System.in);
        String userWord;
        System.out.println("Вгадайте слово.");
        do {
            userWord = scanner.nextLine();
            if (userWord.equals(randomWord)) {
                System.out.println("Ви вгадали!");
                break;
            } else {
                System.out.println("Спробуйте ще раз.");
                System.out.println("Підказка: " + wordHint(userWord, randomWord));
            }
        } while (true);
    }

    public static String wordHint(String userWord, String randomWord) {
        String hint = "";
        int minLength = Math.min(userWord.length(), randomWord.length());
        for (int i = 0; i < minLength; i++) {
            hint += userWord.charAt(i) == randomWord.charAt(i) ? Character.valueOf(userWord.charAt(i)) : "#";
        }
        for (int i = minLength; i < 15; i++) hint += "#";
        return hint;
    }
}