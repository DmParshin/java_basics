import java.util.Scanner;

public class Main {

    static final int BOX_IN_CONTAINER = 27;
    static final int CONTAINER_IN_TRUCK = 12;
    static final int BOX_IN_TRUCK = BOX_IN_CONTAINER * CONTAINER_IN_TRUCK;

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
                while ((numberOfBoxes - (containerCount * BOX_IN_CONTAINER) > 0) && x <= CONTAINER_IN_TRUCK) {
                    containerCount++;
                    System.out.println("\tКонтейнер: " + containerCount);
                    x++;
                    y = 1;
                    while ((numberOfBoxes > boxesCount) && y <= BOX_IN_CONTAINER) {
                        boxesCount++;
                        System.out.println("\t\tЯщик: " + boxesCount);
                        y++;
                    }
                }
            }
            while (trucksCount * BOX_IN_TRUCK < numberOfBoxes);

        }
        System.out.println("Необходимо:\nгрузовиков - " + trucksCount + " шт." + "\nконтейнеров - " + containerCount + " шт.");
    }
}
