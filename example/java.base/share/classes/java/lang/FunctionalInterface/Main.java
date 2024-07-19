package share.classes.java.lang.FunctionalInterface;
//package share.classes.java.lang.FunctionalInterface.src.main;
//package main;

public class Main {
    public static void main(String[] args) {
        // Create an instance of a functional interface
        Calculator calculator = (int a, int b) -> a + b;
        System.out.println("share.classes.java.lang.FunctionalInterface " + calculator);
        System.out.println(calculator.getClass());
    }
}
