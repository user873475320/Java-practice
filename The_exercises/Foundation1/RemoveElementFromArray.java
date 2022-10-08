package The_exercises.Foundation1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveElementFromArray {

    public static <T> T[] removeElFromArr1(T[] arr, T ElForRemove) {
        List<T> tmpArr = new ArrayList<>();

        for (T t : arr) if (!ElForRemove.equals(t)) tmpArr.add(t);

        return (T[]) tmpArr.toArray();
    }

    public static <T> T[] removeElFromArr2(T[] arr, T ElForRemove) {
        int offset = 0;
        for (int i = 0; i < arr.length; i++) {
            if (ElForRemove.equals(arr[i])) {
                offset++;
            } else {
                arr[i - offset] = arr[i];
            }
        }
        return Arrays.copyOf(arr, arr.length - offset);
    }

    public static void main(String[] args) {
        Integer[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(Arrays.toString(arr));
        removeElFromArr1(arr, 0);
        System.out.println(Arrays.toString(arr));

        Integer[] arr1 = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(Arrays.toString(arr));
        removeElFromArr2(arr, 0);
        System.out.println(Arrays.toString(arr));
    }
}
