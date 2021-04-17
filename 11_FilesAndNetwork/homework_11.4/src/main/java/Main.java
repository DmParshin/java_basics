import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;

public class Main {

    private static final String webSiteURL = "https://lenta.ru/"; //The url of the website. This is just an example

    private static final String folderPath = "images"; //The path of the folder that you want to save the images to

    public static void main(String[] args) {

            try {
                Document doc = Jsoup.connect(webSiteURL).get(); //Connect to the website and get the html
                Elements img = doc.getElementsByTag("img"); //Get all elements with img tag

                for (Element element : img) {
                    String src = element.absUrl("src"); //for each element get the srs url
                    System.out.println("-------------------------------------------------------------\nImage Found!");
                    System.out.println("src attribute is : "+src);
                    getImages(src);
                }

            } catch (IOException ex) {
                System.err.println("There was an error");
            }
        }

    private static void getImages(String src) throws IOException {

        String folder = null;

        int indexname = src.lastIndexOf("/"); //Exctract the name of the image from the src attribute

        if (indexname == src.length()) { src = src.substring(1, indexname); }

        indexname = src.lastIndexOf("/");
        String name = src.substring(indexname, src.length());

        System.out.println(name.substring(1) + " - file downloaded");

        URL url = new URL(src);
        InputStream in = url.openStream(); //Open a URL Stream

        OutputStream out = new BufferedOutputStream(new FileOutputStream( folderPath+ name));

        for (int b; (b = in.read()) != -1;) {
            out.write(b);
        }
        out.close();
        in.close();
    }
}