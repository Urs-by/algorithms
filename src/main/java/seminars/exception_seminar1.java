package seminars;

import java.util.ArrayList;
import java.util.List;

public class exception_seminar1 {
    //Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
    //Если длина массива меньше некоторого заданного минимума,
    // метод возвращает -1, в качестве кода ошибки, иначе - длину массива
    public static void main(String[] args) {

        int[] my_list = new int[]{1, 4, 8, 99, 7, 6};
        //System.out.println(getLengh(my_list, 7));
        //System.out.println(getindex(null, 6, 5));

        int[][] ints = new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 3, 1, 1}
        };

        //System.out.println(getCount(ints));

        Integer[] newArray = new Integer[]{2,4,6,8,9};
        checkArray(newArray);

    }

    private static int getLengh(int[] array, int limit) {
        if (array.length < limit) {
            return -1;
        } else {
            return array.length;
        }
    }

//Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
//Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
//1. если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
//2. если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
//3. если вместо массива пришел null, метод вернет -3
//4.Напишите метод, в котором реализуйте взаимодействие с пользователем.
//То есть, этот метод запросит искомое число у пользователя, вызовет первый,
//обработает возвращенное значение и покажет читаемый результат пользователю.
//Например, если вернулся -2, пользователь увидит сообщение: “Искомый элемент не найден”.

    private static int getindex(int[] array, int min, int arg) {


        if (array == null) {
            return -3;
        } else if (array.length < min) {
            return -1;
        } else {
            for (int i = 0; i < array.length; i++) {
                if (arg == array[i]) {
                    return i;
                }
            }
            System.out.println("искомый элемент не найден!");
            return -2;
        }
    }

    //Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
    //Необходимо посчитать и вернуть сумму элементов этого массива. При этом накладываем на метод 2 ограничения:
    //метод может работать только с квадратными массивами (кол-во строк = кол-ву столбцов),
    // и в каждой ячейке может лежать только значение 0 или 1.
    // Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке.

    private static int getCount(int[][] array) {
        if (isNotArgsCorrect(array)) {
            throw new RuntimeException("в массиве должны быть только 0 или 1");
        }
        if (isNotSquareArr(array)) {
            throw new RuntimeException("массив не квадратный");
        }
        int summ = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                summ += array[i][j];
            }
        }
        return summ;
    }

    private static boolean isNotSquareArr(int[][] array) {
        for (int[] elem : array) {
            if (elem.length != array.length) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNotArgsCorrect(int[][] array) {
        List<Integer> container = List.of(0, 1);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (!container.contains(array[i][j])) {
                    return true;
                }
            }
        }
        return false;
    }

    //Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента целочисленный одномерный массив.
    //Метод должен пройтись по каждому элементу и проверить что он не равен null. Реализуйте следующую логику:
    //1. Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом пользователя
    //2. Если null’ы встретились в нескольких ячейках, то идеально было бы все их “подсветить”

    private static void checkArray(Integer[] array) {

        List<Integer> index = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                index.add(i);
            }
        }
        if (index.size() != 0) {
            throw new RuntimeException("В массиве присутсвуют null  в индексах: " + index);
        }
        System.out.println("Массив не содержит null");


    }
}
