package xyz.rajatjain.utils;

import java.util.ArrayList;

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

    public static <T> void swapValuesByIndex(ArrayList<T> arrayList, int index1, int index2){
        T temp = arrayList.get(index1);
        arrayList.add(index1, arrayList.get(index2));
        arrayList.add(index2, temp);
    }

}
