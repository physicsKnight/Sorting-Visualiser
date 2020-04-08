package com.sharifee;

public class MergeSort implements SortAlgorithm {
    // Split the array in half and create two sublists, left and right.
    // repeat this process on both sides until you have only one element
    // on its own. Start merging each left and right list together by
    // comparing the indexes of both sides and inserting the lowest value
    // into the original array. Repeat the whole process until the call stack
    // rewinds to the initial recursive call and you have the original
    // left and right lists to merge back together.

    private Visualiser visualiser;

    @Override
    public void sort(int[] array, Visualiser visualiser) {
        this.visualiser = visualiser;
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) >> 1;
            mergeSort(array, beg, mid);
            mergeSort(array, mid + 1, end);
            merge(array, beg, mid, end);
        }
    }

    private void merge(int[] array, int beg, int mid, int end) {
        int leftIndex = 0, rightIndex = 0, insertIndex = beg;
        int[] left = new int[mid - beg + 1];
        int[] right = new int[end - mid];

        append(left, array,0, beg, left.length);
        append(right, array, 0, mid + 1, right.length);

        while (true) {
            visualiser.delay(10);
            if (leftIndex >= left.length) {
                append(array, right, insertIndex, rightIndex, end + 1);
                return;
            }
            else if (rightIndex >= right.length) {
                append(array, left, insertIndex, leftIndex, end + 1);
                return;
            }
            else if (left[leftIndex] <= right[rightIndex]) {
                array[insertIndex] = left[leftIndex];
                leftIndex++;
            }
            else {
                array[insertIndex] = right[rightIndex];
                rightIndex++;
            }
            insertIndex++;
        }
    }

    private void append(int[] left, int[] right, int leftIndex, int rightIndex, int end) {
        for (; leftIndex < end; leftIndex++) {
            try {
                left[leftIndex] = right[rightIndex++];
            } catch (IndexOutOfBoundsException ex) {
                ex.printStackTrace();
            }
        }
    }
}
