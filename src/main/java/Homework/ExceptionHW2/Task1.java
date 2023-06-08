package Homework.ExceptionHW2;

import java.util.Scanner;

public class Task1 {
    //Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
    // и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
    // вместо этого, необходимо повторно запросить у пользователя ввод данных.

    public static void main(String[] args) {
        inputFloat();

    }

    private static void inputFloat (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дробное число через запятую: ");


        if (!sc.hasNextFloat()) {
            System.out.println("Вы вели не дробное число, попробуйте снова");
            inputFloat();
        } else {
            System.out.println(sc.nextFloat());
        }

    }
}
