package me.landervanlaer.school.informatica6.sorting;


public class Sort {

    public static void main(String[] args) {
        int[] arr = Sort.createRandomArray(10);
        for(int i : arr)
            System.out.print(i +", ");
        System.out.println();
        Sort.sort(arr, Algorithms.QUICKSORT);
        for(int i : arr)
            System.out.print(i +", ");
    }

    public static void sort(int[] arr, Algorithms algorithm) {
        switch(algorithm) {
            case INSERTION -> Insertion.sort(arr);
            case QUICKSORT -> Quicksort.sort(arr);
            case COMBINED -> {
                if(arr.length <= 10) sort(arr, Algorithms.INSERTION);
                else sort(arr, Algorithms.QUICKSORT);
            }
        }
    }

    public static void sortSpeedTest(int[] arr, Algorithms... algorithms) {
        for(Algorithms algorithm : algorithms) {
            int[] newArray = arr.clone();
            final long startTime = System.nanoTime();
            Sort.sort(newArray, algorithm);
            final long endTime = System.nanoTime();
            System.out.printf("%s%nStart time = %d%nEnd time = %d%nTotal time = %f%n%n", algorithm.toString(), startTime, endTime, (double) (endTime - startTime) / 1000000);
        }
    }

    public static int[] createRandomArray(int length) {
        int[] array = new int[length];
        for(int i = 0; i < array.length; i++)
            array[i] = (int) (Math.random() * 100);
        return array;
    }
}
