package classes.java.net;

import java.net.URI;
import java.net.URL;
import java.io.InputStream;

public class Example {
    public static void main(String[] args) {
        try {
            URI uri = new URI("http://www.example.com/");
            URL url = uri.toURL();
            InputStream in = url.openStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}