package share.classes.java.util.function.Function;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // 1. Define a functional interface via lambda expression
        //Function<Integer, Integer> increment = (int x) -> x + 1;  // Integer != int -> Error
        //Function<int, int> increment = (int x) -> x + 1;      // primitives NOT allowed
        Function<Integer, Integer> increment = (Integer x) -> x + 1;

        // .apply       because it's the funcitonal method of Function<T, R>
        System.out.println(increment.apply(5));  // Outputs: 6
    }
}

