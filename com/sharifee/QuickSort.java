package com.sharifee;

public class QuickSort implements SortAlgorithm {
    // select a random value as the pivot (in this case the last element)
    // rearrange the array so that values less than the pivot are on the
    // left and values greater than the pivot on the right. repeat this
    // process recursively on the left and right side until the array
    // is sorted

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
