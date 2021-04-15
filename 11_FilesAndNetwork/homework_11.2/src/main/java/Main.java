import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите исходную папку ");
                String srcdir = scanner.nextLine();
                System.out.println("Введите папку назначения ");
                String dstdir = scanner.nextLine();
                FileUtils.copyFolder(srcdir,dstdir);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("Ошибка ввода");
            }
        }
    }
}
