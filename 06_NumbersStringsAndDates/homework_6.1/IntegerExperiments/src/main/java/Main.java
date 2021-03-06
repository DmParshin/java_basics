public class Main {

  public static void main(String[] args) {
    Container container = new Container();
    container.count += 7843;

    Integer sum = sumDigits(7843);

    System.out.println(sum);
  }

  /* Реализуйте метод sumDigits который возвращает сумму цифр числа, пример:
  передано 12345, метод должен вернуть 15
  если передано null, то должен вернуть -1

  Запустите тесты TestSumDigits для проверки корректности работы метода

  не меняйте название метода, его возвращаемое значение и модификаторы доступа (public).
  В противном случае тестовый метод не сможет проверить ваш код
   */

//  public static int sumDigits(Integer number) {
//    if (number != null) {
//      String str = number.toString();
//      int sum = 0;
//      for (int i = 0; i < str.length(); i++) {
//        sum = sum + Integer.parseInt(String.valueOf(str.charAt(i)));
//      }
//      return sum;
//    }
//    else{
//      return -1;
//    }
//  }
  public static int sumDigits(Integer number) {
    if (number != null) {
      String str = number.toString();
      int sum = 0;
      for (int i = 0; i < str.length(); i++) {
        sum = sum + Character.getNumericValue(str.charAt(i));
      }
      return sum;
    }
    else{
      return -1;
    }
  }
}
