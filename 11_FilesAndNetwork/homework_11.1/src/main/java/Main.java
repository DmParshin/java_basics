import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите путь до папки:");
            String path = scanner.nextLine();
            FileUtils.calculateFolderSize(path);
        }
    }
}
