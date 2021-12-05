package xyz.rajatjain.sorting;

public class InsertionSort extends Sort {

    @Override
    public void sortValues(int[] array, boolean ascending) {
        setArrayAndAscending(array, ascending);
        for (int currentIndex = 1; currentIndex < array.length; currentIndex++) {
            int currentElement = array[currentIndex];
            int lastSortedIndex = currentIndex - 1;
            if (ascending) {
                while (lastSortedIndex > -1 && array[lastSortedIndex] > currentElement) {
                    array[lastSortedIndex + 1] = array[lastSortedIndex];
                    lastSortedIndex--;
                }
            } else {
                while (lastSortedIndex > -1 && array[lastSortedIndex] < currentElement) {
                    array[lastSortedIndex + 1] = array[lastSortedIndex];
                    lastSortedIndex--;
                }
            }
            array[lastSortedIndex + 1] = currentElement;
            printValues();
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSortImplementation();
    }

    private void insertionSortImplementation() {
        insertValues();
        sortValues();
    }

}
