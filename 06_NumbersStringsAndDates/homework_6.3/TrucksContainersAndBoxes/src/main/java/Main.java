import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();
        int numberOfBoxes = Integer.parseInt(boxes) ;
        int x;
        int y;
        int trucksCount = 0;
        int containerCount = 0;
        int boxesCount = 0;
        if (numberOfBoxes > 0) {
            do {
                trucksCount++;
                System.out.println("Грузовик: " + trucksCount);
                x = 1;
                while((numberOfBoxes - (containerCount * 27) > 0) && x <= 12) {
                    System.out.println("\tКонтейнер: " + x);
                    containerCount++;
                    x++;
                    y = 1;
                    while ((numberOfBoxes > boxesCount) && y <= 27){
                        System.out.println("\t\tЯщик: " + y);
                        boxesCount++;
                        y++;
                    }
                }
            }
            while (trucksCount * 324 < numberOfBoxes);

            System.out.println("Необходимо:\nгрузовиков - " + trucksCount + " шт."+ "\nконтейнеров - " + containerCount + " шт.");
        }
    }

}
