import java.util.Arrays;
import java.util.List;

public class CsvObject {
    private String firstName;
    private String lastname;
    private int age;
    private List<String> courses;

    public CsvObject(String string) {
        String[] fragments = string.split("(?!\\B\"[^\"]*),(?![^\"]*\"\\B)");
        if (fragments.length == 3) {
            String[] nameArray = fragments[0].split("\s");
            firstName = nameArray[0];
            lastname = nameArray[1];
            age = Integer.valueOf(fragments[1]);
            courses = Arrays.stream((fragments[2].substring(1, fragments[2].length()-1).split("\\,"))).toList();
        }else
            System.out.println("Wrong line: " + string);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public List<String> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "CsvObject{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", courses=" + courses.toString() +
                '}';
    }
}
