package Different_themes.Networking.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Handler extends Thread {
	private Socket socket;
	private String directory;

	private static final Map<String, String> CONTENT_TYPES = new HashMap<>() {{
		put("jpg", "image/jpeg");
		put("html", "text/html");
//		put("jpg", "image/jpeg");
		sys
	}};


	public Handler(Socket socket, String directory) {
		this.socket = socket;
		this.directory = directory;
	}

	@Override
	public void run() {
		try (var input = socket.getInputStream(); var output = socket.getOutputStream()) {
			var url =
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}


	private String getRequestURL(InputStream input) {
		var reader = new Scanner(input).useDelimiter("\r\n");
		String line = reader.next();
		return line.split(" ")[1];
	}

	private void sendHeader(OutputStream output, int statusCode, String statusText, String type, long length) {
		PrintStream ps = new PrintStream(output);
		ps.printf()
	}
}
