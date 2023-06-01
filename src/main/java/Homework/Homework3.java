package Homework;

import seminars.seminar4;

public class Homework3 {
    public class RedBlackTree {
        private Node start;

        private class Node {
            private int value;
            private boolean red;
            private Node leftChild;
            private Node rightChild;
        }

        // метод swap для замены 2х красных цветов
        private void swap(Node node) {
            node.leftChild.red = false;
            node.rightChild.red = false;
            node.red = true;
        }

        // метод малого левого поворота
        private Node leftTurn(Node node) {
//              node(5)                                   node(5)
//              /     \                                      /  \
//        leftNode                                         (3)   ()
//          (1)                 temp = (3)                /  \
//        /     \                                            (5)
//           leftNode.rightChild
//                (3)
//
            //leftNode присваиваем 1
            Node leftNode = node.leftChild;
            // в temp кладем 3
            Node temp = leftNode.rightChild;
            // вместо 3 ставим 5
            leftNode.rightChild = node;
            // вместо 1 ставим 3
            node.leftChild = temp;
            // красим в красный и возвращаем ее
            leftNode.red = node.red;
            node.red = true;
            return leftNode;
        }

        // метод правого малого поворота
        private Node rightTurn(Node node) {
            Node righNode = node.rightChild;
            Node temp = righNode.leftChild;
            righNode.leftChild = node;
            node.rightChild = temp;
            righNode.red = node.red;
            node.red = true;
            return righNode;
        }

        // метод ребалансировки
        private Node rebalance(Node node) {
            Node result = node;
            boolean balance;
            do {
                balance = false;
                if (result.rightChild != null && result.rightChild.red &&
                        (result.leftChild == null || !result.leftChild.red)) {
                    balance = true;
                    result = rightTurn(result);
                }
                if (result.leftChild != null && result.leftChild.red &&
                        result.leftChild.leftChild != null && result.leftChild.leftChild.red) {
                    balance = true;
                    result = leftTurn(result);
                }
                if (result.leftChild != null && result.leftChild.red && result.rightChild != null && result.rightChild.red) {
                    balance = true;
                    swap(result);
                }
            } while (balance);
            return result;
        }

        // метод добавления элемента в бинарное дерево
        public boolean addNode(int value) {
            Node currentNode = start;
            while (currentNode != null) {
                if (currentNode.value == value) {
                    return false;
                } else {
                    if (value > currentNode.value) {
                        if (currentNode.leftChild != null) {
                            currentNode.leftChild = rebalance(currentNode.leftChild);
                            currentNode = currentNode.rightChild;
                        } else {
                            currentNode.leftChild = new Node();
                            currentNode.leftChild.red = true;
                            currentNode.leftChild.value = value;
                            return true;
                        }

                    } else {
                        if (currentNode.rightChild != null) {
                            currentNode.rightChild = rebalance(currentNode.rightChild);
                            currentNode = currentNode.rightChild;
                        } else {
                            currentNode.rightChild = new Node();
                            currentNode.rightChild.red = true;
                            currentNode.rightChild.value = value;
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        // метод проверки и создания корневого элемента дерева
        public boolean addRoot(int value) {
            if (start != null) {
                boolean result = addNode(value);
                start = rebalance(start);
                start.red = false;
                return result;
            } else {
                start = new Node();
                start.red = false;
            }
            return true;
        }

        // метод поиска элемента в бинарном дереве
        public boolean find(int value){
            Node currentNode = start;
            while (currentNode != null){
                if(currentNode.value == value)return true;
                else if(value > currentNode.value){
                    currentNode = currentNode.rightChild;
                }
                else{
                    currentNode = currentNode.leftChild;
                }
            }
            return false;
        }
    }
}
