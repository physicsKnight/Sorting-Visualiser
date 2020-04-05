package com.sharifee;

public class InsertionSort implements SortAlgorithm {
    // takes values and compares them with every value before it in the array
    // and inserts them into the sorted section. The array is only passed
    // through once by the outer loop.

    @Override
    public void sort(int[] array) {
        for (int index = 1; index < array.length; index++)  {
            for (int insertIndex = index; insertIndex > 0; insertIndex--) {
                int a = array[insertionIndex - 1];
                int b = array[insertionIndex];
                if (b > a)
                    break;
                array[insertionIndex] = a;
                array[insertionIndex - 1] = b;
            }
        }
    }
}
