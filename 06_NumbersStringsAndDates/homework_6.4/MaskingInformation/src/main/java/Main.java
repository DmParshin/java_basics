//        Пользователь вводит строку, в некоторой части которой содержится конфиденциальная информация. Ваша задача изменить
//        строку и скрыть информацию в < >.
//
//        Реализуйте метод String searchAndReplaceDiamonds(String text, String placeholder), который будет заменять в
//        переданной строке String text всё содержимое скобок <> (англ. diamonds) и сами скобки на переданную строку в
//        String placeholder.

public class Main {

    public static void main(String[] args) {
        //searchAndReplaceDiamonds("sd<as>df<sdf>sd", "kuku");
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
       for (int i = 0; i < text.length(); i++) {
           if (text.charAt(i) == '<'){
               for(int j = i; j < text.length(); j++){
                   if (text.charAt(j) == '>'){
                           String str = text.substring(i, j + 1);
                           text = text.replace(str, placeholder);
                           i = j + 1;
                   }
                   else if ((text.charAt(j) == '<')){
                       i = j;
                   }
               }
           }
       }
       //System.out.println("New string: " + text);
       return text;
    }

}