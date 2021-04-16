import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    final static Path PATH = Path.of("files/movementList.csv");

    public static void main(String[] args) {
        if (Files.exists(PATH)) {
            Movements movements = new Movements(PATH.toString());
//            movements.csvObjectList.stream().forEach(csvObject -> System.out.println(csvObject.toString()));
            System.out.println("Сумма доходов: " + movements.getIncomeSum());
            System.out.println("Сумма расходов: " + movements.getExpenseSum());

            Map<String, List<CsvObjects>> costsByCompany = movements.csvObjectList.stream()
                    .collect(Collectors.groupingBy(csvObjects -> csvObjects.description[1]));
            System.out.println("Суммы расходов по организациям:");
            for(Map.Entry<String, List<CsvObjects>> item : costsByCompany.entrySet()){
                double sum = 0;
                for(CsvObjects csvObjects : item.getValue()){
//                    System.out.println("\t" + csvObjects.description[1] + " - " + csvObjects.input + " - " + csvObjects.output);
                    sum = sum + csvObjects.output;
                }
                System.out.println(item.getKey().replace("\\", " ") + " : " + sum );
            }

        }
        else {
            System.out.println("Файла не существует!");
        }

    }
}
