package The_exercises.OOP_Basics;

import java.util.Random;

public class GenerateFromArray {
    private final int[] values;
    private final int[] weights;

    public GenerateFromArray(int[] values, int[] weights) {
        this.values = values;
        this.weights = weights;
    }

    // My realization
    public int getRandomFromArr() {
        Random rand = new Random();
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights[i]; j++) {
                if (values[rand.nextInt(values.length)] == values[i]) return values[i];
            }
        }
        return values[rand.nextInt(values.length)];
    }

    public int getRandom() {
        Random rand = new Random();

        int sum = 0;
        for (var weight : weights) sum += weight;
        int[] newArr = new int[sum];

        int index = 0;
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights[i]; j++) newArr[index++] = values[i];
        }

        return values[rand.nextInt(sum)];
    }
}