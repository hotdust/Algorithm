package algorithm;

import utils.Utils;

import java.util.Arrays;

public class Algorithm {

    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();

        // 插入排序
//        int[] insertSortArray = {31, 41, 59, 26, 41, 58};
//        algorithm.insertSort(insertSortArray);

        // 归并排序
        // 测试 mergeSortedArray的数据
//        int[] mergeSortArray = {2, 4, 5, 7, 1, 2, 3, 6};
//        algorithm.mergeSortedArray(mergeSortArray, 0, (mergeSortArray.length -1)/2, mergeSortArray.length - 1);

        // 测试 mergeSort 的数据
        int[] mergeSortArray = {7, 2, 4, 5, 3, 2, 1, 6};
        algorithm.mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
    }


    /**
     * 插入排序主要思想
     *  - 从第2个元素开始判断，是否比前一个数据小，如果小的话，把前一个数据向后移动一位。
     *  - 直接没有比当前数据小的时候，把当前数据放到比较指针的位置
     * // TODO: 2018/1/6
     * @param originalArray
     */
    public void insertSort(int[] originalArray) {
        // back up originalArray
        int[] newArray = Arrays.copyOf(originalArray, originalArray.length);
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

    /**
     * 归并排序的主要思想
     *   - 把数据不断拆分，分成单位是1的数据
     *   - 然后使用"合并有序队列"方法，把数据不断合并
     * @param originalArray
     * @param startIdx
     * @param endIdx
     */
    public void mergeSort(int[] originalArray, int startIdx, int endIdx) {
        if (startIdx < endIdx) {
            int midIdx = (endIdx + startIdx) / 2;
            mergeSort(originalArray, startIdx, midIdx);
            mergeSort(originalArray, midIdx + 1, endIdx);
            mergeSortedArray(originalArray, startIdx, midIdx, endIdx);
        }
    }

    public void mergeSortedArray(int[] array, int startIdx, int midIdx, int endIdx) {
        // (midIdx - startIdx + 1) 是前半元素的个数，最后再 +1 是为了放无穷大值，为了计算方便。
        int[] firstHalf = new int[((midIdx - startIdx + 1) + 1)];
        System.arraycopy(array, startIdx, firstHalf, 0, midIdx - startIdx + 1);
//        firstHalf = Arrays.copyOf(array, (midIdx - startIdx + 1));
        int[] secondHalf = new int[((endIdx - midIdx) + 1)];
        System.arraycopy(array, midIdx + 1, secondHalf, 0, endIdx - midIdx);
//        secondHalf = Arrays.copyOfRange(array, midIdx + 1, endIdx);

        // 最后一个元素放无穷大值
        firstHalf[firstHalf.length - 1] = Integer.MAX_VALUE;
        secondHalf[secondHalf.length - 1] = Integer.MAX_VALUE;

        int i = 0, j = 0;

        for (int k = startIdx; k <= endIdx; k++) {
            if (firstHalf[i] < secondHalf[j]) {
                array[k] = firstHalf[i];
                i++;
            } else {
                array[k] = secondHalf[j];
                j++;
            }
        }

        System.out.println("");
        Utils.outputArray(array);


    }

}
