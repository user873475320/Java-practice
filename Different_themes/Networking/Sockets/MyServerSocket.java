package Different_themes.Networking.Sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(8082); Socket s = ss.accept();
             var dos = new DataOutputStream(s.getOutputStream()); var dis = new DataInputStream(s.getInputStream());
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String strSocket = "", strConsole = "";
            while (!(strConsole.equals("stop"))) {
                strSocket = dis.readUTF();
                System.out.println("Client says: " + strSocket);

                strConsole = br.readLine();
                dos.writeUTF(strConsole);
                dos.flush();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
