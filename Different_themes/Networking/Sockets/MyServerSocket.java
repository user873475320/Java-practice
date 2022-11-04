package Different_themes.Networking.Sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class MyServerSockets {
    public static void main(String[] args) {
        try (
             ServerSocket ss = new ServerSocket(8080);
             Socket clientSocket = ss.accept();
             DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
             DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {

            String clientMessage = "", serverMessage = "";

            while (!clientMessage.equals("stop")) {
                clientMessage = dis.readUTF();
                System.out.println("clien says: " + clientMessage);

                serverMessage = br.readLine();
                dos.writeUTF(serverMessage);
                dos.flush();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
