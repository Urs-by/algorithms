package Homework;


public class Homework2 {


    public static void main(String[] args) {

        Linked node = new Linked();
        node.add(2);
        node.add(5);
        node.add(7);
        node.add(9);

        System.out.println("Исходный список: ");
        node.print();

        node.reverse();

        System.out.println("Реверсивный список: ");
        node.print();
    }

    public static class Node {
        int value;
        Node next;
        Node previus;
    }

    public static class Linked {
        Node head;
        Node tail;

        public void add(int value) {
            Node newNode = new Node();
            newNode.value = value;
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) current = current.next;
                current.next = newNode;
                current.previus = tail;
                tail.next = newNode;
            }
            tail = newNode;
        }

        public void reverse() {
            Node previus = null;
            Node current = head;
            Node next;

            while (current != null) {
                next = current.next;
                current.next = previus;
                previus = current;
                current = next;
            }

            head = previus;
        }


        public void print() {
            Node current = head;
            while (current != null) {
                System.out.printf("%d | ", current.value);
                current = current.next;
            }
            System.out.println();
        }

    }

}