package share.classes.java.io.Closeable;

import java.io.IOException;
import java.net.SocketTimeoutException;

public class Main {
    public static void main(String[] args) {

        String host = "example.com";
        int port = 80;

        // Hold resources, but once it's closed -> the process ends
        try (HoldResources socketHandler = new HoldResources(host, port)) {
            String line;
            while ((line = socketHandler.readLine()) != null) {
                System.out.println(line);
            }
        } catch (SocketTimeoutException e) {
            System.out.println("Read timed out");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
