package share.classes.javax.crypto.cipher;

import javax.crypto.Cipher;

public class Main {
    public static void main(String[] args) throws Exception {
      // 0. Cipher.getInstance()
      Cipher cipher = Cipher.getInstance("DES");
      System.out.println("cipher " + cipher);

      // 1. .transformation
      // TODO:
    }
}
