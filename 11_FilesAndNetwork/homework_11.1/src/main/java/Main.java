import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите путь до папки:");
                String path = scanner.nextLine();
                System.out.println("Folder Size (org.apache.commons.io): " + org.apache.commons.io.FileUtils.byteCountToDisplaySize(FileUtils.calculateFolderSize(path)));
                System.out.println("Folder Size (Files.walk stream): " + FileUtils.formatSize(FileUtils.calculateFolderSizeWalk(path)));
            }
            catch (Exception e){
                System.out.println("Нет такой папки или папка недоступна");
            }
        }
    }
}
