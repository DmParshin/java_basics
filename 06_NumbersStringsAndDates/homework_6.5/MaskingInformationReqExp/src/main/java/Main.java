//        Реализовать метод
//
//        String searchAndReplaceDiamonds(String text, String placeholder),
//        который будет заменять в переданной строке String text всё содержимое скобок <> и сами
//        скобки на переданную строку в String placeholder, используя регулярные выражения. Учтите вариант,
//        когда необходимо заменить несколько замен <> в переданной строке.

public class Main {

    public static void main(String[] args) {
        System.out.println(searchAndReplaceDiamonds("<4008> 1234 <5678> 8912", "****"));
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
            text = text.replaceAll("<.{1,}?>", placeholder);
        return text;
    }
}