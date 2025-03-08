package share.classes.javax.security.auth.AuthPermission;

import javax.security.auth.AuthPermission;
import java.security.AccessController;
import java.lang.SecurityManager;

public class Main {
    public static void main(String[] args) throws Exception {
      // 0. new AuthPermission(String name)
      AuthPermission authPermission = new AuthPermission("constructorWithName");
      System.out.println("authPermission " + authPermission);
        
      // 1.     modifyPrincipals -
      AuthPermission authPermissionModifyPrincipals = new AuthPermission("modifyPrincipals");
      try {
          // 1.1    check -- via -- SecurityManager
          System.setSecurityManager(new SecurityManager());
          SecurityManager sm = System.getSecurityManager();
          System.out.println("SecurityManager " + sm);
          if (sm != null) {
              sm.checkPermission(authPermissionModifyPrincipals);
              System.out.println("Permission granted to modify principals");
          }
          // 1.2    check -- via -- AccessController
          /*AccessController.checkPermission(authPermissionModifyPrincipals);
          System.out.println("Permission granted to modify principals");*/
      } catch (Exception e) {
          System.out.println("Permission NOT granted to modify principals");    // TODO: Fix, why NOT granted?
      }


      // 2.     modifyPublicCredentials -
      // TODO:

      // 3.     modifyPrivateCredentials -
      // TODO:

      // 4.     setReadOnly -
        try {
            AuthPermission readOnlyPermission = new AuthPermission("setReadOnly");

            // Check if the current code has this permission
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                sm.checkPermission(readOnlyPermission);
                System.out.println("Permission granted to set Subject as read-only");
            } else {
                // Since SecurityManager is likely null in modern Java
                System.out.println("SecurityManager is not enabled");
            }

        } catch (SecurityException e) {
            System.out.println("Permission denied to set Subject as read-only: " + e.getMessage()); // TODO: Fix, why an error is thrown?
        }

    }

}
