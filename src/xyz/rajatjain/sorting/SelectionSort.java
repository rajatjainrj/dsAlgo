package xyz.rajatjain.sorting;

public class SelectionSort extends Sort {

    public void implementationOfSelectionSort() {

        insertValues();

        sortValues();

    }

    @Override
    public void sortValues(int[] array, boolean ascending) {
        setArrayAndAscending(array, ascending);
        for (int i = 0; i < array.length; i++) {
            int minMax = array[i];
            int minMaxIndex = i;
            for (int j = i; j < array.length; j++) {
                if ((ascending && minMax > array[j]) ||
                        (!ascending && minMax < array[j])) {
                    minMax = array[j];
                    minMaxIndex = j;
                }
            }
            array[minMaxIndex] = array[i];
            array[i] = minMax;
            printValues();
        }

    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.implementationOfSelectionSort();
    }

}
