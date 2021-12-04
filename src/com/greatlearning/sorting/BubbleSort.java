package com.greatlearning.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rajatjain on - 04-12-2021
 * @project dsAlgo
 */
public class BubbleSort {

    private final Scanner scanner = new Scanner(System.in);

    private int[] array;

    public boolean status = true;

    public boolean ascending = true;

    public void implementationOfBubbleSort() {

        insertValues();

        sortValues();

    }

    public void insertValues() {
        System.out.println("Please enter number of Array Elements - ");
        int size = scanner.nextInt();

        array = new int[size];

        for (int i = 1; i <= size; i++) {
            System.out.println("Please enter " + i + " element - ");
            array[i - 1] = scanner.nextInt();
        }
        System.out.println("Array input successful");

        System.out.println("Please select direction of sorting - ");
        System.out.println("1. Descending\n2. Ascending (default)");
        int directionInput = scanner.nextInt();
        if (directionInput == 1) {
            ascending = false;
        }
    }

    public void sortValues() {
        sortValues(array);
    }

    public void sortValues(int[] array) {
        sortValues(array, ascending);
    }

    public void sortValues(int[] array, boolean ascending) {
        this.ascending = ascending;
        int len = array.length - 1;
        do {
            for (int i = 0; i < len; i++) {
                int j = i + 1;
                if (ascending && array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    printValues();
                } else if (!ascending && array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    printValues();
                }
            }
            len = len - 1;
        } while (!checkForStatus());
    }

    public boolean checkForStatus() { // check if the array is sorted and return boolean value
        for (int i = 0; i < array.length - 1; i++) {
            if (ascending && array[i] > array[i + 1]) {
                return false;
            } else if (!ascending && array[i] < array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public void printValues() {
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.implementationOfBubbleSort();
    }

}
