import java.util.*;

public class CoolNumbers {

    public static final String[] PATTERN = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
    public static long startTime;
    public static long endTime;

    public static List<String> generateCoolNumbers() {
        ArrayList<String> numbers = new ArrayList<>();
        String number = "";
        for (String n1 : PATTERN){
            for (int n2 = 0; n2 <=9; n2++ ){
                for (String n3 : PATTERN){
                    for (String n4 : PATTERN){
                        for (int n5 = 0; n5 <=1; n5++){
                            for (int n6 = 0; n6 <= 9; n6++) {
                                for (int n7 = 0; n7 <= 9; n7++) {
                                    number = (n1 + n2 + n2 + n2 + n3 + n4 + n5 + n6 + n7);
                                    numbers.add(number);
//                                    System.out.println(number);
                                }
                            }
                        }
                    }
                }

            }
        }
        return numbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        startTime = System.nanoTime();
        for (String i : list) {
            if (i.equals(number)){
                endTime = System.nanoTime();
                System.out.println("Поиск перебором: номер найден, поиск занял: " + (endTime - startTime));
            }
        }
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        Collections.sort(sortedList);
        startTime = System.nanoTime();
        if (Collections.binarySearch(sortedList, number) > 0 ){
            endTime = System.nanoTime();
            System.out.println("Бинарный поиск: номер найден, поиск занял: " + (endTime - startTime));
        }else System.out.println("Бинарный поиск: Элемент не найден!");
        return false;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        startTime = System.nanoTime();
        if (hashSet.contains(number)){
            endTime = System.nanoTime();
            System.out.println("Поиск в HashSet: номер найден, поиск занял: " + (endTime - startTime));
        }else System.out.println("Поиск в HashSet: Элемент не найден!");
        return false;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        startTime = System.nanoTime();
        if (treeSet.contains(number)){
            endTime = System.nanoTime();
            System.out.println("Поиск в TreeSet: номер найден, поиск занял: " + (endTime - startTime));
        }else System.out.println("Поиск в TreeSet: Элемент не найден!");
        return false;
    }

}
