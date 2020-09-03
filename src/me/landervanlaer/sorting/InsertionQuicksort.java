package me.landervanlaer.sorting;

public class InsertionQuicksort {
    public static void main(String[] args) {
        sortSearchBreakPoint();
    }

    public static void sortSearchBreakPoint() {
        int len = 10;
        boolean bp = false;
        for(; !bp; len++) {
            int[] arr = Sort.createRandomArray(len);
            int[] arr2 = arr.clone();

            final long timeInsertion = getTime(arr, Algorithms.INSERTION);
            final long timeQuicksort = getTime(arr2, Algorithms.QUICKSORT);

            System.out.println("timeInsertion : " + timeInsertion);
            System.out.println("timeQuicksort : " + timeQuicksort);

            if(timeInsertion > timeQuicksort) bp = true;
        }
        System.out.println(len);
    }

    private static long getTime(int[] arr, Algorithms algorithm) {
        final long startTime = System.nanoTime();
        Sort.sort(arr, algorithm);
        return System.nanoTime() - startTime;
    }
}
