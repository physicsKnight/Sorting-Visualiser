package com.sharifee;

public class ShellSort implements SortAlgorithm {

    @Override
    public void sort(int[] array, Visualiser visualiser) {
        for (int gap = array.length / 2; gap > 0; gap /= 2)
            for (int i = gap; i < array.length; i++)
                for (int j = i - gap; j >= 0 && array[j] > array[j+gap]; j -= gap) {
                    visualiser.delay(10);
                    visualiser.swap(j, j+gap);
                }
    }
}
