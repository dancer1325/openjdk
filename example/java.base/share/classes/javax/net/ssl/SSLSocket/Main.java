package share.classes.javax.net.ssl.SSLSocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Main {
    public static void main(String[] args) throws Exception {
      // SSLSocket sslSocket = new SSLSocket();         // ERROR, because it's abstract
      // Get an SSLSocketFactory instance
      SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

      // Create an SSLSocket instance connected to the desired host and port
      //SSLSocket sslSocket = (SSLSocket) factory.createSocket("www.example.com", 443);
      SSLSocket sslSocket = (SSLSocket) factory.createSocket("www.google.com", 443);

      // Start SSL handshake
      sslSocket.startHandshake();

      String networkString = sslSocket.getHandshakeApplicationProtocol();
      System.out.println(networkString);
      byte[] bytes = networkString.getBytes(StandardCharsets.ISO_8859_1);
 
      //
      // Match using bytes:
      //
      //   "http/1.1"                       (7-bit ASCII values same in UTF-8)
      //   MEETEI MAYEK LETTERS "HUK UN I"  (Unicode 0xabcd->0xabcf)
      //
      String HTTP1_1 = "http/1.1";
      byte[] HTTP1_1_BYTES = HTTP1_1.getBytes(StandardCharsets.UTF_8);
 
      byte[] HUK_UN_I_BYTES = new byte[] {
                         (byte) 0xab, (byte) 0xcd,
          (byte) 0xab, (byte) 0xce,
          (byte) 0xab, (byte) 0xcf};

      // ways to compare
      // 1. directly
      if ((Arrays.compare(bytes, HTTP1_1_BYTES) == 0 )
                             || Arrays.compare(bytes, HUK_UN_I_BYTES) == 0) {

      }
 
      // 2. convert to Unicode
      // Alternatively match using string.equals() if we know the ALPN value
      // was encoded from a {@code String} using a certain character set,
      // for example {@code UTF-8}.  The ALPN value must first be properly
      // decoded to a Unicode {@code String} before use.
      //
      String unicodeString = new String(bytes, StandardCharsets.UTF_8);
        /*if (unicodeString.equals(HTTP1_1)
                || unicodeString.equals("\u005cuabcd\u005cuabce\u005cuabcf")) {

        }*/
    }
}
