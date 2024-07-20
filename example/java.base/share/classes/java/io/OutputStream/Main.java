package share.classes.java.io.OutputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) {
        String data = "Hello, world!\nThis is a test file.";

        try (OutputStream outputStream = new FileOutputStream("output.txt")) {
            // Convert string to bytes and write to the file
            byte[] dataBytes = data.getBytes();
            outputStream.write(dataBytes);

            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
