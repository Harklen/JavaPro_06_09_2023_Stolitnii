package ua.hillel.stolitnii.homeworks.homework14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Server {

    public static void main(String[] args) {
        int portNumber = 8081;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Waiting for client connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String greeting = in.readLine();
            System.out.println("Client sent: " + greeting);

            if (containsRussianLetters(greeting)) {
                out.println("що таке паляниця?");
                String response = in.readLine();
                if (response != null && response.equalsIgnoreCase("пирог")) {

                    LocalDateTime currentDateTime = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String formattedDateTime = currentDateTime.format(formatter);
                    out.println("Current date and time: " + formattedDateTime);
                    out.println("Goodbye!");
                } else {
                    out.println("Incorrect answer. Disconnecting.");
                }
            } else {
                out.println("Привіт!");
                out.println("Goodbye!");
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean containsRussianLetters(String text) {
        return text.matches(".*[а-яА-Я].*");
    }
}
