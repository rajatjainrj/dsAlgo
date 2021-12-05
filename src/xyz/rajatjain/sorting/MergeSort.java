package xyz.rajatjain.sorting;

import java.util.Arrays;

public class MergeSort extends Sort {

    @Override
    public void sortValues(int[] array, boolean ascending) {
        setArrayAndAscending(array, ascending);

        int left = 0;
        int right = array.length - 1;
        mergeSort(array, left, right, ascending);

    }

    private void mergeSort(int[] array, int left, int right, boolean ascending) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid, ascending);
            mergeSort(array, mid + 1, right, ascending);

            merge(array, left, mid, right);
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int leftArrayLen = mid - left + 1;
        int rightArrayLen = right - mid;

        int[] leftArray = new int[leftArrayLen];
        int[] rightArray = new int[rightArrayLen];

        for (int i = 0; i < leftArrayLen; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < rightArrayLen; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int arrayIndex = left;
        while (i < leftArrayLen && j < rightArrayLen) {
            if(ascending) {
                if (leftArray[i] <= rightArray[j]) {
                    array[arrayIndex] = leftArray[i];
                    i++;
                } else {
                    array[arrayIndex] = rightArray[j];
                    j++;
                }
            }else{
                if (leftArray[i] >= rightArray[j]) {
                    array[arrayIndex] = leftArray[i];
                    i++;
                } else {
                    array[arrayIndex] = rightArray[j];
                    j++;
                }
            }
            arrayIndex++;
        }
        while (i < leftArrayLen) {
            array[arrayIndex] = leftArray[i];
            i++;
            arrayIndex++;
        }

        while (j < rightArrayLen) {
            array[arrayIndex] = rightArray[j];
            j++;
            arrayIndex++;
        }
        printValues(leftArray, rightArray);
    }

    public void printValues(int[] leftArray, int[] rightArray) {
        System.out.println("Array Values - " + Arrays.toString(array) +
                ", Left Array - " + Arrays.toString(leftArray) +
                ", Right Array - " + Arrays.toString(rightArray));
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSortImplementation();
    }

    private void mergeSortImplementation() {
        insertValues();
        sortValues();
    }

}
