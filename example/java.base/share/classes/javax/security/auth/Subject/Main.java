package share.classes.javax.security.auth.Subject;

import javax.security.auth.Subject;
import java.security.Principal;

public class Main {
    public static void main(String[] args) throws Exception {
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
}
