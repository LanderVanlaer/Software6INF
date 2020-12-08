package me.landervanlaer.sorting;

import java.util.Arrays;

public class CombinationSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 6, 3, 4, 5, 7, 8, 2, 9, 0, 4, 1, 2, 5, 4, 3, 1, 2, 6, 3, 4, 5, 7, 8, 2, 9, 0, 4, 1, 2, 5, 4, 3, 1, 2, 6, 3, 4, 5, 7, 8, 2, 9, 0, 4, 1, 2, 5, 4, 3, 1, 2, 6, 3, 4, 5, 7, 8, 2, 9, 0, 4, 1, 2, 5, 4, 3, 1, 2, 6, 3, 4, 5, 7, 8, 2, 9, 0, 4, 1, 2, 5, 4, 3};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int bI, int eI) {
        if(eI - bI < 0)
            insertion(arr, bI, eI);
        else {
            final int pI = partition(arr, bI, eI);
            sort(arr, bI, pI - 1);
            sort(arr, pI + 1, eI);
        }
    }

    private static void insertion(int[] arr, int bI, int eI) {
        for(int i = bI + 1; i < eI; i++) {
            final int value = arr[i];
            int j = i;
            while(j > bI && value < arr[--j]) {
                arr[j + 1] = arr[j];
                arr[j] = value;
            }
        }
    }

    private static int partition(int[] arr, int bI, int eI) {
        final int VALUE = arr[eI];
        int j = bI - 1;

        for(int i = bI; i <= eI; i++) {
            if(arr[i] <= VALUE) {
                final int t = arr[i];
                arr[i] = arr[++j];
                arr[j] = t;
            }
        }
        return j;
    }
}
