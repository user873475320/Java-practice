package Codewars;

public class Isograms {
    public static boolean isIsogram(String str) {
        str = str.toLowerCase();
        if (str.isEmpty()) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (i != j && str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isIsogramBEST(String str) {
        return str.length() == str.toLowerCase().chars().distinct().count();
    }
}
