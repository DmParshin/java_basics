import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

public class CsvObjects {
    String typeAccount; //тип счета
    String numberAccount; //номер счета
    String currency; //валюта
    Date date; //дата операции
    String reference; //референс проводки
    String[] description;
    Double input; //приход
    Double output; //расход

    public CsvObjects(String string) throws ParseException {
        String[] fragments = string.split("(?!\\B\"[^\"]*),(?![^\"]*\"\\B)");
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
        if (fragments.length == 8) {
            typeAccount = fragments[0];
            numberAccount = fragments[1];
            currency = fragments[2];
            date = dateFormat.parse(fragments[3]);
            reference = fragments[4];
            description = fragments[5].split("\\s{4,}");
            input = Double.parseDouble(fragments[6].replace("\"","").replace(",","."));
            output = Double.parseDouble(fragments[7].replace("\"","").replace(",","."));
        }else
            System.out.println("Wrong line: " + string);

    }

    @Override
    public String toString() {
        return "CsvObjects{" +
                "typeAccount='" + typeAccount + '\'' +
                ", numberAccount='" + numberAccount + '\'' +
                ", currency='" + currency + '\'' +
                ", date=" + date +
                ", reference='" + reference + '\'' +
                ", description='" + Arrays.stream(description).map(String::toString).collect(Collectors.joining(" ")) + '\'' +
                ", input=" + input +
                ", output=" + output +
                '}';
    }
}
