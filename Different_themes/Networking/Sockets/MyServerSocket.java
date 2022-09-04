package Different_themes.Networking.Sockets;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {
    public static void main(String[] args) {
        try(ServerSocket ss = new ServerSocket(8082)) {
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());

            for (int i = 0; i < 10; i++) {
                String readString = DataInputStream.readUTF(dis);
                System.out.println("Message by client: " + readString);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
