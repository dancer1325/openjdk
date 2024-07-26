package share.classes.java.util.logging.Logger;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    // 1. getLogger()       is a factory method
    private static Logger main = Logger.getLogger("Main");

    public static void main(String[] args) throws InterruptedException {
        main.info("Logger created or retrieved");

        loggerWithoutStrongReferenceCanBeGarbageCollected();

        // 3. registered handlers
        Arrays.stream(main.getHandlers()).toList().forEach(handler -> System.out.println("registered handler " + handler.toString()));

        hierarchyOfLoggers();
    }

    // 4. hierarchy of loggers -- based on -- naming
    private static void hierarchyOfLoggers() {
        // Create loggers
        Logger rootLogger = Logger.getLogger("");
        Logger parentLogger = Logger.getLogger("com.example");
        Logger childLogger = Logger.getLogger("com.example.service");

        // Set levels
        rootLogger.setLevel(Level.SEVERE);
        parentLogger.setLevel(Level.WARNING);

        // Log messages
        // Inherit the Level by children loggers
        childLogger.info("This is an info message");   // Will NOT be logged because level is WARNING -- inherited from parentLogger --
        childLogger.warning("This is a warning message"); // Will be logged

        // Display parent-child relationship
        System.out.println("Parent of childLogger: " + childLogger.getParent().getName());
        System.out.println("Parent of parentLogger: " + parentLogger.getParent().getName());        // NOT parent, since rootLogger does NOT have the "com"
        System.out.println("Parent of rootLogger: " + (rootLogger.getParent() != null ? rootLogger.getParent().getName() : "null"));
    }

    // 2. if a strong reference to the Logger is NOT kept -> ️may be garbage collected
    private static void loggerWithoutStrongReferenceCanBeGarbageCollected() throws InterruptedException {

        WeakReference<Logger> weakLogger = new WeakReference<>(main);
        // Remove the strong reference to the logger
        main = null;
        // Force garbage collection
        System.gc();
        Thread.sleep(100); // Give GC some time to collect
        // Check if the logger has been garbage collected
        if (weakLogger.get() == null) {
            System.out.println("Logger has been garbage collected.");
        } else {
            System.out.println("Logger is still referenced.");
        }
    }
}
