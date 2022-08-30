package Chapter_10;

import java.io.FileInputStream;
import java.io.IOException;

public class CompFiles {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("You need to enter only 2 arguments!");
            return;
        }

        try (var f1 = new FileInputStream(args[0]); var f2 = new FileInputStream(args[1])) {
            int i, j;
            do {
                i = f1.read(); j = f2.read();
                if (i != j) break;
            } while (i != -1 || j != -1);

            if (i != j) System.out.println("Files are different");
            else System.out.println("Files are equivalent");
        } catch (IOException exception) {
            System.out.println("Error: " + exception);
        }
    }
}
