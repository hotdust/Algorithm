package algorithm;

import java.util.Arrays;

public class Algorithm {

    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        int[] insertSortArray = {31, 41, 59, 26, 41, 58};
        algorithm.insertSort(insertSortArray);
    }


    public void insertSort(int[] orignalArray) {
        // back up orignalArray
        int[] newArray = Arrays.copyOf(orignalArray, orignalArray.length);
        for (int j = 1; j < newArray.length; j++) {
            int key = newArray[j];
            int i = j - 1;
            while (i >= 0 && newArray[i] > key) {
                newArray[i + 1] = newArray[i];
                i--;
            }
            newArray[i + 1] = key;
        }

        // print sorted array
        for (int ele : newArray) {
            System.out.println(ele + " ");
        }
    }
}
