package share.classes.java.util.concurrent.Executor;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

public class Main {
    public static void main(String[] args) {
        // alternative to
        // new Thread(new RunnableTask()).start();

        // 1. submitted task -- run it -- IMMEDIATELY | caller's thread
        // TODO: How to check the thread, when I run it?
        Executor executorFirst = new DirectExecutor();
        executorFirst.execute(new RunnableTask());
        executorFirst.execute(new RunnableTask2());

        // 2. submitted task -- run it -- | thread / != caller's thread
        // TODO: How to check the thread, when I run it?
        Executor executorSecond = new ThreadPerTaskExecutor();
        executorSecond.execute(new RunnableTask());

        // 3. limitations on how & when tasks are scheduled
        // TODO: How to check the limitations, when I run it?
        Executor executorThird = new SerialExecutor(executorFirst);
        executorThird.execute(new RunnableTask());
    }

    public static class DirectExecutor implements Executor {
        public void execute(Runnable r) {
            r.run();
        }
    }

    public static class ThreadPerTaskExecutor implements Executor {
        public void execute(Runnable r) {
            new Thread(r).start();
        }
    }

    public static class SerialExecutor implements Executor {
        final Queue<Runnable> tasks = new ArrayDeque<>();
        final Executor executor;
        Runnable active;

        SerialExecutor(Executor executor) {
            this.executor = executor;
        }

        public synchronized void execute(Runnable r) {
            tasks.add(() -> {
                try {
                    r.run();
                }
                finally {
                    scheduleNext();
                }
            });
            if (active == null) {
                scheduleNext();
            }
        }

        protected synchronized void scheduleNext() {
            if ((active = tasks.poll()) != null) {
                executor.execute(active);
            }
        }
    }

    static class RunnableTask implements Runnable {
        @Override
        public void run() {
            System.out.println("Running RunnableTask " + this.toString());
        }
    }

    static class RunnableTask2 implements Runnable {
        @Override
        public void run() {
            System.out.println("Running RunnableTask2 " + this.toString());
        }
    }

}
