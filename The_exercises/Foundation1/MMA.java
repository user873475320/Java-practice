package The_exercises.Foundation1;


public class MMA {
    public static void main(String[] args) {
        double[] randArr = new double[100];
        for (int i = 0; i < randArr.length; i++) randArr[i] = Math.random();

        double maxVal = randArr[0], minVal = randArr[0], avgVal = randArr[0];
        for (int i = 1; i < randArr.length; i++) {
            if (maxVal < randArr[i]) maxVal = randArr[i];
            else if (minVal > randArr[i]) minVal = randArr[i];
            avgVal += randArr[i];
        }
        avgVal /= randArr.length;

        System.out.println(maxVal + " " + minVal + " " + avgVal);
    }

}
