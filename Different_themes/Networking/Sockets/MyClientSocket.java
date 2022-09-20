package Different_themes.Networking.Sockets;

import java.io.*;
import java.net.Socket;

public class MyClientSocket {
    public static void main(String[] args) {
        try (Socket s = new Socket("localhost", 8082);
             var dos = new DataOutputStream(s.getOutputStream()); var dis = new DataInputStream(s.getInputStream());
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String strSocket = "", strConsole = "";
            while (!(strConsole.equals("stop"))) {

                strConsole = br.readLine();
                dos.writeUTF(strConsole);
                dos.flush();

                strSocket = dis.readUTF();
                System.out.println("Server says: " + strSocket);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
