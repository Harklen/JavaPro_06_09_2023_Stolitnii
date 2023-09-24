package ua.hillel.stolitnii.homeworks.homework7;

class ArraySizeException extends Exception {
    public ArraySizeException(String message) {
        super(message);
    }
}

class ArrayDataException extends Exception {
    public ArrayDataException(String message) {
        super(message);
    }
}

public class ArrayValueCalculator {
    public static void main(String[] args) {
        String[][] array = {{"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "0", "12"},
                {"13", "14", "15", "16"}};

        try {
            System.out.println("Сума массиву: " + doCalc(array));
        } catch (ArraySizeException | ArrayDataException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    private static String doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        int sum = 0;
        if (array.length != 4) {
            throw new ArraySizeException("Массив не 4x4");
        }
        for (String[] strings : array) {
            if (strings.length != 4) {
                throw new ArraySizeException("Розмір масиву не 4x4");
            }
            for (String string : strings) {
                try {
                    Integer.parseInt(string);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Масив містить не цілі значення");
                }
                sum += Integer.parseInt(string);
            }
        }
        return String.valueOf(sum);
    }
}
