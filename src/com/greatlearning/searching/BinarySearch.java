package com.greatlearning.searching;

import java.util.Scanner;

/**
 * @author rajatjain on - 04-12-2021
 * @project dsAlgo
 */
public class BinarySearch {

    private final Scanner scanner = new Scanner(System.in);

    private int[] array;
    private boolean ascending;

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.implementationOfBinarySearch();
    }

    public void implementationOfBinarySearch() {
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
        ascending = checkIfArrayIsSortedInAscending(array);
        System.out.println("Array input successful");
    }


    public void searchValue() {
        System.out.println("Please input type of Binary Search - ");
        System.out.println("1. Iterative \n2. Recursive (default)");
        int searchType = scanner.nextInt();

        System.out.println("Please input element to be searched - ");
        int searchableElement = scanner.nextInt();

        int index;
        switch (searchType) {
            case 1:
                index = iterativeBinarySearch(array, searchableElement);
                break;
            default:
            case 2:
                index = recursiveBinarySearch(array, searchableElement);
                break;
        }

        if (index == -1) {
            System.out.println("Element not found in array");
        } else {
            System.out.println("Element found at position - " + (index + 1));
        }

    }

    private int recursiveBinarySearch(int[] array, int searchableElement) {
        int size = array.length;
        int first = 0;
        int last = size - 1;
        return recursiveBinarySearch(array, searchableElement, first, last);
    }

    private int recursiveBinarySearch(int[] array, int searchableElement, int first, int last) {
        int mid = (int) Math.ceil((first + (double) last) / 2);

        if (searchableElement < array[mid]) {
            if(ascending) {
                last = mid - 1;
            }else{
                first = mid + 1;
            }
        } else if (array[mid] == searchableElement) {
            return mid;
        } else {
            if(ascending) {
                first = mid + 1;
            }else{
                last = mid - 1;
            }
        }
        if (first > last) {
            return -1;
        }
        return recursiveBinarySearch(array, searchableElement, first, last);
    }

    private boolean checkIfArrayIsSortedInAscending(int[] array) {
        boolean isAscending =array[0] < array[1];
        System.out.println("Ascending - " + isAscending);
        return isAscending;
    }

    private int iterativeBinarySearch(int[] array, int searchableElement) {
        int size = array.length;
        int first = 0;
        int last = size - 1;
        int mid = (first + last) / 2;

        while (first <= last) {
            if (searchableElement < array[mid]) {
                if(ascending) {
                    last = mid - 1;
                }else{
                    first = mid + 1;
                }
            } else if (array[mid] == searchableElement) {
                return mid;
            } else {
                if(ascending) {
                    first = mid + 1;
                }else{
                    last = mid - 1;
                }
            }
            mid = (first + last) / 2;
        }
        return -1;
    }

}
