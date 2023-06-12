package Homework.ExceptionHW3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// Данные для проверки:
// Николай Петров Васильевич
// Кузьма Петров Водкин Сергеевич 1995.03.29 +7345567987 m
// Кузьма Петров-Водкин Сергеевич 1995.03.29 +7345567987 m
// Кузьма Петров-Водкин Сергеевич 05.11.1878 нет m
// Кузьма Петров-Водкин Сергеевич 05.11.1878 70000000000 муж
// Кузьма Петров-Водкин Сергеевич 05.11.1878 70000000000 m


public class Main {
    public static void main(String[] args) throws MyFormatException {
        String data = enter();
        String[] array = data.split(" ");
        if (vereficationData(array)) {
            String surname = array[1];
            String birthDay = array[3];
            String phone = array[4];
            String sex = array[5];
            verificationDate(birthDay);
            verificationInt(phone);
            verificationChar(sex);
            // eсли файл с таким именем существуем производим дозапись? иначе новый файл
            write(surname+".txt", array, existFile(surname + ".txt"));
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
                пол - символ латиницей f или m \n""");
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

    public static void verificationInt(String element) throws MyFormatException {
        try {
            Long.valueOf(element);
        } catch (Exception e) {
            String string = "Номер телефона";
            throw new MyFormatException(string);
        }
    }

    private static void verificationDate(String element) throws MyFormatException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate date = LocalDate.parse(element, formatter);
        } catch (Exception e) {
            String string = "Дата рождения";
            throw new MyFormatException(string);
        }
    }

    private static void verificationChar(String element) throws MyFormatException {
        if (!element.equals("f") && !element.equals("m")) {
            String string = "Пол";
            throw new MyFormatException(string);
        }
    }

    public static void write(String path, String[] array, Boolean append){
        File file = new File(path);
        try (FileWriter writer = new FileWriter(file, append)){
            for (String s : array) {
                writer.write("<" + s + ">");
            }
            writer.write("\n");
            writer.flush();
            System.out.println("Данные успешно сохранены!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Boolean existFile(String path){
        File file = new File(path);
        return file.isFile();
    }

}
