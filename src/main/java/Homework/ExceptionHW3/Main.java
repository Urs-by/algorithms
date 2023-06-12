package Homework.ExceptionHW3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyFormatException {
        String data = enter();
        String[] array = data.split(" ");
        if (vereficationData(array)) {
            String surname = array[1];
            String birthDay = array[3];
            String phone = array[4];
            System.out.println(phone);
            String sex = array[5];
            verificationDate(birthDay);
            verificationInt(phone);
            verificationChar(sex);
//            System.out.println(data.toString());
            if(existFile(surname+".txt")){
                write(surname+".txt", array, true);

            } else{
                write(surname+".txt", array, false);
            }
        }
    }



    private static String enter() {
        Scanner enter = new Scanner(System.in);
        System.out.println("Введите имя, фамилию, отчество, дату рождения, номер телефона и пол!");
        System.out.println("""
                Форматы данных:
                фамилия, имя, отчество - строки
                дата рождения - строка формата dd.mm.yyyy
                номер телефона - целое беззнаковое число без форматирования
                пол - символ латиницей f или m""");
        return enter.nextLine();
    }

    private static Boolean vereficationData(String[] array) {

        if (array.length < 6) {
            System.out.println("Вы ввели не все данные");
            throw new RuntimeException("не хватает данных!");
        } else if (array.length > 6) {
            System.out.println("Вы ввели лишние данные");
            throw new RuntimeException("Много данных!");
        }
        return true;
    }

    public static Boolean verificationInt(String element) throws MyFormatException {
        try {
            Long.valueOf(element);
            return true;
        } catch (Exception e) {
            String string = "Номер телефона";
            throw new MyFormatException(string);
        }
    }

    private static Boolean verificationDate(String element) throws MyFormatException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate date = LocalDate.parse(element, formatter);
            return true;
        } catch (Exception e) {
            String string = "Дата рождения";
            throw new MyFormatException(string);
        }
    }

    private static Boolean verificationChar(String element) throws MyFormatException {
        if (element.equals("f") || element.equals("m")) {
            return true;
        } else {
            String string = "Пол";
            throw new MyFormatException(string);
        }
    }

    public static void write(String path, String[] array, Boolean append) {
        File file = new File(path);
        try {
            FileWriter writer = new FileWriter(file, append);
            for (int i = 0; i < array.length; i++) {
                writer.write("<"+array[i]+">");
            }
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            System.err.println("Ошибка файловой системы");
        }
    }


    public static Boolean existFile(String path){
        File file = new File(path);
        if(file.isFile()){
            return true;
        }
        return  false;
    }


}
