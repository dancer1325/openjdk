package share.classes.java.util.concurrent.Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        // Create an executor service with a single thread
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Define a callable task that returns a result
        Callable<String> task = () -> {
            Thread.sleep(1000); // Simulate some work with a sleep
            return "Task completed!";
        };

        // Submit the task to the executor service and get a future
        Future<String> future = executorService.submit(task);
        Future<String> futureToBeCancelled = executorService.submit(task);
        futureToBeCancelled.cancel(true);

        // Previous line is async computation -> NOT blocking
        System.out.println("Doing other work...");

        System.out.println("futureToBeCancelled.isCancelled() " + futureToBeCancelled.isCancelled());
        System.out.println("future.isDone() " + future.isDone());
        System.out.println("future.isCancelled() " + future.isCancelled());

        try {
            // Get the result from the future, BLOCKING if necessary
            String result = future.get();
            System.out.println("Result from the task: " + result);

            System.out.println("future.isDone() " + future.isDone());
            System.out.println("future.isCancelled() " + future.isCancelled());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Shutdown the executor service
            executorService.shutdown();
        }
    }
}
