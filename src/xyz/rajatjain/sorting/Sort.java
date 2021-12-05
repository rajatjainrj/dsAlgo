package xyz.rajatjain.sorting;

import java.util.Arrays;
import java.util.Scanner;

public abstract class Sort {

    final Scanner scanner = new Scanner(System.in);

    int[] array;

    boolean status = true;

    boolean ascending = true;

    public void insertValues() {
        System.out.println("Please enter number of Array Elements - ");
        int size = scanner.nextInt();

        array = new int[size];

        for (int i = 1; i <= size; i++) {
            System.out.println("Please enter " + i + " element - ");
            array[i - 1] = scanner.nextInt();
        }
        System.out.println("Array input successful");
        printValues();
    }

    public void sortValues() {
        sortValues(array);
    }

    public void sortValues(int[] array) {
        sortValues(array, ascending);
    }

    //Implementation should call setArrayAndAscending(array, ascending); first
    public abstract void sortValues(int[] array, boolean ascending);

    public void sortValuesAfterInputDirection(int[] array) {
        System.out.println("Please select direction of sorting - ");
        System.out.println("1. Descending\n2. Ascending (default)");
        int directionInput = scanner.nextInt();
        if (directionInput == 1) {
            ascending = false;
        }
        sortValues(array, ascending);
    }

    public void setArrayAndAscending(int[] array, boolean ascending){
        this.array = array;
        this.ascending = ascending;
    }

    public boolean checkForStatus() {
        // check if the array is sorted and return boolean value
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
        System.out.println("Array Values - " + Arrays.toString(array));
    }

}
