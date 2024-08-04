package share.classes.java.io.FileInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        /*FileInputStream fileInputStreamNonExistingFile = new FileInputStream("nonExisting.txt");*/

        // NOT found
        //FileInputStream fileInputStream = new FileInputStream("example.txt");
        //FileInputStream fileInputStream = new FileInputStream("share.classes.java.io.FileInputStream.example.txt");
        FileInputStream fileInputStream = new FileInputStream("share/classes/java/io/FileInputStream/example.txt");
    }
}
