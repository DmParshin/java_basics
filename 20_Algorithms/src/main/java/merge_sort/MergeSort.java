package merge_sort;

import java.util.Collections;

public class MergeSort
{
    public static void mergeSort(int[] array)
    {
        int n = array.length;
        if(n < 2) {
            return;
        }
        int middle = n / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[n - middle];

        for (int i = 0; i < middle; i++) {
            leftArray[i] = array[i];
        }
        for (int i = middle; i < n; i++) {
            rightArray[i - middle] = array[i];
        }
        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(array, leftArray, rightArray);
    }

    private static void merge(int[] array, int[] left, int[] right)
    {
        int positionLeft = 0;
        int positionRight = 0;

        for (int i = 0; i < array.length; i++) {
            if (positionLeft == left.length) {
                array[i] = right[positionRight];
                positionRight++;
            } else if (positionRight == right.length) {
                array[i] = left[positionLeft];
                positionLeft++;
            } else if (left[positionLeft] < right[positionRight]) {
                array[i] = left[positionLeft];
                positionLeft++;
            } else {
                array[i] = right[positionRight];
                positionRight++;
            }
        }
    }
}
