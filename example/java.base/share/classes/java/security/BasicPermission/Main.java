package share.classes.java.security.BasicPermission;

import java.security.BasicPermission;

public class Main {
    public static void main(String[] args) {
        // 1. BasicPermission       is an abstract class
        //BasicPermission basicPermission = new BasicPermission("basicPermissionName");     // ERROR, because it's an abstract class

        // 2. MyBasicPermission     is a concrete class
        BasicPermission basicPermission = new Main.MyBasicPermission("basicPermissionName");
        System.out.println("basicPermission " + basicPermission);

        // 3. actions               unused
        BasicPermission basicPermissionWithActions = new Main.MyBasicPermission("basicPermissionName", "basicPermissionActions");
        System.out.println("basicPermissionWithActions " + basicPermissionWithActions);
        System.out.println("basicPermissionWithActions.getActions() " + basicPermissionWithActions.getActions());
        // ALTHOUGH you pass them, it's NULL

        // 4. TODO:
    }

    public static class MyBasicPermission extends BasicPermission {
        public MyBasicPermission(String name) {
            super(name);
        }

        public MyBasicPermission(String name, String actions) {
            super(name, actions);
        }
    }
}