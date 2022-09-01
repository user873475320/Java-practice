package The_exercises.OOP_Basics;

public final class Vector {
    private final double x1, y1, z1;

//    private Vector() {}

    public Vector(double x1, double y1, double z1) {
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
    }

    public double getVectorLength() {
        return Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
    }

    public double scalarProduct(double x2, double y2, double z2) {
        return x1 * x2 + y1 * y2 + z1 * z2;
    }
    public double scalarProduct(Vector v2) {
        return x1 * v2.x1 + y1 * v2.y1 + z1 * v2.z1;
    }

    public double cos(Vector v2) {
        return (scalarProduct(v2) / (getVectorLength() * v2.getVectorLength()));
    }

    public Vector vectorProduct(Vector v) {
        return new Vector(y1 * v.z1 - z1 * v.y1, z1 * v.x1 - x1 * v.z1, x1 * v.y1 - y1 * v.x1);
    }
    public Vector vectorProduct(double x2, double y2, double z2) {
        return new Vector(y1 * z2 - z1 * y2, z1 * x2 - x1 * z2, x1 * y2 - y1 * x2);
    }

    public Vector getSumOfVectors(Vector v) {
        return new Vector(x1 + v.x1, y1 + v.y1, z1 + v.z1);
    }
    public Vector getSumOfVectors(double x2, double y2, double z2) {
        return new Vector(x1 + x2, y1 + y2, z1 + z2);
    }

    public Vector getDifferenceOfVectors(Vector v) {
        return new Vector(x1 - v.x1, y1 - v.y1, z1 - v.z1);
    }
    public Vector getDifferenceOfVectors(double x2, double y2, double z2) {
        return new Vector(x1 - x2, y1 - y2, z1 - z2);
    }

    public static Vector[] generateArrOfVectors(int n) {
        Vector[] arr = new Vector[n];
        for (var el : arr) el = new Vector(Math.random(), Math.random(), Math.random());
        return arr;
    }

    @Override
    public String toString() {
        return "Vector(" + x1 + ", " + y1 + ", " + z1 + ")";
    }
}
