package share.classes.java.net.PackageInfo;//package example.java.base.share.classes.java.net;
import java.net.URI;
import java.net.URL;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        try {
            URI uri = new URI("http://www.example.com/");
            URL url = uri.toURL();
            InputStream inputStream = url.openStream();
            // Read the file content byte by byte
            int data;
            while ((data = inputStream.read()) != -1) {
                // Convert byte to char and print it
                System.out.print((char) data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}