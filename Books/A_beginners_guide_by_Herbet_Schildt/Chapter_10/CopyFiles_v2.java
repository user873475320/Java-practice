/*Task:
* Rewrite CopyFiles_v1 so that it uses the character stream classes. This time, use the try-with-resources statement
* to automatically close the file.
* */

package Books.A_beginners_guide_by_Herbet_Schildt.Chapter_10;

import java.io.*;

class CopyFiles_v2 {
    public static synchronized void copy(String fromPath, String inPath) {
        File finFile = new File(fromPath);
        File foutFile = new File(inPath);

        try (var fin = new BufferedReader(new FileReader(finFile)); var fout = new FileWriter(foutFile)) {
            int finByte;

            while (true) {
                finByte = fin.read();
                if (finByte == -1) {
                    System.out.println("File has been copied successfully!");
                    return;
                }
                if ((char) finByte == ' ') finByte = (int) '-';
                fout.write(finByte);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Test1 {
    public static void main(String[] args) {
        CopyFiles_v2.copy("D:\\Dropbox\\main1\\Java\\verbs.txt",  "D:\\Dropbox\\main1\\Java\\qwe.txt");
    }
}