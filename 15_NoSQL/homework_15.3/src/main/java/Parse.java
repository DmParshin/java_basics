import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parse {
    List<CsvObject> csvObjectList = new ArrayList<>();

    public Parse(String fileCSV) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileCSV));
        for (String line : lines) {
            csvObjectList.add(new CsvObject(line));
        }
    }

    public List<CsvObject> getCsvObjectList() {
        return csvObjectList;
    }

    public void print(){
        for (CsvObject csvObject : csvObjectList){
            System.out.println(csvObject.toString());
        }
    }
}
