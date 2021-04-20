import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import metro.Line;
import metro.Metro;
import metro.Station;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Parser {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private static String FILE = "files//json.json";

    private static List<Line> lines = new LinkedList<>();
    private static Map<String, List<String>> stations = new LinkedHashMap<>();
    private static Metro metro;

    static void createJsonFile() throws IOException {
        metro = new Metro(Parser.lines, Parser.stations);
        try (FileWriter file = new FileWriter(FILE)) {
            file.write(GSON.toJson(metro));
        }
    }

    static void parseLines(Elements elementsLines) {
        for(Element elementLine:elementsLines){
            Line tempLine = new Line(elementLine.attr("data-line"), elementLine.text());
            lines.add(tempLine);
        }
    }

    static void parseStation(Elements elementsStations) {
        int i = 0;
        for (String element : elementsStations.eachText()) {
            List tempList = (Arrays.stream(element.split("\\b\\d\\.\\s|\\s\\d{1,2}\\.\\s"))
                    .filter(s -> s.length() > 1)
                    .collect(Collectors.toList()));
            int j = 0;
            for (Line line : lines) {
                if (j == i) {
                    stations.put(line.getId(), tempList);
                }
                j++;
            }
            i++;
        }
    }

    static String parseFile(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> stringBuilder.append(line).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    static void JsonParser() throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(parseFile(FILE));
        stations = (Map<String, List<String>>) jsonObject.get("stations");
        System.out.println("Количество станций на линиях:");
        for (Line line : lines) {
            for (String lineId : stations.keySet()) {
                JSONArray stationsArray = (JSONArray) stations.get(lineId);
                if (lineId.equals(line.getId())) {
                    System.out.println(lineId + "." + line.getName() + " - " + stationsArray.size());
                }
            }
        }
    }
}

