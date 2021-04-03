import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 2010;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - EE",Locale.ENGLISH);

        Calendar todayDate = Calendar.getInstance();

        Calendar setCalendar = Calendar.getInstance();
        setCalendar.set(Calendar.YEAR, year);
        setCalendar.set(Calendar.DAY_OF_MONTH, day);
        setCalendar.set(Calendar.MONTH, month - 1);
        int d = 0;
        String str = "";
        while (setCalendar.before(todayDate) || setCalendar.equals(todayDate)) {
            str = str + (d + " - " + dateFormat.format(setCalendar.getTime()) + System.lineSeparator());
            setCalendar.set(Calendar.YEAR, year + d + 1);
            setCalendar.set(Calendar.DAY_OF_MONTH, day);
            setCalendar.set(Calendar.MONTH, month - 1);
            d++;
        }
        return str;
    }
}