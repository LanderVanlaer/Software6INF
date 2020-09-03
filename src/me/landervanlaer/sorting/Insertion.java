package me.landervanlaer.sorting;

public class Insertion {
    protected static void sort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            final int teSorterenWaarde = arr[i];
            int legePositie = i;
            while(legePositie > 0 && teSorterenWaarde < arr[legePositie - 1]) {
                arr[legePositie] = arr[legePositie - 1];
                legePositie--;
            }
            arr[legePositie] = teSorterenWaarde;
        }
    }
}
