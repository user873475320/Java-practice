package Different_themes.Networking.Sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

public class MyClientSocket {
    public static void main(String[] args) {
        // TODO: Try to transfer an array using sockets
        try(Socket s = new Socket("localhost", 8082);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream())) {
            for (int i = 0; i < 10; i++) {
                String tmp = "Hello, I'm Client server" + new Random().nextInt(100);
                System.out.println(tmp);
                dos.writeUTF(tmp);
            }
//            dos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
