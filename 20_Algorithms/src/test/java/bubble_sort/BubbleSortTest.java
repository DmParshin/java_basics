package bubble_sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    @DisplayName("Сортировка пузырьком")
    public void bubbleSort(){
        BubbleSort bubbleSort = new BubbleSort();
        int[] arrayUnsorted = new int[]{2,1,4,5,6,7};
        int[] arraySorted = new int[]{1,2,4,5,6,7};
        bubbleSort.sort(arrayUnsorted);
        boolean check = true;
        for(int i = 0; i < arraySorted.length; i++){
            if (arraySorted[i] != arrayUnsorted[i]){
                check = false;
            }
        }
        assertEquals(true , check);
    }
}
