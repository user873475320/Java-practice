package Different_themes.Networking.HttpServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHttpServer {
	private int port;
	private String directory;

	public SimpleHttpServer(int port, String directory) {
		this.port = port;
		this.directory = directory;
	}

	void start() {
		try (ServerSocket server = new ServerSocket(port)) {
			while (true) {
				Socket socket = server.accept();
				Thread thr = new Handler(socket, this.directory);
				thr.start();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		var port = Integer.parseInt(args[0]);
		var dir = args[1];

		new SimpleHttpServer(port, dir).start();
	}
}
