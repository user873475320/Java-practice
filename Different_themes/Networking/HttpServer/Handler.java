package Different_themes.Networking.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Handler extends Thread {
	private Socket socket;
	private String directory;

	private static final Map<String, String> CONTENT_TYPES = new HashMap<>() {{
		put("jpg", "image/jpeg");
		put("html", "text/html");
		put("json", "application/json");
		put("txt", "text/plain");
		put("", "text/plain");
	}};

	private static final String NOT_FOUND_MESSAGE = "Error 404. NOT FOUND";

	public Handler(Socket socket, String directory) {
		this.socket = socket;
		this.directory = directory;
	}

	@Override
	public void run() {
		try (var input = socket.getInputStream(); var output = socket.getOutputStream()) {
			var url = this.getRequestURL(input);
			// TODO: What's Path class? Which methods it has? How and when use it?
			var filePath = Path.of(this.directory, url);

			if (Files.exists(filePath) && !Files.isDirectory(filePath)) {
				var extension = this.getFileExtension(filePath);
				var type = CONTENT_TYPES.get(extension);
				var fileBytes = Files.readAllBytes(filePath);
				this.sendHeader(output, 200, "OK", type, fileBytes.length);
				output.write(fileBytes);

			} else {
				this.sendHeader(output, 404, NOT_FOUND_MESSAGE, "text", NOT_FOUND_MESSAGE.length());
				output.write(NOT_FOUND_MESSAGE.getBytes());
			}
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

	private String getFileExtension(Path path) {
		var name = path.getFileName().toString();
		var extensionStart = name.lastIndexOf(".");
		return extensionStart == -1 ? "" : name.substring(extensionStart + 1);
	}

	// TODO: What's PrintStream? How to use it?
	private void sendHeader(OutputStream output, int statusCode, String statusText, String type, long length) {
		PrintStream ps = new PrintStream(output);
		// TODO: How does printf method work?
		ps.printf("HTTP/1.1 %s %s%n", statusCode, statusText);
		ps.printf("Content-Type: %s%n", type);
		ps.printf("Content-Length: %s%n%n", length);
	}
}
