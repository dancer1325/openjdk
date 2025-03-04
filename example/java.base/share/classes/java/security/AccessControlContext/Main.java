package share.classes.java.security.AccessControlContext;

import java.security.AccessControlContext;
import java.security.AccessController;

public class Main {
    public static void main(String[] args) {
        // 1. ways to instantiate AccessControlContext
        // 1.1 `AccessController.getContext()`
        AccessControlContext acc = AccessController.getContext();
        System.out.println("-- AccessControlContext -- " + acc);

        // 2. code | DIFFERENT context -> can call to `.checkPermission()`
        // TODO: comprehend and add FULL example
        //acc.checkPermission(permission);
    }
}
