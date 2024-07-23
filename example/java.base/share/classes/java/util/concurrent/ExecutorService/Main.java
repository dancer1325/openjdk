package share.classes.java.util.concurrent.ExecutorService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        // Create an executor service with a single thread
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Submit a task that returns a result
        Future<String> futureResult = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                // Simulate some work
                Thread.sleep(2000);
                return "Task completed!";
            }
        });

        // Do something else while the task is being executed
        System.out.println("Doing some other work while waiting for the task to complete...");

        try {
            // Get the result of the task, waiting if necessary
            String result = futureResult.get();
            System.out.println("Result from the task: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Shutdown the executor service
            executorService.shutdown();
        }
    }
}
