import javax.naming.PartialResultException;

public class Main {

    public static void main(String[] args) {
        String line = "Каждый охотник желает знать, где сидит фазан";
        String[] strings = line.split(",?\\s+");
        String[] newArray =  ReverseArray.reverse(strings);
        for(String i : newArray){ System.out.println(i); }
    }
}
