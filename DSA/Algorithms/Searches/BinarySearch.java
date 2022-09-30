package DSA.Algorithms.Searches;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    public static <T extends Comparable<? super T>> int binSearch1(List<T> list, T item) {
        int l = 0, r = list.size() - 1;

        while (l <= r) {
            int mid = (l + r) >>> 1;

            if (list.get(mid).compareTo(item) == 0) return mid;
            if (list.get(mid).compareTo(item) < 0) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    public static <T extends Comparable<? super T>> boolean binSearch2(List<T> list, T item) {
        int l = -1, r = list.size();

        // invariant: a[l] < item <= a[r]
        // let's say that a[-1]=-INF, and a[size]=INF
        while (l + 1 < r){
            int mid = (l + r) >>> 1;

            if (list.get(mid).compareTo(item) < 0) l = mid;
            else r = mid;
        }
        return (r < list.size() && list.get(r).compareTo(item) == 0);
    }


    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 10, 12, 144, 155};
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 10, 12, 144, 155};
        ArrayList<Integer> t = new ArrayList<>(Arrays.asList(arr));

        System.out.println(binSearch1(t, 144) == (arr.length - 1) - 1); // true
        System.out.println(binSearch2(t, 6)); // true
    }
}
