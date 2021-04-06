import java.util.Scanner;

public class UserInput {

    public static String getLine(){
        System.out.println("PLEASE ENTER COMMAND (" + Main.COMMAND_ADD + " email" + " or " + Main.COMMAND_LIST + ")");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }
}
