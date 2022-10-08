package A_beginners_guide_by_Herbet_Schildt.Chapter_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class CharRead {
    // Read characters
    // Using a first version of the read methods
    public static void func1() {
        System.out.println();
        char i;

        try (BufferedReader c = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                i = (char) c.read();
                if (i == '\n') continue;
                System.out.println(i);
            } while (i != '.');
        } catch (IOException exc) {
            System.out.println("Error: " + exc);
        }
    }

    // Read character
    // Using a second version of the read methods
    public static void func2() {
        System.out.println();
        char[] m = new char[10];

        int res = -1;
        try (BufferedReader c = new BufferedReader(new InputStreamReader(System.in))) {
            res = c.read(m);
        } catch (IOException exception) {
            System.out.println("Error: " + exception);
        }

        System.out.println(res);

        for (int j = 0; j < res; j++) {
            System.out.print(m[j]);
        }
    }

    // Read strings
    public static void func3() {
        System.out.println();
        try (BufferedReader c = new BufferedReader(new InputStreamReader(System.in))) {
            String s;
            do {
                s = c.readLine();
                System.out.println(s);
            } while (!s.equals("stop"));
        } catch (IOException exception) {
            System.out.println("Error: " + exception);
        }
    }
}

class CharWrite {
    public static void func1() {
        PrintWriter pw = new PrintWriter(System.out, true);
        int i = 10;
        double d = 123.65;

        pw.println("Using a PrintWriter.");
        pw.println(i);
        pw.println(d);
        pw.println(i + " + " + d + " is " + (i+d));
    }
}
