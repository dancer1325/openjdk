package share.classes.java.util.concurrent.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Define and submit tasks
        for (int i = 1; i <= 5; i++) {
            Runnable task = new SimpleTask(i);
            executorService.execute(task);
        }

        // Initiate shutdown
        executorService.shutdown();

        try {
            // Wait for all tasks to finish
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}

class SimpleTask implements Runnable {
    private final int taskId;

    public SimpleTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        // Check that ALL tasks are executed | same thread
        System.out.println("Task " + taskId + " is running on " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000); // Simulate some work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
