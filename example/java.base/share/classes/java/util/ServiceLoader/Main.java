package share.classes.java.util.ServiceLoader;

import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {

        // 1. load()
        ServiceLoader.load(PaymentProcessor.class);

        // 2. TODO: if the application is a module -> module declaration must have `uses` directive / specify the service
    }
}
