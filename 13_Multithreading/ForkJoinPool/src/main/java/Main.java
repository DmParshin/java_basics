import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.regex.Pattern;

public class Main {

    static String tab;

    static final String URL = "https://skillbox.ru/";

    static Pattern pattern = Pattern.compile("https\\:\\/\\/skillbox.ru\\/");

    static Map<String, TreeSet> linksMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        linksMap = new ForkJoinPool().invoke(new Parser(URL, pattern));

        FileWriter writer = new FileWriter("files/parser.txt", true);
        System.out.println(URL);
        writer.write(URL + "\n");
        writer.flush();
        for(Object value:linksMap.get(URL)){
            System.out.println("\t" + value);
            writer.write("\t" + value + "\n");
            writer.flush();
            tab = "\t";
            printMap(value.toString(), tab);
        }
    }

    public static void printMap(String string, String tab) throws IOException {
        try(FileWriter writer = new FileWriter("files/parser.txt", true))
        {
            tab = tab + "\t";
            for(String key:linksMap.keySet()){
                if (string == key){
                    for(Object value:linksMap.get(key)) {
                        System.out.println(tab + value.toString());
                        writer.write(tab + value.toString() + "\n");
                        writer.flush();
                        printMap(value.toString(), tab);
                    }
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
