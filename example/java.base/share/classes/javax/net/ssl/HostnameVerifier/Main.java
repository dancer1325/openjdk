package share.classes.javax.net.ssl.HostnameVerifier;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class Main {
    public static void main(String[] args) throws Exception {
        // Example URL that uses HTTPS
        String httpsUrl = "https://example.com";

        // Create the HostnameVerifier
        HostnameVerifier customVerifier = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                // Custom logic to verify hostname
                if (hostname.equals("example.com")) {
                    System.out.println("Hostname verification passed.");
                    return true;
                } else {
                    System.out.println("Hostname verification failed.");
                    return false;
                }
            }
        };

        // Open an HTTPS connection
        HttpsURLConnection connection = (HttpsURLConnection) new java.net.URL(httpsUrl).openConnection();

        // Set the custom HostnameVerifier
        connection.setHostnameVerifier(customVerifier);

        // Perform the connection / triggers the handshake
        // 1. Perform the connection (this does NOT trigger the handshake)
        connection.connect();
        // 2. Get the response      // This does NOT trigger the handshake*/
        /*connection.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
         */
    }
}
