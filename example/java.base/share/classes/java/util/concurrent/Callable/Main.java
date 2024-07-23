package share.classes.java.util.concurrent.Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        // Create an executor service with 1! thread
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Define a callable task that may throw an exception
        // 1. Check that it's a functional interface
        // 3. next lambda expression being declared -- represent the -- 1! method of the functional interface!!
        Callable<String> task = () -> {
            // Simulate some work
            Thread.sleep(1000);

            // 2. Randomly decide whether to throw an exception or return a result
            if (Math.random() > 0.5) {
                throw new Exception("Something went wrong!");
            }
            return "Task completed successfully!";
        };

        // Submit the task to the executor service and get a future
        // 4. used by many methods of `Executors`
        Future<String> future = executorService.submit(task);

        // Do some other work here if needed
        System.out.println("Doing other work...");

        try {
            // Get the result from the future, blocking if necessary
            String result = future.get();
            System.out.println("Result from the task: " + result);
        } catch (InterruptedException e) {
            System.out.println("The current thread was interrupted while waiting for the task to complete.");
            Thread.currentThread().interrupt(); // Restore the interrupted status
        } catch (ExecutionException e) {
            // The task threw an exception
            System.out.println("The task threw an exception: " + e.getCause().getMessage());
        } finally {
            // Shutdown the executor service
            executorService.shutdown();
        }
    }
}
