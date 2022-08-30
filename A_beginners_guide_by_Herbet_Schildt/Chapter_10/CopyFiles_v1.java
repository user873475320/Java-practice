/*Task:
Write a program that copies a text file. In the process, have it convert all spaces into hyphens.
Use the byte stream file classes. Use the traditional approach to closing a file by explicitly calling close( ).
* */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class CopyFiles_v1 {
    public static synchronized void copy(String fromPath, String inPath) {
        File finFile = new File(fromPath);
        File foutFile = new File(inPath);

        FileInputStream fin = null;
        FileOutputStream fout = null;

        try {
            fin = new FileInputStream(finFile);
            fout = new FileOutputStream(foutFile);
            int finByte;

            while (true){
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
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    System.out.println("fromPath file hadn't been closed");
                }
            }
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    System.out.println("inPath file hadn't been closed");
                }
            }
        }
    }
}

class Test0 {
    public static void main(String[] args) {
        CopyFiles_v1.copy("D:\\Dropbox\\main1\\Java\\verbs.txt",  "D:\\Dropbox\\main1\\Java\\qwe.txt");
    }
}