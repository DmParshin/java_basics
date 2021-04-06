import java.util.Scanner;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Email is not valid, Email is not added: ";
    public static final String EMAIL_IS_DUPLICATE = "Email is duplicate, Email is not added: ";
    public static final String EMAIL_IS_ADDED = "Email is valid, Email added: ";
    public static final String COMMAND_ADD = "ADD";
    public static final String COMMAND_LIST = "LIST";
    public static final String WRONG_COMMAND = "WRONG COMMAND, TRY AGAIN";

    public static void main(String args[]) {
        EmailList emailList = new EmailList();
        for (; ; ) {
            String userInput = UserInput.getLine();
            if (userInput.startsWith(COMMAND_ADD)) {
                emailList.add(userInput.replaceFirst(COMMAND_ADD, "").trim());
            } else if (userInput.equals(COMMAND_LIST)) {
                emailList.getSortedEmails();
            } else {
                System.out.println(WRONG_COMMAND);
            }
        }
    }
}
    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        EmailList emailList = new EmailList();
//
//        while (true) {
//            String input = scanner.nextLine();
//            if (input.equals("0")) {
//                break;
//            }
//            if (input.substring(0, 3).equals("ADD")){
////                System.out.println("ADD ");
//                emailList.add(input.substring(4));
//            }
//            else if (input.substring(0, 4).equals("LIST")){
////                System.out.println("LIST");
//                emailList.getSortedEmails();
//            }
//        }
//    }
//}
