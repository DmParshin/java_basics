import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class XMLHandler extends DefaultHandler {

    private Voter voter;
    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private HashMap<Voter, Integer> voterCounts;

    public XMLHandler() {
        this.voterCounts = new HashMap<>();
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        try {
//            if(qName.equals("voter") && voter == null){
            if(qName.equals("voter")){
                Date birthDay = birthDayFormat.parse(attributes.getValue("birthDay"));
                voter = new Voter(attributes.getValue("name"), birthDay);
                DBConnection.countVoter(voter.getName(), attributes.getValue("birthDay"));
            }
//            else if(qName.equals("visit") && voter != null){
//                int count = voterCounts.getOrDefault(voter, 0);
//                voterCounts.put(voter, count + 1);
//            }
        } catch (ParseException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("voter")){
            voter = null;
        }
    }
    public void InsertToDB() throws SQLException {
        System.out.println("Parsing to DataBase...");
//        for (Voter voter : voterCounts.keySet()){
//            String date = new SimpleDateFormat("yyyy.MM.dd").format(voter.getBirthDay());
//            DBConnection.countVoter(voter.getName(), date);
//        }
        DBConnection.executeMultiInsert();
    }

    public void printVoters(){
        System.out.println("Voters: ");
        for (Voter voter : voterCounts.keySet()){
            System.out.println(voter.toString());
        }
    }

    public void printDuplicatedVoters() {
        System.out.println("Duplicated voters: ");
        for (Voter voter : voterCounts.keySet()){
            int count = voterCounts.get(voter);
            if(count > 1){
                System.out.println(voter.toString() + " - " + count);
            }
        }
    }
}
