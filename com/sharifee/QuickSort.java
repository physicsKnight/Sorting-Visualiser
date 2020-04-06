package com.sharifee;

public class QuickSort implements SortAlgorithm {

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = array[right];
            int insertIndex = left;
            for (int l = left; l <= right; l++) {
                int temp = array[l];
                if (temp <= pivot) {
                    array[l] = array[insertIndex];
                    array[insertIndex] = temp;
                    insertIndex++;
                }
            }
            quickSort(array, left, insertIndex - 2);
            quickSort(array, insertIndex, right);
        }
    }
}
