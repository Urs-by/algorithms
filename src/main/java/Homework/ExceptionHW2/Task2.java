package Homework.ExceptionHW2;

import java.io.FileNotFoundException;

public class Task2 {
    //Задание 2.1
    public static void main(String[] args) {
        System.out.println("Ррезультат выполнения первой функции :");
        task2_1();
        System.out.println("Ррезультат выполнения второй функции :");
        task2_2();

    }

    private static void task2_1() {
        try {
            int d = 0;
            int[] intArray = null;

            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);

            // добавим отдельное исключение IndexOutOfBoundsException
            // и NullPointerException для нулевого массива

//        } catch (IndexOutOfBoundsException e){
//            System.out.println("Указанный элемент за пределами массива");

        } catch (IndexOutOfBoundsException | ArithmeticException | NullPointerException e) {

            System.out.println("Catching exception: " + e);
        }
    }

    private static void task2_2() {

        try {
            int a = 90;
            int b = -7;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc= {1,3};
            abc[3] = 9;

        // в исходном коде необходимо вынести catch (Throwable ex) в конец,
        // иначе другие исключения никогда не сработают.
        // можно добавить арифметические исключения, так как код исполняется последовательно,
        // то первая -  это проверка на ноль
        } catch (ArithmeticException ex){
            System.out.println("На ноль делить нельзя!");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    private static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }
}
