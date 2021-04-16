import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Movements {

    List<CsvObjects> csvObjectList = new ArrayList<>();
    int countLines = 0;

    public Movements(String pathMovementsCsv) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathMovementsCsv));
            for (String line : lines) {
                String[] fragments = line.split(",");
                if (fragments.length < 8 || !fragments[0].toString().equals("Текущий счёт")) {
//                    System.out.println("Wrong line: " + fragments.length + " line - " + countLines);
                    continue;
                }
                else {
                    csvObjectList.add(new CsvObjects(line));
                }
                countLines++;
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            }
    }

    public void print(){
        for (CsvObjects items : csvObjectList){
            System.out.println(items.toString());
        }
    }

    public double getExpenseSum() {
        double expenseSum = 0;
        for (CsvObjects items : csvObjectList){
            expenseSum = csvObjectList.stream().mapToDouble(value -> value.output).sum();
        }
        return expenseSum;
    }

    public double getIncomeSum() {
        double incomeSum = 0;
        for (CsvObjects items : csvObjectList){
            incomeSum = csvObjectList.stream().mapToDouble(value -> value.input).sum();
        }
        return incomeSum;
    }
}
