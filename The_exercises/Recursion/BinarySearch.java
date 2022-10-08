package The_exercises.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    public static <T extends Comparable<? super T>> int binSearch1(List<T> list, T item) {
        int l = 0, r = list.size() - 1;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (list.get(mid).compareTo(item) == 0) return mid;
            if (list.get(mid).compareTo(item) < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static boolean binSearch2(int[] arr, int item) {
        int l = -1, r = arr.length;
        // инвариант: a[l] < item <= a[r]
        // считаем, что a[-1]=-INF, а a[size]=INF
        while (l + 1 < r){
            int mid = (l + r) >>> 1;

            if (arr[mid] < item) l = mid;
            else r = mid;
        }
        return (r < arr.length && arr[r] == item);
    }


    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 10, 12, 144, 155};
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 10, 12, 144, 155};
        ArrayList<Integer> t = new ArrayList<>(Arrays.asList(arr));

        System.out.println(binSearch1(t, 144) == (arr.length - 1) - 1);
        System.out.println(binSearch2(arr1, 6));
    }
}
