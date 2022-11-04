package Different_themes.Networking.Sockets;

import java.io.*;
import java.net.Socket;

class MyClientSocket {
	public static void main(String[] args) {
		try (
				Socket s = new Socket("localhost", 8080);
				var dis = new DataInputStream(s.getInputStream());
				var dos = new DataOutputStream(s.getOutputStream());
				var br = new BufferedReader(new InputStreamReader(System.in)))
		{
			String clientMessage = "", serverMessage = "";

			while (!clientMessage.equals("stop")) {
				clientMessage = br.readLine();
				dos.writeUTF(clientMessage);
				dos.flush();

				serverMessage = dis.readUTF();
				System.out.println("server says: " + serverMessage);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
