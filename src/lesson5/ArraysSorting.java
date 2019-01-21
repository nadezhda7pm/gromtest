package lesson5;

import java.util.Arrays;
import java.util.Collections;

public class ArraysSorting {

    public static void main(String[] args) {
        int[] array = {5, 6, 3, 1, 3, 8, 9, 4, 2, 7};
        System.out.println(Arrays.toString(array));
//        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));
//        Arrays.sort((Integer) array, Collections.reverseOrder());
//        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sortAscending(array)));
        System.out.println(Arrays.toString(sortDescending(array)));
    }

    static int[] sortAscending(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int min_i = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    min_i = j;
                }
            }
            if (i != min_i){
                int tmp = array[i];
                array[i] = array[min_i];
                array[min_i] = tmp;
            }
        }
        return array;
    }

    static int[] sortDescending(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int max = array[i];
            int max_i = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] > max) {
                    max = array[j];
                    max_i = j;
                }
            }
            if (i != max_i){
                int tmp = array[i];
                array[i] = array[max_i];
                array[max_i] = tmp;
            }
        }
        return array;
    }
}
