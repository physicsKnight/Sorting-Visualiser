package com.sharifee;

public class MergeSort implements SortAlgorithm {

    @Override
    public void sort(int[] array) {
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
