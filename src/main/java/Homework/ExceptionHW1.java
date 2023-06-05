package Homework;

import java.util.Arrays;
import java.util.Scanner;

public class ExceptionHW1 {
    // Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

    public static void main(String[] args) {
        // задание 1
//        System.out.println("1-й метод, вызывающий ArithmeticException:");
//        System.out.println(arithmetic(3, 0));


//        System.out.println("2-й метод, вызывающий InputMismatchException:");
//        inputMismatch();


//        System.out.println("3-й метод, вызывающий ArrayIndexOutOfBoundsException");
//        System.out.println(indexOutOfBounds(8));

        ////задание 2
//        String[][] ints = new String[][]{
//                {"2147483647", "null", "0", "0", "0", "0", "0"},
//                {"2147483647", "0", "54", "23", "7", "3", "7"}
//        };
//        String[][] ints2 = new String[][]
//                {null};
//
//        System.out.println(sum2d(ints));

        //задание 3
        int[] a = new int[]{3,15,19,7,0};
        int[] b = new int[]{1,5,7};
        //System.out.println(Arrays.toString(difference(a,b)));

        //задание 4
        System.out.println(Arrays.toString(quotient(a,b)));



    }

    private static float arithmetic(int a, int b) {
        return a / b;
    }

    private static void inputMismatch() {
        Scanner in = new Scanner(System.in);
        System.out.println(" Для получения исключения введите букву: ");
        int num = in.nextInt();
    }

    private static int indexOutOfBounds(int index) {
        int[] my_list = new int[]{1, 4, 8, 99, 7, 6};
        return my_list[index];
    }

    //Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
//        public static int sum2d(String[][] arr) {
//            int sum = 0;
//            for (int i = 0; i < arr.length; i++) {
//                for (int j = 0; j < 5; j++) {
//                    int val = Integer.parseInt(arr[i][j]);
//                    sum += val;
//                }
//            }
//            return sum;
//        }


    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }
    // Исключения: NumberFormatException при не integer данных или больше int
    // ArrayIndexOutOfBoundsException при количестве элементов в массиве <6
    // NullPointerException при значениях массива null



    //Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
    // и возвращает новый массив, каждый элемент которого равен разности элементов
    // двух входящих массивов в той же ячейке. Если длины массивов не равны,
    // необходимо как-то оповестить пользователя.

    public static int[] difference(int[] a, int[]b) {
        int[] difference_list = new int[a.length];
        if (a.length != b.length) {
            System.out.println("Длинны массивов разные!");
            // или
            //throw new RuntimeException("Длинны массивов разные!");
        } else {
            for (int i = 0; i < a.length; i++) {
                difference_list[i] = a[i] - b[i];
            }
        }
        return difference_list;
    }

    //Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
    // и возвращающий новый массив, каждый элемент которого равен частному элементов
    // двух входящих массивов в той же ячейке. Если длины массивов не равны,
    // необходимо как-то оповестить пользователя. Важно: При выполнении метода единственное исключение,
    // которое пользователь может увидеть - RuntimeException, т.е. ваше.

    public static float[] quotient(int[] a, int[]b){
        if(a.length != b.length){
            throw new RuntimeException("Длинны массивов разные!");
        } else{
            float[] quotient_list = new float[a.length];
            for (int i = 0; i < a.length; i++) {
                quotient_list[i] = a[i]/b[i];
            }
            return quotient_list;
        }
    }
}
