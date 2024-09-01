package share.classes.java.util.concurrent.ForkJoinTask;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Main {

    // Define a ForkJoinTask subclass
    static class SumTask extends RecursiveTask<Integer> {
        private final int[] arr;
        private final int start, end;

        SumTask(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            // If the task is small enough, compute directly
            if (end - start <= 2) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += arr[i];
                }
                return sum;
            } else {
                // Otherwise, split the task into two smaller tasks
                int mid = (start + end) / 2;
                SumTask leftTask = new SumTask(arr, start, mid);
                SumTask rightTask = new SumTask(arr, mid, end);

                // Fork the left task (execute it asynchronously in commonPool)
                leftTask.fork();

                // Compute the right task directly
                int rightResult = rightTask.compute();

                // Wait for the left task result and combine
                int leftResult = leftTask.join();

                return leftResult + rightResult;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // 1. Explicitly submitting the task to a ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(numbers, 0, numbers.length);
        int result = pool.invoke(task); // Submits and waits for completion
        System.out.println("Sum using explicit ForkJoinPool: " + result);

        // 2. Using ForkJoinPool#commonPool() via fork
        SumTask commonTask = new SumTask(numbers, 0, numbers.length);
        ForkJoinTask<Integer> commonResult = commonTask.fork(); // Forks the task into commonPool
        System.out.println("Sum using ForkJoinPool.commonPool(): " + commonResult.join()); // Waits for completion
    }
}
