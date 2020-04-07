package com.sharifee;

public class InsertionSort implements SortAlgorithm {
    // takes values in the unsorted portion and swaps them with every
    // index before it until the value we are comparing is larger.
    // we stop comparing (break out of loop) and move to the next
    // unsorted value.

    @Override
    public void sort(int[] array, Visualiser visualiser) {
        for (int index = 1; index < array.length; index++)  {
            for (int insertIndex = index; insertIndex > 0; insertIndex--) {
                int a = array[insertIndex - 1];
                int b = array[insertIndex];
                if (b > a)
                    break;
                visualiser.delay(10);
                array[insertIndex] = a;
                array[insertIndex - 1] = b;
            }
        }
    }
}
