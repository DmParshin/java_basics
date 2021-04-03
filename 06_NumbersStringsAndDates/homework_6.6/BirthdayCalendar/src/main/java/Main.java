import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        int day = 18;
        int month = 8;
        int year = 1987;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - EEEE");
        Calendar calendar = Calendar.getInstance();
        int d = 0;
        for (int i = 1987; i < 2021; i++){
            calendar.set(Calendar.YEAR, i);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            calendar.set(Calendar.MONTH, month - 1);
            System.out.println(d + " - " + dateFormat.format(calendar.getTime()));
            d++;
        }
        return "";
    }
}
