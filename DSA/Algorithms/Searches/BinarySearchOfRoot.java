package DSA.Algorithms.Searches;

public class BinarySearchOfRoot {
    public static final double EPS = 0.001;
    public static double f(double x) {
        return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23;
    }

    public static double findRoot1(double start, double end) {
        double l = start, r = end;
        while (r - l > EPS) {
            double mid = (l + r) / 2.0;
            if (f(mid) < 0.0) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return (l + r) / 2.0;
    }

    public static double  findRoot2(double start, double end){
        if(end - start <= 0.001){
            return start;
        }

        double x = start + (end - start) / 2;

        if(f(start) * f(x) > 0){
            return findRoot2(x, end);
        } else {
            return findRoot2(start, x);
        }
    }

    public static void main(String[] args) {
        System.out.println(findRoot1(0.0, 10.0));
        System.out.println(findRoot2(0.0, 10.0));
    }
}
