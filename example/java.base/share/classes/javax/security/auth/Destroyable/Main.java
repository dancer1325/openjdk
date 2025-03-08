package share.classes.javax.security.auth.Destroyable;

import javax.security.auth.Destroyable;
import javax.security.auth.DestroyFailedException;

public class Main {
    public static void main(String[] args) throws Exception {
        // 0. new MyDestroyable()
        MyDestroyable myDestroyableDefault = new Main.MyDestroyable();
        System.out.println("myDestroyableDefault " + myDestroyableDefault);

        System.out.println("myDestroyableDefault.isDestroyed() " + myDestroyableDefault.isDestroyed());
        try {
            myDestroyableDefault.destroy();
        } catch (DestroyFailedException e) {
            e.printStackTrace();
        }
        System.out.println("myDestroyableDefault.isDestroyed() " + myDestroyableDefault.isDestroyed());     // by default, it's `false`
        System.out.println("myDestroyableDefault " + myDestroyableDefault);

        // 1. new MyDestroyable()
        MyDestroyable myDestroyable = new Main.MyDestroyable();
        System.out.println("myDestroyable.isDestroyed() " + myDestroyable.isDestroyed());
        try {
            myDestroyable.destroy();
        } catch (DestroyFailedException e) {
            e.printStackTrace();
        }
        System.out.println("myDestroyable.isDestroyed() " + myDestroyable.isDestroyed()); // != null        != destroyed
        System.out.println("myDestroyable " + myDestroyable);
    }

    public static class MyDestroyableDefault implements Destroyable { }

    public static class MyDestroyable implements Destroyable {
        //      property / manages the destroyment
        private boolean destroyed = false;
        @Override
        public void destroy() throws DestroyFailedException {
            System.out.println("MyDestroyable.destroy()");
            this.destroyed = true;
        }
        @Override
        public boolean isDestroyed() {
            return destroyed;
        }
    }
}
