package Homework;

public class Homework1 {
    public static void main(String[] args) {

        int[] array = new int[]{16, 18, 18, 4, 10, 3, 21 };
        System.out.print("исходный массив: ");
        printArray(array);
        System.out.println();
        // запуск в цикле поиска максимального числа в массиве методом просеивания
        for (int i = array.length-1; i >=0 ; i--) {
            sifting(array, i);
        }

        System.out.print("отсортированный массив: ");
        printArray(array);
    }

    // метод просеивания
    public static void sifting(int[] array, int len) {
        int start = (len+1 )/ 2 - 1;

        for (int i = start; i >= 0; i--) {

            int parent = array[i];
            int leftChild = array[2 * i + 1];
            // проверка длины массива и наличия правого Child
            if (len+1 == (2 * i + 2)) {
                // если Child болеше  Parent, то меняем  элементы местами
                if (leftChild > parent) {
                    int temp = array[2 * i + 1];
                    array[2 * i + 1] = array[i];
                    array[i] = temp;
                }
            // если правый  Child есть:
            }else {

                int rightChild = array[2 * i + 2];
                // если Parent меньше левого Child, то меняем  элементы местами
                if ((leftChild >= rightChild) && (leftChild > parent)) {
                    int temp = array[2 * i + 1];
                    array[2 * i + 1] = array[i];
                    array[i] = temp;
                }
                // если Parent меньше правого Child, то меняем  элементы местами
                if ((leftChild <= rightChild) && (rightChild > parent)) {
                    int temp = array[i];
                    array[i] = array[2 * i + 2];
                    array[2 * i + 2] = temp;
                }
            }
        }
        // меняем местами максимальный (первый элемент) с последним
        int temp = array[0];
        array[0] = array[len];
        array[len] = temp;

    }

    // метод вывода массива в консоль
    public  static void printArray(int[] array){

        for (int j : array) {
            System.out.printf("%d ,", j);
        }
    }
}
