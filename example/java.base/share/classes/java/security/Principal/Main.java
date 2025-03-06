package share.classes.java.security.Principal;

import java.security.Principal;

public class Main {
    public static void main(String[] args) {
        // 1. implement Principal
        Principal principal = new Main.SimpleIdentity("user");
        System.out.println(principal);

        // 2. TODO:

    }

    public static class SimpleIdentity implements Principal {

        String username;

        public SimpleIdentity(Object user) {
            this.username = (String) user;
        }

        @Override
        public String getName() {
            return username;
        }

        @Override
        public boolean equals(Object obj) {

            if (obj instanceof SimpleIdentity) {
                return ((SimpleIdentity) obj).getName().equals(getName());
            }

            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

    }
}