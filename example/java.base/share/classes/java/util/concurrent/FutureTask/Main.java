package share.classes.java.util.concurrent.FutureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {
        // ExecutorService / 1! thread
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Define a Callable<Task>
        Callable<String> callableTask = () -> {
            // Simulate some work
            Thread.sleep(1000);
            return "Task completed successfully!";
        };

        // Create a FutureTask which is a RunnableFuture
        // 4. wrap a Callable
        FutureTask<String> futureTask = new FutureTask<>(callableTask);
        // Create a MyFutureTask
        MyFutureTask<String> customFutureTaskExposingRunAndReser = new MyFutureTask<>(callableTask);

        try {
            executeFutureTask(executorService, futureTask, false);
            executeFutureTask(executorService, customFutureTaskExposingRunAndReser, true);

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

    private static void executeFutureTask(ExecutorService executorService, FutureTask<String> futureTask, boolean isCustomFutureTask)
            throws InterruptedException, ExecutionException {
        System.out.println("futureTask.isDone() " + futureTask.isDone());
        System.out.println("futureTask.isCancelled() " + futureTask.isCancelled());
        // 1. Executor can execute a FutureTask
        executorService.execute(futureTask);

        // Do some other work here if needed
        System.out.println("Doing other work...");

        // FutureTask blocks TILL get the result
        String result = futureTask.get();
        System.out.println("Result from the task: " + result);

        // 2. Implementation of RunnableFuture
        // Since it has been ALREADY run -> it's ALREADY completed
        System.out.println("futureTask.isDone() " + futureTask.isDone());

        // 3. Since it's completed -> NOT restarted again
        executorService.execute(futureTask);

        if (isCustomFutureTask) {
            //TODO: It's always returning false
            if (((MyFutureTask<String>) futureTask).runAndReset()) {
                executorService.execute(futureTask);
                // Wait for the task to complete again
                try {
                    String anotherResult = futureTask.get();
                    System.out.println("Result from the second run: " + anotherResult);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Failed to reset the FutureTask");
            }
        }
    }

    // Custom FutureTask class / exposes the runAndReset()
    static class MyFutureTask<V> extends FutureTask<V> {
        public MyFutureTask(Callable<V> callable) {
            super(callable);
        }

        @Override
        public boolean runAndReset() {
            return super.runAndReset();
        }
    }
}
