//        Напишите код, который считает сумму заработка всех друзей.
//
//        Используйте методы indexOf(), lastIndexOf(), substring() и trim().
//
//        Использование регулярных выражений в данном задании не допускается.

public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    int startWord = 0;
    int endWord;
    int countWords = 0;
    int sum = 0;
    for (int i = 0; i < text.length(); i++){
      if (text.charAt(i) == ' ') {
        endWord = i;
        countWords++;
        String str = text.substring(startWord, endWord);
        startWord = i + 1;
        if (countWords == 3 || countWords == 7 || countWords == 12){
          sum = sum + (Integer.parseInt(str));
          startWord = i + 1;
        }
      }
    }
    System.out.println(sum);
  }
}