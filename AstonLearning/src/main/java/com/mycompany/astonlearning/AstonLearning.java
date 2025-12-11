package com.mycompany.astonlearning;


import java.util.Arrays;

public class AstonLearning {

    //1
   public static void printThreeWords() {
       System.out.println("Orange\nBanana\nApple");
   }

   //2
    public static void checkSumSign() {
        int a = 1;
        int b = -5;
        
        if (a + b > 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    //3
    public static void printColor() {
        int value = 66;
        
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");   
        } else {
            System.out.println("Зеленый");
        }
    }

    //4
    public static void compareNumbers() {
        int a = 5;
        int b = 9;
        
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    //5
     public static boolean sumTwoNumbers(int a, int b) { 
         
         if (a + b >= 10 && a + b <= 20) {
             return true;
         } else {
             return false;
         }
     }

     //6
     public static void meaningOfInt (int a) {
         
         if(a >= 0) {
             System.out.println("Положительное число");
         } else {
             System.out.println("Отрицательное число");
         }
     }

     //7
     public static boolean meaningOfIntBool(int a) { 
         
         if (a >= 0) {
             return true;
         } else {
             return false;
         }
     }

     //8
     public static void replayString (String text, int count) {
         int i = 0;
         while (i < count) {
             System.out.println(text);
             i++;
         }
     }

     //9
    public static boolean isLeapYear(int year) {

       return (year % 400 ==0) || (year % 4 == 0 && year % 100 != 0);
    }

    //14
    public static int[] createArray(int len, int initialValue) {
        int[] array14 = new int[len];
        for (int i = 0; i < len; i++) {
            array14[i] = initialValue;
        }
        System.out.println(Arrays.toString(array14));
        return array14;
    }

    public static void main(String[] args) {
       printThreeWords();
       checkSumSign();
       printColor();
       compareNumbers();
       System.out.println(sumTwoNumbers(2, 5));
       meaningOfInt(-7);
       System.out.println(meaningOfIntBool(-7));
       replayString ("Инна молодец", 2);
       System.out.println(isLeapYear(2004));
       int[] arr14 = createArray(2, 3);

       //10
        int[] array10 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array10.length ; i ++) {
            array10[i] = 1 - array10[i];
        }
        System.out.println(Arrays.toString(array10));

        //11
        int[] array11 = new
                int[100];
        for ( int i = 0; i < array11.length; i++) {
            array11[i] = i + 1;
        }
        System.out.println(Arrays.toString(array11));

        //12
        int[] array12 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array12.length; i++) {
            if (array12[i] < 6) {
                array12[i] = array12[i] * 2;
            }
        }
        System.out.println(Arrays.toString(array12));

        //13
        int size = 5;
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
            matrix [i][size -1 - i] = 1;
        }
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
            for (int[] row : matrix) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
    }
}

