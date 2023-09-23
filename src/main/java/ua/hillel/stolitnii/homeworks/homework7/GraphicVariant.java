package ua.hillel.stolitnii.homeworks.homework7;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static ua.hillel.stolitnii.homeworks.homework7.LoggerTestClass.*;
import java.io.*;
import java.util.Scanner;

public class GraphicVariant {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Калькулятор");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            CalculatorPanel calculatorPanel = new CalculatorPanel();
            frame.add(calculatorPanel);
            frame.pack();
            frame.setVisible(true);

            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    calculatorPanel.displayLog();
                }
            });
        });
    }
}

class CalculatorPanel extends JPanel {
    private JTextField firstNumberField;
    private JTextField secondNumberField;
    private JButton calculateButton;

    public CalculatorPanel() {
        createLogFile("log.txt");
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Введіть перше число: "));
        firstNumberField = new JTextField();
        add(firstNumberField);

        add(new JLabel("Оберіть операцію (+, -, *, /): "));
        JComboBox<String> operationComboBox = new JComboBox<>(new String[]{"+", "-", "*", "/"});
        add(operationComboBox);

        add(new JLabel("Введіть друге число: "));
        secondNumberField = new JTextField();
        add(secondNumberField);

        calculateButton = new JButton("Обчислити");
        add(calculateButton);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstNumberStr = firstNumberField.getText();
                String secondNumberStr = secondNumberField.getText();
                String operation = (String) operationComboBox.getSelectedItem();

                int a, b;
                try {
                    a = Integer.parseInt(firstNumberStr);
                    b = Integer.parseInt(secondNumberStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Введіть коректні числа.", "Помилка", JOptionPane.ERROR_MESSAGE);
                    writeLogMessage("ERROR", "User entered invalid numbers");
                    return;
                }

                writeLogMessage("INFO", "Calculator started");
                writeLogMessage("DEBUG", "User entered first " + a);
                writeLogMessage("DEBUG", "User choosed " + operation);
                writeLogMessage("DEBUG", "User entered second " + b);

                int result;
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
                            JOptionPane.showMessageDialog(null, "Помилка: Ділення на нуль.", "Помилка", JOptionPane.ERROR_MESSAGE);
                            writeLogMessage("ERROR", "Division by zero");
                            return;
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Помилка: Невідома операція.", "Помилка", JOptionPane.ERROR_MESSAGE);
                        writeLogMessage("ERROR", "Unknown operation");
                        return;
                }

                JOptionPane.showMessageDialog(null, "Результат: " + result, "Результат", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public void displayLog() {
        try {
            Scanner scanner = new Scanner(new File("log.txt"));
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
