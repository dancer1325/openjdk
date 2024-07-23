package share.classes.java.util.concurrent.Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ComplexReferenceMain {
    public static void main(String[] args) {
        App app = new App();
        try {
            app.showSearch("example search");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted");
        } finally {
            app.executor.shutdown();
        }
    }

    interface ArchiveSearcher {
        String search(String target);
    }

    // Implementation of the ArchiveSearcher interface
    static class SimpleArchiveSearcher implements ArchiveSearcher {
        @Override
        public String search(String target) {
            // Simulate search operation
            try {
                Thread.sleep(2000); // Simulate a delay in search operation
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Results for: " + target;
        }
    }

    public static class App {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        ArchiveSearcher searcher = new SimpleArchiveSearcher();

        void showSearch(String target) throws InterruptedException {
            Callable<String> task = () -> searcher.search(target);
            Future<String> future = executor.submit(task);
            displayOtherThings(); // do other things while searching

            try {
                displayText(future.get()); // use future
            }
            catch (ExecutionException ex) {
                cleanup();
                return;
            }
        }

        void displayOtherThings() {
            System.out.println("Displaying other things while search is in progress...");
        }

        void displayText(String text) {
            System.out.println("Search result: " + text);
        }

        void cleanup() {
            System.out.println("An error occurred. Cleaning up...");
        }
    }
}
