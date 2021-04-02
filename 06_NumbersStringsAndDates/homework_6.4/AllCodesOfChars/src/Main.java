//Что нужно сделать
//
//        Создайте новый проект в 06_NumbersStringsAndDates/homework_6.4.
//        Напишите код, который распечатает коды всех букв английского алфавита и сами буквы.

public class Main {
    public static void main(String[] args) {
        for (char i = 'A'; i<='z'; i++){
            int c = i;
            System.out.println( i + " : " + c);
        }
    }
}
