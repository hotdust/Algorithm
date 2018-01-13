package algorithm.heap;

import utils.Utils;

import java.util.Arrays;

public class HeapSort {

    private int[] array;
    private int heapSize;


    public HeapSort(int[] array) {
        this.array = array;
        heapSize = array.length;
    }

    public int parent(int i) {
        return (int) (Math.ceil(((double)i) / 2) - 1);
    }

    // 因为数组是以 0 开始，所以和书上不一样
    public int left(int i) {
        return 2 * i + 1;
    }

    // 因为数组是以 0 开始，所以和书上不一样
    public int right(int i) {
        return i * 2 + 2;
    }

    public void buildMaxHeap() {
        int lastParentIdx = heapSize / 2 - 1;
        for (int i = lastParentIdx; i >= 0 ; i--) {
            heapify(i);
        }
    }

    public void heapify(int i) {
        int lIdx = left(i);
        int rIdx = right(i);

        int largestIdx = i;
        if (lIdx < heapSize && array[lIdx] > array[i]) {
            largestIdx = lIdx;
        }

        if (rIdx < heapSize && array[rIdx] > array[largestIdx]) {
            largestIdx = rIdx;
        }

        if (largestIdx != i) {
            int temp = array[largestIdx];
            array[largestIdx] = array[i];
            array[i] = temp;
            heapify(largestIdx);
        }
    }

    public int[] heapSort() {
        buildMaxHeap();

        int[] sortedArray = new int[heapSize];
        int loopCnt = heapSize;
        for (int i = 0; i < loopCnt; i++) {
            sortedArray[i] = array[0];
            array[0] = array[heapSize - 1];
            heapSize--;
            heapify(0);
        }

        return sortedArray;
    }

    public int extractMax() {
        int max = array[0];
        array[0] = array[heapSize - 1];
        heapSize--;
        heapify(0);

        return max;
    }

    public void increaseKey(int x, int idx) {
        if (idx >= heapSize)
            throw new RuntimeException("idx >= heapsize");

        if (x < array[idx])
            throw new RuntimeException("x < array[idx]");

        int parentIdx = parent(idx);
        int i = idx;
        while (parentIdx > 0 && array[parentIdx] < x) {
            int temp = array[parentIdx];
            array[parentIdx] = x;
            array[i] = temp;

            i = parentIdx;
            parentIdx = parent(parentIdx);

        }
    }

    public void output() {
        Utils.outputArray(Arrays.copyOf(array, heapSize));
    }

    public void output(int[] array) {
        Utils.outputArray(array);
    }


    public static void main(String[] args) {
        // normal max heap
//        int[] array = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};


        // test heapify, 4 is error ele
//        int[] array = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
//        HeapSort heap = new HeapSort(array);
//        heap.heapify(1);

        // test build max heap
//        int[] array = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
//        HeapSort heap = new HeapSort(array);
//        heap.buildMaxHeap();

        // test heap sort
//        int[] array = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
//        HeapSort heap = new HeapSort(array);
//        heap.output(heap.heapSort());


        // test heap sort
        int[] array = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        HeapSort heap = new HeapSort(array);
        heap.buildMaxHeap();
        heap.increaseKey(15, 8);
        heap.output();

    }
}
