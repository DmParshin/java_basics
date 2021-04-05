import java.util.*;

public class EmailList {

    String pattern = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    TreeSet<String> emails = new TreeSet<>();

    public EmailList() { TreeSet<String> emails = new TreeSet<>();}

    public void add(String email) {
//        System.out.println(emailString);
        if( emails.contains(email)) {
            System.out.println("Дубликат - " + email);
        }
        else if( email.matches(pattern)){
//            System.out.println("Valid!");
            this.emails.add(email.toLowerCase());
            }
        else {
//            System.out.println(email);
            System.out.println(Main.WRONG_EMAIL_ANSWER);}
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
        ArrayList<String> emailList = new ArrayList<>();
        for (String email : emails) {
//            System.out.println(email);
            emailList.add(email);
        }
        return emailList;
    }

}
