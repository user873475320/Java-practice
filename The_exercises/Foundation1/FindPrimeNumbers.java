package The_exercises.Foundation1;

public class FindPrimeNumbers {
    public static boolean isNumberPrime(long n) {
        long i = 2;
        while (i <= Math.sqrt(n)) {
            if (n % i == 0) return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 2; i < 100; i++) if (isNumberPrime(i)) System.out.print(i + " ");
    }
}
