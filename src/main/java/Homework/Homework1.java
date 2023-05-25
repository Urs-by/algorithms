package Homework;

public class Homework1 {
    public static void main(String[] args) {

        int[] array = new int[]{16, 18, 18, 4, 10, 3, 21 };
        System.out.print("исходный массив: ");
        printArray(array);
        System.out.println();
        for (int i = array.length-1; i >=0 ; i--) {
            sifting(array, i);
//            printArray(array);
//            System.out.println();
        }
        System.out.println();
        System.out.print("отсортированный массив: ");
        printArray(array);
    }

    public static int[] sifting(int[] array, int len) {
        int start = (len+1 )/ 2 - 1;

        for (int i = start; i >= 0; i--) {
            //System.out.printf(" start  : %d",start);
            int parent = array[i];
//            System.out.printf(" parent  : %d",parent);
//            System.out.println();
            int leftChild = array[2 * i + 1];
            if (len+1 == (2 * i + 2)) {
//                System.out.printf(" leftChild  : %d",leftChild);
//                System.out.println();
                if (leftChild > parent) {
                    int temp = array[2 * i + 1];
                    array[2 * i + 1] = array[i];
                    array[i] = temp;
//                    System.out.printf(" newparent  : %d",temp);
//                    System.out.println();
//                    printArray(array);
//                    System.out.println();

                }
            }else {

                int rightChild = array[2 * i + 2];

//                System.out.printf(" leftChild  : %d",leftChild);
//                System.out.println();
//                System.out.printf(" rightChild  : %d",rightChild);
//                System.out.println();
                if ((leftChild >= rightChild) && (leftChild > parent)) {
                    int temp = array[2 * i + 1];
                    array[2 * i + 1] = array[i];
                    array[i] = temp;
//                    System.out.printf(" new parent : %d", array[i]);
//                    System.out.println();
//                    printArray(array);
//                    System.out.println();
                }

                if ((leftChild <= rightChild) && (rightChild > parent)) {
                    int temp = array[i];
                    array[i] = array[2 * i + 2];
                    array[2 * i + 2] = temp;
//                    System.out.printf(" new parent : %d", array[i]);
//                    System.out.println();
                }
            }
        }
        int temp = array[0];
        array[0] = array[len];
        array[len] = temp;
        //printArray(array);
        return array;

    }
    public  static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ,",array[i]);
        }
    }



}
