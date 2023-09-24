package ua.hillel.stolitnii.homeworks.homework9;
import java.util.InputMismatchException;
import java.util.Scanner;
import static ua.hillel.stolitnii.homeworks.homework9.LoggerTestClass.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Результат: " + Calculator.calculator());
        readLogMessages();
        filterAndPrintLogMessages("INFO, DEBUG, ERROR");
    }
}

class Calculator {
    public static int calculator() {

        createLogFile("log.txt");
        writeLogMessage("INFO", "Calculator started");
        int result = 0, a = 0, b = 0;
        String operation;

        Scanner scanner = new Scanner(System.in);

        writeLogMessage("INFO", "Getting first number");
        do {
            try {
                System.out.print("Введіть перше число: ");
                a = scanner.nextInt();
                System.out.println("Ви ввели число: " + a);
                writeLogMessage("DEBUG", "User entered first " + a);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Ви ввели не ціле число. Будь ласка, введіть ціле число.");
                writeLogMessage("ERROR", "User entered not a number");
                scanner.nextLine();
            }
        } while (true);

        scanner.nextLine();
        do {
            System.out.print("Введіть операцію (+, -, *, /): ");
            operation = scanner.nextLine();
            if (!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/")) {
                System.out.println("Ви обрали не вірну операцію. Будь ласка, введіть операцію (+, -, *, /).");
                writeLogMessage("ERROR", "User entered wrong operation");
            } else {
                System.out.println("Ви обрали: " + operation);
                writeLogMessage("DEBUG", "User choosed " + operation);
                break;
            }
        } while (true);

        do {
            try {
                System.out.print("Введіть друге число: ");
                b = scanner.nextInt();
                System.out.println("Ви ввели число: " + b);
                writeLogMessage("DEBUG", "User entered second " + b);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Ви ввели не ціле число. Будь ласка, введіть ціле число.");
                writeLogMessage("ERROR", "User entered not a number");
                scanner.nextLine();
            }
        } while (true);

        switch (operation) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b != 0) {
                    result = a / b;
                } else {
                    System.out.println("Помилка: Ділення на нуль.");
                    writeLogMessage("ERROR", "Division by zero");
                }
                break;
            default:
                System.out.println("Помилка: Невідома операція.");
                writeLogMessage("ERROR", "Unknown operation");
        }

        scanner.close();
        return result;
    }
}
