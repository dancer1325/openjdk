package share.classes.java.io.InputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            // Open the file input stream
            inputStream = new FileInputStream("share/classes/java/io/InputStream/example.txt");

            // Read the file content byte by byte
            int data;
            while ((data = inputStream.read()) != -1) {
                // Convert byte to char and print it
                System.out.print((char) data);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (inputStream != null) {
                try {
                    // Close the input stream
                    inputStream.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


