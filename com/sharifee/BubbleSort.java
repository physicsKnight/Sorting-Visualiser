package com.sharifee;

public class BubbleSort implements SortAlgorithm {
    // every next two index is compared with eachother and swapped accordingly
    // on each pass the next largest number is carried to the end
    // until we reach the first index (the smallest number)
    // therefore the number of total passes is equal to the length of the array minus 1
    // as we can skip the final check since we know the array is sorted anyways
    // the number of comparisons decrement on each pass since we know the largest
    // numbers are moved to the end.

    @Override
    public void sort(int[] array) {
        for (int pass = 0; pass < array.length - 1; pass++) {
            for (int comp = 0; comp < array.length - 1 - pass; comp++)  {
                int a = array[comp];
                int b = array[comp + 1];
                if (a > b) {
                    array[comp + 1] = a;
                    array[comp] = b;
                }
            }
        }
    }
}
