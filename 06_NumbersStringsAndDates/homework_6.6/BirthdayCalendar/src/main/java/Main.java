import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 2010;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - EE", new Locale("ENGLISH"));

        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();

        int d = 0;
        StringBuilder str = new StringBuilder();

        while (birthday.isBefore(today) || birthday.equals(today)) {
            str.append(d).append(" - ").append(birthday.format(formatter)).append(System.lineSeparator());
            birthday = birthday.plusYears(1);
            d++;
        }
        return str.toString();
    }
}