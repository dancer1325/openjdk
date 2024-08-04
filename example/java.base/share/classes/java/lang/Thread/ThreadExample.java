package share.classes.java.lang.Thread;
// Remove it, to avoid being related to others -- TODO: Why if you add package -> dependency between other?

import java.lang.Thread;
import java.security.AccessControlContext;
import java.security.AccessController;

public class ThreadExample {

    public static void main(String[] args) {
        waysToCreateAThread();
    }

    private static void waysToCreateAThread() {
        // 1. constructor
        // 1.1 Thread()
        Thread thread1 = new Thread();

        // 1.2 Thread(ThreadGroup g, String name, int characteristics, Runnable task, long stackSize, AccessControlContext acc)
        /*// NOT allowed, because it's a private method
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Task is running.");
            }
        };
        // Create a ThreadGroup
        ThreadGroup threadGroup = new ThreadGroup("CustomThreadGroup");
        // Get the current AccessControlContext
        AccessControlContext acc = AccessController.getContext();
        // Create a Thread with the specified constructor
        Thread customThread = new Thread(threadGroup, "CustomThread", 0, task, 0, acc);*/

        // 1.3 Thread(String name, int characteristics, boolean bound)
        /*Thread thread2 = new Thread("Thread3", 0, true);
        // NOT allowed, because it's a private method*/

        // 1.4 Thread(Runnable task)
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Task is running.");
            }
        };
        Thread thread4 = new Thread(task);

        // TODO: Add rest of constructors

        // 2. builder
        // 2.1 ofVirtual()          -- Uncomment to use it
        /*Thread threadViaBuilder = Thread.ofVirtual()
                .name("Alfred")
                .unstarted(task);
        threadViaBuilder.start();*/
        // 2.2 OfPlatform()
        // TODO:
    }
}
