package share.classes.javax.security.auth.Subject;

import javax.security.auth.Subject;
import javax.security.auth.Destroyable;
import javax.security.auth.DestroyFailedException;
import java.security.Principal;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
      // 0. new Subject()
      Subject subject = new Subject();

      // 1. principal
      Principal principal = new Principal() {
        @Override
        public String getName() {
          return "test";
        }
      };

      System.out.println("[BEFORE] subject.getPrincipals().size() " + subject.getPrincipals().size());
      subject.getPrincipals().add(principal);   // way to ADD principals
      System.out.println("[AFTER] subject.getPrincipals().size() " + subject.getPrincipals().size());
      System.out.println("subject " + subject);

      // 2. pubCredentials
      UserToken userToken = new UserToken("user123", "session-xyz-789");

      subject.getPublicCredentials().add(userToken);
      System.out.println("subject.getPublicCredentials() " + subject.getPublicCredentials());   // way to ADD pubCredentials

      // 3. new Subject(boolean readOnly, Set<? extends Principal> principals, Set<?> pubCredentials, Set<?> privCredentials) {}
      Subject subjectWithArguments = new Subject(true, Set.of(principal), Set.of(userToken), Set.of(userToken));
      System.out.println("subjectWithArguments " + subjectWithArguments);

      // 4.     readOnly
      // 4.1    NOT allowed modifying
        try {
            subjectWithArguments.getPrincipals().add(principal);   // ERROR, because NOT allowed adding Subject.principals
        } catch (IllegalStateException e) {
            System.out.println("subjectWithArguments.getPrincipals().add(principal) " + e.getMessage());
        }

        try {
            subjectWithArguments.getPublicCredentials().add(userToken);   // ERROR, because NOT allowed adding Subject.pubCredentials
        } catch (IllegalStateException e) {
            System.out.println("subjectWithArguments.getPublicCredentials().add(userToken) " + e.getMessage());
        }

      // 4.2    allowed deletion
      // 4.2.1      NOT if credentials do NOT implement Destroyable
      // subjectWithArguments.getPublicCredentials().clear();       // ERROR
      // 4.2.2      YES if credentials -- implement -- Destroyable
      Subject subjectWithDestroyableCredentials = new Subject();
      DestroyableCredential destroyableCredential = new DestroyableCredential();
      subjectWithDestroyableCredentials.getPublicCredentials().add(destroyableCredential);
      System.out.println("subjectWithDestroyableCredentials.getPublicCredentials() " + subjectWithDestroyableCredentials.getPublicCredentials());
      subjectWithDestroyableCredentials.getPublicCredentials().remove(destroyableCredential);
      System.out.println("subjectWithDestroyableCredentials.getPublicCredentials() " + subjectWithDestroyableCredentials.getPublicCredentials());
      // NO publicCredentials

      // TODO:
    }

  /**
   * SIMPLE credential class
   */
  static class UserToken {
      private String userId;
      private String sessionId;

      public UserToken(String userId, String sessionId) {
        this.userId = userId;
        this.sessionId = sessionId;
      }

      public String getUserId() {
        return userId;
      }

      public String getSessionId() {
        return sessionId;
      }

      @Override
      public String toString() {
        return "UserToken{userId='" + userId + "', sessionId='" + sessionId + "'}";
      }
    }

    /**
     * Credential class / implements Destroyable
     */
    static class DestroyableCredential implements Destroyable {
        private boolean destroyed = false;

        @Override
        public void destroy() throws DestroyFailedException {
            // Cleanup sensitive information
            System.out.println("invoked destroy()");
            destroyed = true;
        }

        @Override
        public boolean isDestroyed() {
            return destroyed;
        }
    }
}
