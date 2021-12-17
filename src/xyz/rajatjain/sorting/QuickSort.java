package xyz.rajatjain.sorting;

import java.util.Arrays;

/**
 * @author rajatjain on - 16-12-2021
 * @project dsAlgo
 */
public class QuickSort extends Sort {


    @Override
    public void sortValues(int[] array, boolean ascending) {
        setArrayAndAscending(array, ascending);

        int low = 0;
        int high = array.length - 1;
        quickSort(array, low, high);
        printValues();
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            printValues();
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if ((ascending && array[j] < pivot) ||
                    (!ascending && array[j] > pivot)) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.quickSortImplementation();
    }

    private void quickSortImplementation() {
        insertValues();
        sortValues();
    }
}
