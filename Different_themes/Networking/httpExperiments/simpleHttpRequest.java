package Different_themes.Networking.httpExperiments;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class simpleHttpRequest {
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("http://example.com");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
