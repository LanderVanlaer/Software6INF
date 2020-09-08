package me.landervanlaer.sorting;

public class Quicksort {
    protected static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static int partition(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1;
        for(int j = p; j <= r; j++) {
            if(arr[j] <= x) {
                final int temp = arr[++i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return i;
    }

    private static void sort(int[] arr, int p, int r) {
        if(p < r) {
            final int q = partition(arr, p, r);
            sort(arr, p, q - 1);
            sort(arr, q + 1, r);
        }
    }
}
