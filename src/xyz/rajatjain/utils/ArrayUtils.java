package xyz.rajatjain.utils;

/**
 * @author rajatjain on - 13-01-2022
 * @project dsAlgo
 */
public class ArrayUtils {

    public static void swapValuesByIndex(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
