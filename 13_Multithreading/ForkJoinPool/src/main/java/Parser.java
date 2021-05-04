import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.RecursiveTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser extends RecursiveTask<LinkedHashMap<String, TreeSet>> {

    static int depth = 0;

    static LinkedHashMap<String, TreeSet> linksMap = new LinkedHashMap<>();

    static Pattern patternSubLevel = Pattern.compile(".+?\\/");

    private Pattern pattern;

    private String URL;

    public Parser(String url, Pattern pattern) {
        this.URL = url;
        this.pattern = pattern;
    }

    @Override
    protected LinkedHashMap<String, TreeSet> compute() {
        List<Parser>taskList = new ArrayList<>();
        TreeSet<String> tempTreeSet = new TreeSet();

        Document doc = null;
        try {
            doc = Jsoup.connect(URL)
                    .userAgent("Chrome/90.0.4430.93 Safari/537.36")
                    .referrer("http://www.google.com")
                    .timeout(5000)
                    .get();
        }
        catch (HttpStatusException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Elements links = doc.select("a[href]");

        for (Element link : links) {
            String absLink = link.attr("abs:href");
            Matcher matcher = pattern.matcher(absLink);
            if (matcher.matches()) {
                tempTreeSet.add(absLink);
            }
        }
        linksMap.put(URL, tempTreeSet);

        pattern = Pattern.compile(pattern.toString() + patternSubLevel.toString());

        depth++;
        if (depth < 4){
            for(String url:tempTreeSet){
                Parser task = new Parser(url, pattern);
                task.fork();
                taskList.add(task);
            }
        }

        for(Parser task:taskList){
            task.join();
        }

        return linksMap;
    }
}
