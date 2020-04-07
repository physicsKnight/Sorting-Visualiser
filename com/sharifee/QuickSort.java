package com.sharifee;

public class QuickSort implements SortAlgorithm {

    private Visualiser visualiser;

    @Override
    public void sort(int[] array, Visualiser visualiser) {
        this.visualiser = visualiser;
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = array[right];
            int insertIndex = left;
            for (int l = left; l <= right; l++) {
                int temp = array[l];
                if (temp <= pivot) {
                    visualiser.delay(10);
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
