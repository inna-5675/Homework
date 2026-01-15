public class Main {

    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        
        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "seven", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            System.out.println("Сумма элементов: " + sumArray(array));
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера массива: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }

        System.out.println("\n--- Тест ArrayIndexOutOfBoundsException ---");
        testArrayIndexOutOfBounds();

        System.out.println("\n--- Тест с массивом неверного размера ---");
        try {
            sumArray(wrongSizeArray);
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException: " + e.getMessage());
        }

        System.out.println("\n--- Тест с неверными данными ---");
        try {
            sumArray(wrongDataArray);
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException: " + e.getMessage());
        }
    }

    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Размер массива по строкам должен быть 4, а является: " + array.length);
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException(
                        String.format("Размер строки %d должен быть 4, а является: %d", i, array[i].length)
                );
            }

            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            String.format("Неверные данные в ячейке [%d][%d]: '%s'", i, j, array[i][j])
                    );
                }
            }
        }
        return sum;
    }

    public static void testArrayIndexOutOfBounds() {
        int[] numbers = {1, 2, 3, 4, 5};

        try {
            System.out.println("Число по индексу 10: " + numbers[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException перехвачено: " + e.getMessage());
            System.out.println("Размер массива: " + numbers.length);
            System.out.println("Индексы доступны: 0-" + (numbers.length - 1));
        }

        String[][] matrix = new String[3][3];
        try {
            matrix[5][5] = "test";
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException в двумерном массиве: " + e.getMessage());
        }
    }
}