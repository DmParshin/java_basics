//        Реализуйте удаление лишних символов при вводе номера телефона в консоли и проверку соответствия номера формату
//        мобильных номеров России. Если введённую строку нельзя привести к формату мобильного номера — выводите сообщение
//        о неверном вводе. Телефон может быть введён не только в формате 79091234567, но и с лишними символами.

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }

      input = input.replaceAll("[\\s+.,;()+-]", "");

      String[] stringArray = input.split("");

      if (stringArray.length == 11 && Integer.parseInt(stringArray[0]) == 7){
      }
      else if (stringArray.length == 11 && Integer.parseInt(stringArray[0]) == 8) {
        stringArray[0] = "7";
      }
      else if (stringArray.length == 10 && Integer.parseInt(stringArray[0]) == 9){
        String[] tempArray= new String[stringArray.length + 1];
        tempArray[0] = "7";
        for (int i = 0; i < stringArray.length; i++){
          tempArray[i + 1] = stringArray[i];
        }
        stringArray = tempArray;
      }
      else {
        System.out.println("Неверный формат номера");
        break;
      }
    String str = String.join("", stringArray);
    System.out.println(str);
    }
  }

}
