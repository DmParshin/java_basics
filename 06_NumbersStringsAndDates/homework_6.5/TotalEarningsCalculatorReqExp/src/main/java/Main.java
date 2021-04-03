//        Реализуйте получение суммы заработка каждого человека из текста регулярным выражением,
//        чтобы в конце программы рассчитывалась и распечатывалась общая сумма заработка людей.
//        В метод возможна передача любого сочетания имён и суммы зарплат в строке.

public class Main {

  public static void main(String[] args) {
//    calculateSalarySum("Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей");

  }

  public static int calculateSalarySum(String text){
    boolean hasDigit = text.matches(".*\\d+.*");
    if (hasDigit){
    text = text.replaceAll("[^0-9\\+\\s]", "");
    text = text.trim().replaceAll("\\s+\\B", "");
    int sum = 0;
    String[] sentences = text.split("[\\s+]");
      for (int i = 0; i < sentences.length; i++) {
        sum += Integer.parseInt(sentences[i]);
      }
      return sum;
    }
    else return 0;
  }
}