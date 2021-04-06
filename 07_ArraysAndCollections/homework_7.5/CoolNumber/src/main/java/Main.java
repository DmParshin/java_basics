import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */
    private static String TEST_NUMBER = "Н777УР123";


    public static void main(String[] args) {
        ArrayList testArray = (ArrayList) CoolNumbers.generateCoolNumbers();
        HashSet<String> testHashSet = new HashSet<>(testArray);
        TreeSet<String> testTreeSet = new TreeSet<>(testArray);

        CoolNumbers.bruteForceSearchInList(testArray, TEST_NUMBER);
        CoolNumbers.searchInHashSet(testHashSet, TEST_NUMBER);
        CoolNumbers.searchInTreeSet(testTreeSet, TEST_NUMBER);
        CoolNumbers.binarySearchInList(testArray, TEST_NUMBER);

    }
}
