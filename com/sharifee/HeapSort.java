package com.sharifee;

public class HeapSort implements SortAlgorithm {

    @Override
    public void sort(int[] array, Visualiser visualiser) {
        buildMaxHeap(array);
        for (int i = array.length-1; i >= 0; i--) {
            visualiser.delay(10);
            swap(array,0, i);
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
            swap(arr, i, largest);
            heapifyDown(arr, largest, n);
        }
    }

    private void swap(int[] arr, int indexOne, int indexTwo)
    {
        int temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;
    }
}
