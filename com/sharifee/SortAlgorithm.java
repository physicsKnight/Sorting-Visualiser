package com.sharifee;

import java.util.ArrayList;
import java.util.Arrays;

public interface SortAlgorithm {

    ArrayList<SortAlgorithm> algorithms = new ArrayList<>(Arrays.asList(new BubbleSort(), new InsertionSort(),
                                                            new SelectionSort(), new MergeSort(),
                                                            new QuickSort()));

    void sort(int[] array);
}
