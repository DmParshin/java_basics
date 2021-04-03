//        Пользователь вводит строку, в некоторой части которой содержится конфиденциальная информация. Ваша задача изменить
//        строку и скрыть информацию в < >.
//
//        Реализуйте метод String searchAndReplaceDiamonds(String text, String placeholder), который будет заменять в
//        переданной строке String text всё содержимое скобок <> (англ. diamonds) и сами скобки на переданную строку в
//        String placeholder.

public class Main {

    public static void main(String[] args) {
        searchAndReplaceDiamonds("sd<as>df<sdf>sd", "kuku");
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        System.out.println(text.indexOf('<'));
        System.out.println(text.indexOf('>'));

        while (text.indexOf('<') > 0 && text.indexOf('>') > 0) {
            String str = text.substring(text.indexOf('<'), text.indexOf('>') + 1);
            text = text.replace(str, placeholder);
            System.out.println(text);
        }
       return text;
    }

}