package com.sharifee;

public interface SortAlgorithm {

    SortAlgorithm[] algorithms = {new BubbleSort(), new SelectionSort(),
                                  new InsertionSort(), new MergeSort(),
                                  new QuickSort()};

    void sort(int[] array, Visualiser visualiser);
}
