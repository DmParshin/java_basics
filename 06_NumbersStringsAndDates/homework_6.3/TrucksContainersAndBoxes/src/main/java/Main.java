import java.awt.*;
import java.util.Scanner;

public class Main {

    static final int boxInContainer = 27;
    static final int containerInTruck = 12;
    static final int boxInTruck = boxInContainer * containerInTruck;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();
        int numberOfBoxes = Integer.parseInt(boxes);
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
                while ((numberOfBoxes - (containerCount * boxInContainer) > 0) && x <= containerInTruck) {
                    containerCount++;
                    System.out.println("\tКонтейнер: " + containerCount);
                    x++;
                    y = 1;
                    while ((numberOfBoxes > boxesCount) && y <= boxInContainer) {
                        boxesCount++;
                        System.out.println("\t\tЯщик: " + boxesCount);
                        y++;
                    }
                }
            }
            while (trucksCount * boxInTruck < numberOfBoxes);

        }
        System.out.println("Необходимо:\nгрузовиков - " + trucksCount + " шт." + "\nконтейнеров - " + containerCount + " шт.");
    }
}
