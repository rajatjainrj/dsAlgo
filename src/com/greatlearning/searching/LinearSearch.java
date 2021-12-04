package com.greatlearning.searching;

import java.util.Scanner;

/**
 * @author rajatjain on - 04-12-2021
 * @project dsAlgo
 */
public class LinearSearch {

    private final Scanner scanner = new Scanner(System.in);

    private int[] array;

    public static void main(String[] args) {
        LinearSearch linearSearch = new LinearSearch();
        linearSearch.implementationOfLinearSearch();
    }

    private void implementationOfLinearSearch() {
        insertValues();
        searchValue();
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
    }

    private void searchValue() {
        System.out.println("Please input element to be searched - ");
        int searchableElement = scanner.nextInt();

        int index = linearSearch(array, searchableElement);

        if (index == -1) {
            System.out.println("Element not found in array");
        } else {
            System.out.println("Element found at position - " + (index + 1));
        }
    }

    private int linearSearch(int[] array, int searchableElement) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchableElement) {
                return i;
            }
        }
        return -1;
    }

}
