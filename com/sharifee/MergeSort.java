package com.sharifee;

import java.util.Arrays;

public class MergeSort implements SortAlgorithm {

    @Override
    public void sort(int[] array) {
        mergeSort(array);
    }

    private int[] mergeSort(int[] array) {
        if (array.length <= 1)
            return array;
        else {
            int midIndex = array.length >> 1;
            int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
            int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));
            return merge(left, right);
        }
    }

    private int[] merge(int[] left, int[] right) {
        int leftIndex = 0, rightIndex = 0, mergedIndex = 0;
        int[] merged = new int[left.length + right.length];
        while (true) {
            if (leftIndex >= left.length) {
                return append(merged, right, mergedIndex, rightIndex);
            }
            else if (rightIndex >= right.length) {
                return append(merged, left, mergedIndex, leftIndex);
            }
            else if (left[leftIndex] <= right[rightIndex]) {
                merged[mergedIndex] = left[leftIndex];
                leftIndex++;
            }
            else {
                merged[mergedIndex] = right[rightIndex];
                rightIndex++;
            }
            mergedIndex++;
        }
    }

    private int[] append(int[] left, int[] right, int leftIndex, int rightIndex) {
        for (; leftIndex < left.length; leftIndex++) {
            try {
                left[leftIndex] = right[rightIndex++];
            } catch (IndexOutOfBoundsException ex) {
                ex.printStackTrace();
            }
        }
        return left;
    }
}
