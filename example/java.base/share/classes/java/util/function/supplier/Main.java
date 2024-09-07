package share.classes.java.util.function.supplier;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // Example 1: Using Supplier with a Lambda expression
        Supplier<String> messageSupplier = () -> "Hello from Supplier!";

        // Calling get() method to get the result
        String message = messageSupplier.get();
        System.out.println(message);

        // Example 2: Using Supplier with a method reference
        Supplier<Double> randomSupplier = Math::random;

        // Getting a random value from Supplier
        Double randomValue = randomSupplier.get();
        System.out.println("Random Value: " + randomValue);

        // Example 3: Using Supplier for deferred execution
        Supplier<Integer> numberSupplier = () -> 42;
        printSuppliedValue(numberSupplier);
    }

    // Method that accepts a Supplier and prints the supplied value
    public static void printSuppliedValue(Supplier<Integer> supplier) {
        System.out.println("Supplied Value: " + supplier.get());
    }
}
