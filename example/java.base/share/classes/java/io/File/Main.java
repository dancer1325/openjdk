package share.classes.java.io.File;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        // 1. relative path
        File file = new File("example.txt");
        printFileInfo(file);

        optionalSystemDependentPrefix();
    }

    private static void optionalSystemDependentPrefix() {
        // Unix-style path
        File unixFile = new File("/home/user/docs/file.txt");
        printFileInfo(unixFile);

        // Windows-style path with drive letter
        File windowsFile = new File("C:\\Users\\user\\docs\\file.txt");
        printFileInfo(windowsFile);
    }

    private static void printFileInfo(File file) {
        System.out.println("Path: " + file.getPath());
        System.out.println("Absolute Path: " + file.getAbsolutePath());
    }
}
