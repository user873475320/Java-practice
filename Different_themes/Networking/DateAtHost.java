package Different_themes.Networking;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class DateAtHost extends Date {
	static int defaultTimePort = 37;
	// seconds from start of 20th century to Jan 1, 1970 00:00 GMT
	static final long offset = 2208988800L;

	public DateAtHost(String host) throws IOException {
		this(host, defaultTimePort);
	}

	public DateAtHost(String host, int port) throws IOException{
		Socket server = new Socket(host, port);
		DataInputStream dis = new DataInputStream(server.getInputStream());

		int time = dis.readInt();
		server.close();

		setTime( (((1L << 32) + time) - offset) * 1000 );


	}

	public static void main(String[] args) {
		DateAtHost time = null;
		try {
			time = new DateAtHost("falsjnlqwer.ru");
//		    Date time = new Date();
			System.out.println("time is: " + time);
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}


