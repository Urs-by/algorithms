package Homework.ExceptionHW2;

import java.util.Scanner;

public class Task3 {

    //Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
    // Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
    public static void main(String[] args) {
        inputString();

    }

    private static void inputString() {

        System.out.println("Введите строковую информацию: ");
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        if (!inputStr.isEmpty()) {
            System.out.printf("Вы ввели: %s", inputStr);
            System.out.println();
            inputString();
        } else {
            System.out.println("Пустые строки вводить нельзя!");
            throw new RuntimeException("Вы вели пустую строку");
        }
    }
}
