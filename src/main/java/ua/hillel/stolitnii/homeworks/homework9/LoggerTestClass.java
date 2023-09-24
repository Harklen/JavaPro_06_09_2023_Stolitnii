package ua.hillel.stolitnii.homeworks.homework9;
import java.io.*;

public class LoggerTestClass {

    public static void createLogFile(String fileName) {
        try {
            File logFile = new File(fileName);
            if (logFile.createNewFile()) {
                System.out.println("Файл " + fileName + " створено.");
            } else {
                System.out.println("Файл " + fileName + " вже існує.");
                System.out.println("Видаляємо старий лог " + fileName);
                     logFile.delete();
                    }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeLogMessage(String level, String message) {
        try (FileWriter writer = new FileWriter("log.txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(level + ": " + message);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readLogMessages() {
        try (BufferedReader reader = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void filterAndPrintLogMessages(String logLevel) {
        try (BufferedReader reader = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(logLevel)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
