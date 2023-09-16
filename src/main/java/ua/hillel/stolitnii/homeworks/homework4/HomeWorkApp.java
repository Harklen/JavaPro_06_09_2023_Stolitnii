package ua.hillel.stolitnii.homeworks.homework4;

public class HomeWorkApp {
    public static void main(String[] args) {
    printThreeWords();
    checkSumSign(5, 10);
    printColor(101);
    compareNumbers(5, 10);
    isSumBetween10And20(5, 8);
    isPositiveOrNegative(-9);
    isNumberInteger(5.5);
    printStringNTimes("Kurwa bober", 5);
    isLeapYear(1678);
    }


    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign(int a, int b) {
        int c = a + b;
        System.out.println(c >= 0 ? "Сума позитивна" : "Сума негативна");
    }

    public static void printColor(int value) {
        if (value <= 0) {
            System.out.println("Червоний");
        } else if (value > 0 && value <= 100) {
            System.out.println("Жовтий");
        } else {
            System.out.println("Зелений");
        }
    }

    public static void compareNumbers(int a, int b) {
        System.out.println(a >= b ? "a >= b" : "a < b");
    }

    public static boolean isSumBetween10And20(int a, int b) {
        int sum = a + b;
        boolean result = sum >= 10 && sum <= 20;
        return result;
    }
    public static void isPositiveOrNegative(int a) {
        System.out.println(a >= 0 ? "Додатнє" : "Від'ємне");
    }
    public static boolean isNumberInteger(double a) {
        boolean result = a % 1 == 0;
        return result;
    }

    public static void printStringNTimes(String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }
    public static boolean isLeapYear(int year){
        boolean result = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
        return result;
    }
}