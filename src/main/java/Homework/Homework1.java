package Homework;

public class Homework1 {
    public static void main(String[] args) {
        int[] array = new int[]{112, 3, 16, 8, 10, 4, 1, 7, 19, 5,2,42};
        int res = sifting(array);
        System.out.println(res);
    }

    public static int sifting(int[] array) {
        int start = array.length / 2 - 1;

        for (int i = start; i >= 0; i--) {
            int parent = array[i];
            int leftChild = array[2 * i + 1];
            if (array.length == (2 * i + 2)) {
                System.out.printf(" start  : %d",leftChild);
                if (leftChild > parent) {
                    int temp = array[2 * i + 1];
                    array[2 * i + 1] = array[i];
                    array[i] = temp;
                }
            }else {

                int rightChild = array[2 * i + 2];
//                System.out.printf(" parent  : %d",parent);
//                System.out.println();
//                System.out.printf(" leftChild  : %d",leftChild);
//                System.out.println();
//                System.out.printf(" rightChild  : %d",rightChild);
//                System.out.println();
                if ((leftChild > rightChild) && (leftChild > parent)) {
                    int temp = array[2 * i + 1];
                    array[2 * i + 1] = array[i];
                    array[i] = temp;
//                    System.out.printf(" new parent : %d", array[i]);
//                    System.out.println();
                }

                if ((leftChild < rightChild) && (rightChild > parent)) {
                    int temp = array[i];
                    array[i] = array[2 * i + 2];
                    array[2 * i + 2] = temp;
//                    System.out.printf(" new parent : %d", array[i]);
//                    System.out.println();
                }
            }
        }
        return array[0];
    }
}
