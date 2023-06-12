package Homework.ExceptionHW3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// Данные для проверки:
// Петров Николай Васильевич
// Петров Водкин Кузьма Сергеевич 1995.03.29 +7345567987 m
// Петров-Водкин Кузьма Сергеевич 1995.03.29 +7345567987 m
// Петров-Водкин Кузьма Сергеевич 05.11.1878 нет m
// Петров-Водкин Кузьма Сергеевич 05.11.1878 70000000000 муж
// Петров-Водкин Кузьма Сергеевич 05.11.1878 70000000000 m


public class Main {
    public static void main(String[] args) throws MyFormatException {
        String data = enter();
        String[] array = data.split(" ");
        if (vereficationData(array)) {
            String surname = array[0];
            String birthDay = array[3];
            String phone = array[4];
            String sex = array[5];
            verificationDate(birthDay);
            verificationInt(phone);
            verificationChar(sex);
            // eсли файл с таким именем существуем производим дозапись, иначе новый файл
            write(surname + ".txt", array, existFile(surname + ".txt"));
        }
    }


    // метод ввода данных
    private static String enter() {
        Scanner enter = new Scanner(System.in);
        System.out.println("Введите фамилию, имя, отчество, дату рождения, номер телефона и пол!");
        System.out.println("""
                Форматы данных:
                фамилия, имя, отчество - строки
                дата рождения - строка формата dd.mm.yyyy
                номер телефона - целое беззнаковое число без форматирования
                пол - символ латиницей f или m \n""");
        return enter.nextLine();
    }

    // метод проверки длины введенных данных
    private static Boolean vereficationData(String[] array) {

        if (array.length < 6) {
            System.out.println("Вы ввели не все данные");
            throw new RuntimeException("не хватает данных!");
        } else if (array.length > 6) {
            System.out.println("Вы ввели лишние данные,проверьте количество пробелов");
            throw new RuntimeException("Много данных!");
        }
        return true;
    }

    // метод проверки формата номера телефона
    public static void verificationInt(String element) throws MyFormatException {
        try {
            Long.valueOf(element);
        } catch (Exception e) {
            System.out.println("Вы неправильно ввели номер телефона, номер телефона - целое беззнаковое число без форматирования");
            String string = "Номер телефона";
            throw new MyFormatException(string);

        }
    }

    // метод проверки типа Date
    private static void verificationDate(String element) throws MyFormatException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate date = LocalDate.parse(element, formatter);
        } catch (Exception e) {
            System.out.println("Вы неправильно ввели дату рождения, дата рождения - строка формата dd.mm.yyyy");
            String string = "Дата рождения";
            throw new MyFormatException(string);
        }
    }

    // Метод прооверки введенных символов пола
    private static void verificationChar(String element) throws MyFormatException {
        if (!element.equals("f") && !element.equals("m")) {
            System.out.println("Вы неправильно ввели пол, пол - символ латиницей f или m");
            String string = "Пол";
            throw new MyFormatException(string);
        }
    }

    // метод записи(дозаписи) данных в файл
    public static void write(String path, String[] array, Boolean append) {
        File file = new File(path);
        try (FileWriter writer = new FileWriter(file, append)) {
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

    // метод проверки наличия файла
    public static Boolean existFile(String path) {
        File file = new File(path);
        return file.isFile();
    }

}
