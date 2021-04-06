import java.util.*;

public class EmailList {

    String pattern = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    TreeSet<String> emails = new TreeSet<>();

    public EmailList() { TreeSet<String> emails = new TreeSet<>();}

    public void add(String email) {
//        System.out.println(email);
        if( emails.contains(email)) {
            System.out.println(Main.EMAIL_IS_DUPLICATE + email);
        }
        else if( email.matches(pattern)){
            System.out.println(Main.EMAIL_IS_ADDED + email);
            this.emails.add(email.toLowerCase());
            }
        else {
//            System.out.println(email);
            System.out.println(Main.WRONG_EMAIL_ANSWER + email);}
    }

    public List<String> getSortedEmails() {
        ArrayList<String> emailList = new ArrayList<>();
        for (String email : emails) {
            System.out.println(email);
            emailList.add(email);
        }
        return emailList;
    }

}
