//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String [][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        String [][] incorrectArray = {
                {"1", "2", "3", "a"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        String [][] invalidSizeArray = {
                {"1", "2", "3"},
                {"5", "6", "7"}
        };
        try {
            System.out.println("Сумма элементов корректного массива: " + workWithArray(correctArray))
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage()");
        }
        try {
            System.out.println("Сумма элементов некорректного массива: " + workWithArray(incorrectArray));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            System.out.println("Сумма элементов массива неверного размера: " + workWithArray(invalidSizeArray));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        }
    generateArrayIndexOutOfBounds();

    public static int workWithArray (String [][] array) {
        if (array.length != 4 || array[0].length != 4) {
            throw new IllegalArgumentException("Размер массива должен быть 4x4");
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Неверные данные в ячейке [" + i + "][" + j + "]: " + array[i][j]);
                }
            }
        }
        return sum;
    }

    private static void generateArrayIndexOutOfBounds() {
        int[] arr = new int[5];
        try {
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}