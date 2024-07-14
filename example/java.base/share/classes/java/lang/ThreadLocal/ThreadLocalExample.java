import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalExample {

    public static void main(String[] args) {
        differentThreadLocalVariablePerThread();

        // TODO: Check if thread goes away -> ThreadLocal instance subject to garbage collection
    }

    private static void differentThreadLocalVariablePerThread() {
        // 1. Different thread-local variables / thread
        Runnable task = () -> {
            int id = ThreadId.get();
            System.out.println("Thread " + Thread.currentThread().getName() + " has ID: " + id);
        };

        // Create and start multiple threads
        for (int i = 0; i < 5; i++) {
            new Thread(task).start();
        }
    }

    public static class ThreadId {
        // Atomic integer containing the next thread ID to be assigned
        private static final AtomicInteger nextId = new AtomicInteger(0);

        // Thread local variable containing each thread's ID
        private static final ThreadLocal<Integer> threadId =
                new ThreadLocal<Integer>() {
                    @Override protected Integer initialValue() {
                        return nextId.getAndIncrement();
                    }
                };

        // Returns the current thread's unique ID, assigning it if necessary, which remains unchanged
        public static int get() {
            return threadId.get();
        }
    }

}
