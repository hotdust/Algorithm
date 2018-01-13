package book.introduction_to_algorithm.chap2;

import utils.Utils;

/**
 * Created by shijiapeng on 18/1/7.
 */
public class Chap2Execises {

    public static void main(String[] args) {

        Chap2Execises ch2 = new Chap2Execises();

        int[] recursiveInsertSortArray = {5, 1, 7, 6, 3};
        ch2.recursiveInsertSort(recursiveInsertSortArray, 0, recursiveInsertSortArray.length - 1);
    }


    /**
     * 2.3-4
     */
    public void recursiveInsertSort(int[] originalArray, int startIdx, int endIdx) {
        // n
        if (startIdx != endIdx) {
            // n -1
            recursiveInsertSort(originalArray, startIdx, endIdx - 1);
        }

        // n
        // insert sort
        recursiveInsertInnerFunc(originalArray, startIdx, endIdx);
    }

    public void recursiveInsertInnerFunc(int[] originalArray, int startIdx, int endIdx) {
        // n
        for (int j = endIdx; j > startIdx; j--) {
            // n - 1
            int key = originalArray[j];
            // n - 1
            int i = j - 1;
            // sum(n - 1)
            while (i >= 0 && originalArray[i] > key) {
                // sum(n - 2)
                originalArray[i + 1] = originalArray[i];
                // sum(n - 2)
                i--;
            }
            // n - 1
            originalArray[i + 1] = key;
        }

        // print sorted array
        System.out.println("");
        Utils.outputArray(originalArray);

    }
}
