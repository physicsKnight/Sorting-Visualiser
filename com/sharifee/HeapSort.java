package com.sharifee;

public class HeapSort implements SortAlgorithm {

    private Visualiser visualiser;

    @Override
    public void sort(int[] array, Visualiser visualiser) {
        this.visualiser = visualiser;
        buildMaxHeap(array);
        for (int i = array.length-1; i >= 0; i--) {
            visualiser.delay(12);
            visualiser.swap(0, i);
            heapifyDown(array, 0, i-1);
        }
    }

    private void buildMaxHeap(int[] arr) {
        for (int i = Math.max(0, (arr.length / 2) - 1); i >= 0; i--)
            heapifyDown(arr, i, arr.length);
    }

    private void heapifyDown(int[] arr, int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest;

        if (left <= n && arr[left] > arr[i])
            largest = left;
        else largest = i;
        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            visualiser.swap(i, largest);
            heapifyDown(arr, largest, n);
        }
    }
}
