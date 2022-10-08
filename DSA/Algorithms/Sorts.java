package DSA.Algorithms;


import java.util.Arrays;
import java.util.Random;

public class Sorts {

    private static <T> void swap(T[] arr, int index0, int index1) {
        T tmp = arr[index0];
        arr[index0] = arr[index1];
        arr[index1] = tmp;
    }

    public static <T extends Comparable<? super T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++) if (arr[j].compareTo(arr[j + 1]) > 0) swap(arr, j, j + 1);
    }

    public static <T extends Comparable<? super T>> void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int smallestIndex = i;

            for (int j = i + 1; j < arr.length; j++) if (arr[smallestIndex].compareTo(arr[j]) > 0) smallestIndex = j;

            swap(arr, smallestIndex, i);
        }
    }

    public static <T extends Comparable<? super T>> void insertSort(T[] arr) {
        for (int i = 1; i < arr.length; i++)
            for (int j = i; j != 0 && arr[j].compareTo(arr[j - 1]) < 0; --j) swap(arr, j, j - 1);
    }

    // You can overload the method above in order to just call quickSort(arr) without other parameters
    public static <T extends Comparable<? super T>> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    public static <T extends Comparable<? super T>> void quickSort(T[] arr, int lowIndex, int highIndex) {
        // Base case
        if (lowIndex >= highIndex) return;

        // Choose the pivot
        int pivot = highIndex;
        int leftPointer = lowIndex, rightPointer = highIndex;

        // Partitioning
        while (leftPointer < rightPointer) {
            while (arr[leftPointer].compareTo(arr[pivot]) <= 0 && leftPointer < rightPointer) leftPointer++;
            while (arr[rightPointer].compareTo(arr[pivot]) >= 0 && leftPointer < rightPointer) rightPointer--;
            swap(arr, leftPointer, rightPointer);
        }
        swap(arr, leftPointer, pivot);

        // Recursively quick sort all the value to the right part of the pivot and all the value to the left
        // part of the pivot
        quickSort(arr, lowIndex, leftPointer - 1);
        quickSort(arr, leftPointer + 1, highIndex);
    }

    public static <T extends Comparable<? super T>> void mergeSort(T[] arr) {
        int length = arr.length;
        if (length < 2) return;

        int midIndex = length / 2;
        T[] leftHalf = Arrays.copyOfRange(arr, 0, midIndex);
        T[] rightHalf = Arrays.copyOfRange(arr, midIndex, length);

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(arr, leftHalf, rightHalf);
    }
    private static <T extends Comparable<? super T>> void merge(T[] arr, T[] leftHalf, T[] rightHalf) {
        int i = 0, j = 0, k = 0;
        int sizeLeft = leftHalf.length, sizeRight = rightHalf.length;

        while (i < sizeLeft && j < sizeRight) {
//            if (leftHalf[i].compareTo(rightHalf[j]) <= 0) arr[k++] = leftHalf[i++];
//            else arr[k++] = rightHalf[j++];
            arr[k++] = (leftHalf[i].compareTo(rightHalf[j]) <= 0) ? leftHalf[i++] : rightHalf[j++];
        }

        while (i < sizeLeft) arr[k++] = leftHalf[i++];
        while (j < sizeRight) arr[k++] = rightHalf[j++];
    }

    // Testing
    public static void main(String[] args) {
        Random rand = new Random();
        Integer[] arr = new Integer[10];
        System.out.print("Before: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();

//        bubbleSort(arr);
//        selectionSort(arr);
//        insertSort(arr);
//        quickSort(arr);
//        mergeSort(arr);

        System.out.print("After: ");
        for (var i : arr) System.out.print(i + " ");
    }
}
