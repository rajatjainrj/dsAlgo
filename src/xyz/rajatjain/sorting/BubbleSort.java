package xyz.rajatjain.sorting;

/**
 * @author rajatjain on - 04-12-2021
 * @project dsAlgo
 */
public class BubbleSort extends Sort{

    public void implementationOfBubbleSort() {

        insertValues();

        sortValues();

    }

    @Override
    public void sortValues(int[] array, boolean ascending) {
        setArrayAndAscending(array, ascending);
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

    public static void main(String[] args) {

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.implementationOfBubbleSort();
    }

}
