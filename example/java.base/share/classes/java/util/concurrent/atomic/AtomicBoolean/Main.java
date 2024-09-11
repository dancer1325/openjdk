package share.classes.java.util.concurrent.atomic.AtomicBoolean;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        AtomicBoolean atomicBooleanFirst = new AtomicBoolean();
        AtomicBoolean atomicBooleanSecond = new AtomicBoolean(true);

        System.out.println("atomicBooleanFirst " + atomicBooleanFirst);
        System.out.println("atomicBooleanSecond " + atomicBooleanSecond);
    }
}