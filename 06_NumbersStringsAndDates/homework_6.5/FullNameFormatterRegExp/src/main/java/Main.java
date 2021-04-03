//        Напишите программу (аналог задания модуля 6.4), которая на входе через консоль принимает фамилию, имя и отчество
//        одной строкой (например, «Иванов Сергей Петрович») и выводит фамилию, имя и отчество отдельно в формате:
//
//        Фамилия: Иванов
//
//        Имя: Сергей
//
//        Отчество: Петрович
//
//        Валидная строка от пользователя, которую мы можем интерпретировать как Ф. И. О., должна содержать три слова,
//        состоящих из символов кириллицы, разделённых пробелом, может содержать дефис. Если строка не соответствует формату,
//        то  вывести в консоль: Введенная строка не является ФИО
//
//        Используйте для определения валидности строки регулярное выражение.

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      if (input.matches("[А-ЯA-Z][а-яa-zА-ЯA-Z\\-]{1,}\s+[А-ЯA-Z][а-яa-zА-ЯA-Z\\-]{1,}\s[А-ЯA-Z][а-яa-zА-ЯA-Z\\-]{1,}")){
//        System.out.println("Все ок!");
        String[] sentences = input.split("[\\s+]");
        for (int i = 0; i < sentences.length; i++) {
          switch (i){
            case 0:
              System.out.println("Фамилия: " + sentences[i]);
              break;
            case 1:
              System.out.println("Имя: " + sentences[i]);
              break;
            case 2:
              System.out.println("Отчество: " + sentences[i]);
              break;
          }
        }
      }
      else
        System.out.println("Введенная строка не является ФИО");
    }
  }
}