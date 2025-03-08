package share.classes.java.security.BasicPermission;

import java.security.Permission;

public class Main {
    public static void main(String[] args) {
        // 1. MyPermission     is a concrete class
        MyPermission myPermission = new Main.MyPermission("permissionName");
        System.out.println("myPermission " + myPermission);

        // 2. implies
        MyPermission anotherPermission = new Main.MyPermission("anotherMyPermission");
        System.out.println("myPermission.implies(anotherPermission) " + myPermission.implies(anotherPermission));

        // 3. actions

        // 4. TODO:
    }

    public static class MyPermission extends Permission {
        public MyPermission(String name) {
            super(name);
        }

        @Override
        public boolean implies(Permission permission) {
            if (!(permission instanceof MyPermission))
              return false;
            return this.getName().equals(permission.getName());
        }

        @Override
        public String getActions() {
            return "actions";
        }

        @Override
        public int hashCode() {
            return getName().hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MyPermission)) {
                return false;
            }
            MyPermission other = (MyPermission) obj;
            return this.getName().equals(other.getName());
        }

    }
}