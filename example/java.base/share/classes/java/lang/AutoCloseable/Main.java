package share.classes.java.lang.AutoCloseable;

import java.io.IOException;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
