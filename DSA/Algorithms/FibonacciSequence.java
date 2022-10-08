package DSA.Algorithms;

import java.util.Arrays;
/*
*
*
* */
public class FibonacciSequence {
    /**
     * @param n The fibonacci number at this number({@code n}) will be the last one in the array of the fibonacci sequence
     * @return The array of the fibonacci sequence
     */
    public static long[] generateSequence(int n) {
        long[] arr = new long[n + 1];
        arr[0] = 0L;
        arr[1] = 1L;
        arr[2] = 1L;

        for (int i = 3; i < n + 1; i++) arr[i] = arr[i - 1] + arr[i - 2];
        return arr;
    }

    /**
     * Generate the fibonacci number at number {@code n}
     *
     * @return The fibonacci number
     */
    public static long generateNumber(int number) {
        long a = 0L;
        long b = 1L;
        long c = 1L;

        for (int i = 2; i < number; i++) {
            a = b;
            b = c;
            c = a + b;
        }

        return c;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(FibonacciSequence.generateNumber(10));
        System.out.println(Arrays.toString(FibonacciSequence.generateSequence(10)));
    }
}
