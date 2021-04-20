
import metro.Line;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final String URL = "https://www.moscowmap.ru/metro.html";

    private static List<Line> lines = new LinkedList<>();

    public static void main(String[] args) throws IOException, ParseException {

        Document document = Jsoup.connect(URL).get();
        Elements elementsLines = document.select("span[class*=\"js-metro-line\"]");
        Elements elementsStations = document.select("div[class*=\"js-metro-stations\"]");


        Parser.parseLines(elementsLines);
        Parser.parseStation(elementsStations);


        Parser.createJsonFile();
        Parser.JsonParser();

    }
}
