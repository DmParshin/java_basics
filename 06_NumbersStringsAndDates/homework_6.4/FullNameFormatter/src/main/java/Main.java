//Напишите программу, которая на входе через консоль принимает фамилию, имя и отчество одной строкой
// (например, «Иванов Сергей Петрович») и выводит фамилию, имя и отчество отдельно в формате:
//
//        Фамилия: Иванов
//
//        Имя: Сергей
//
//        Отчество: Петрович
//
//        Валидная строка от пользователя, которую мы можем интерпретировать как Ф. И. О.,
//        должна содержать три слова, состоящих из символов кириллицы, разделённых пробелом, может содержать дефис.
//        Если строка не соответствует формату, то вывести в консоль: Введенная строка не является ФИО
//
//        Использование регулярных выражений в данном задании не допускается.
//
//        Строго соблюдайте формат вывода результата.

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    String surname = "";
    String name = "";
    String patronymic = "";

    int c = 0;

    while (true) {
      String input = scanner.nextLine();
      int countWords = 0;
      int startWord = 0;
      int endWord;

      if (input.equals("0")) {
        break;
      }
      for (int i = 0; i < input.length(); i++){
        c = input.charAt(i);
        if ((c >= 1040 && c <= 1103 ) || c == 32 || c == 45) {
            if (c == 32 || i == (input.length() - 1) ){
            endWord = i;
            countWords++;
            //String str = input.substring(startWord, endWord);
            switch (countWords) {
                case (1):
                  surname = (input.substring(startWord, endWord));
                  startWord = endWord + 1;
                  break;
                case (2):
                  name = (input.substring(startWord, endWord));
                  startWord = endWord + 1;
                  break;
                case (3):
                  patronymic = (input.substring(startWord, endWord + 1));
                  startWord = endWord + 1;
                  break;
              }
            }
        }
      }
      if (countWords == 3) {
        System.out.println("Фамилия: " + surname + "\nИмя: " + name + "\nОтчество: " + patronymic);
      }
      else
        System.out.println("Введенная строка не является ФИО ");
    }
  }

}