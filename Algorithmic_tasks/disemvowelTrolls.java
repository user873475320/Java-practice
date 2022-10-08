package Algorithmic_tasks;
class Troll {
    public static String disemvowelMy(String str) {
        String vowels = "aoieyuAOIEYU";
        String newStr = "";

        for (int i = 0; i < str.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < vowels.length(); j++) {
                if (str.charAt(i) == vowels.charAt(j)) flag = false;
            }
            if (flag) newStr += str.charAt(i);
        }
        return newStr;
    }

    public static String disemvowelBest(String str) {
        return str.replaceAll("[aAeEiIoOuU]", "");
    }

    public static void main(String[] args) {
        System.out.println(disemvowelMy("hello LOL"));

    }
}