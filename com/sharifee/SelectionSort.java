package com.sharifee;

public class SelectionSort implements SortAlgorithm {
    // searches for the smallest value in the unsorted portion of the array
    // then swaps it into the next index of the array until
    // it swaps the last unsorted values

    @Override
    public void sort(int[] array, Visualiser visualiser) {
        for (int indexA = 0; indexA < array.length - 1; indexA++) {
            // keep track of min value and position
            int minVal = array[indexA];
            int minIndex = indexA;
            // search for min value
            for (int indexB = indexA + 1; indexB < array.length; indexB++) {
                int currVal = array[indexB];
                if (currVal < minVal) {
                    // update min value and position
                    minVal = currVal;
                    minIndex = indexB;
                }
            }
            // swap values
            visualiser.delay(10);
            array[minIndex] = array[indexA];
            array[indexA] = minVal;
        }
    }
}
