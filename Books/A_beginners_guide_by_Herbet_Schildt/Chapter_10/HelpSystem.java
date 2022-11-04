package Chapter_10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class HelpSystem {

    public HelpSystem(String filePath) {
        this.filePath = filePath;
    }
    private String filePath;

    public void getInfo(String what) {
        String foundTopic = ("#" + what).strip();
        try (var f = new BufferedReader(new FileReader(filePath))) {
            String tmp;

            do {
                tmp = f.readLine();
                if (tmp == null) {
                    System.out.println("Topic isn't found");
                    return;
                }

                if (tmp.strip().equals(foundTopic)) {
                    System.out.println("Information about \"" + what + "\":\n");
                    do {
                        tmp = f.readLine();
                        if (tmp.strip().isEmpty()) break;
                        else System.out.println(tmp);
                    } while (true);

                    return;
                }
            } while (true);

        } catch (IOException exception) {
            System.out.println("Error: " + exception);
        }
    }
}

class test0 {

    public static void main(String[] args) {
        HelpSystem tmp = new HelpSystem("C:\\Users\\user8\\Dropbox\\main1\\Java\\Learn_Java\\src\\Books.A_beginners_guide_by_Herbet_Schildt\\Chapter_10\\         topics.txt");
        tmp.getInfo("do");
    }
}