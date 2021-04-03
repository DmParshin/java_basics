//        Реализовать метод, который принимает в качестве аргумента строку, содержащую английский текст (не менее 100 слов).
//        Метод должен разделить текст на слова и вернуть строку, состоящую из полученных слов, каждое слово на отдельной строке.

import java.awt.*;

public class Main {

  public static void main(String[] args) {
    splitTextIntoWords("Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей");
  }

  public static String splitTextIntoWords(String text) {
    text = text.replaceAll("[\n\\s+.,;-[0-9]]", " ");
    text = text.trim().replaceAll("\\s+\\B", "");
    text = text.replaceAll("[\\s]", "\n");
    return text;
  }

}