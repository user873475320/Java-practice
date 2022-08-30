package DSA.Algorithms;

public class EuclidAlgorithm {
    public static int gcd(int a, int b) {
        while (b != 0) {
            a %= b;
            //Swap a and b
            int tmp = a;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(gcd(12, 3));
    }
}
