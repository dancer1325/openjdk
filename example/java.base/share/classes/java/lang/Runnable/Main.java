package share.classes.java.lang.Runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // Create an executor service with a single thread
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Define a runnable task that does not return a result
        // 1. Check that it's a functional interface
        // 3. next lambda expression being declared -- represent the -- 1! method of the functional interface!!
        Runnable task = () -> {
            // Simulate some work
            try {
                System.out.println("Task is starting...");
                Thread.sleep(1000); // Simulate a delay
                System.out.println("Task is completed.");
                // 2. does NOT return a result
            } catch (InterruptedException e) {
                System.out.println("The task was interrupted.");
                Thread.currentThread().interrupt(); // Restore the interrupted status
            }
        };

        // Submit the task to the executor service
        executorService.execute(task);

        // Do some other work here if needed
        System.out.println("Doing other work...");

        // Shutdown the executor service
        executorService.shutdown();
    }
}
