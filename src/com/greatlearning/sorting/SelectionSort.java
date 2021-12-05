package com.greatlearning.sorting;

public class SelectionSort extends Sort {

    public void implementationOfSelectionSort() {

        insertValues();

        sortValues();

    }

    @Override
    public void sortValues(int[] array, boolean ascending) {
        setArrayAndAscending(array, ascending);
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if(min>array[j]){
                    min = array[j];
                    minIndex = j;
                }
            }
            array[minIndex] = array[i];
            array[i] = min;
            printValues();
        }

    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.implementationOfSelectionSort();
    }

}
