package com.sharifee;

public interface SortAlgorithm {

    SortAlgorithm[] algorithms = {new BubbleSort(), new SelectionSort(),
                                  new InsertionSort(), new MergeSort(),
                                  new QuickSort(), new HeapSort()};

    void sort(int[] array, Visualiser visualiser);
}
