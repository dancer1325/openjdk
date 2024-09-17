package share.classes.java.security.cert.X509Certificate;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class Main {
    public static void main(String[] args) {
        try (InputStream inStream = new FileInputStream("share/classes/java/security/cert/X509Certificate/sample.cer.txt")) {
            // Get an instance of the CertificateFactory for X.509 certificates
            CertificateFactory cf = CertificateFactory.getInstance("X.509");

            // Generate the X.509 certificate from the input stream
            X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);

            // Now you can use the cert object, e.g., print certificate details
            System.out.println("Certificate Information: " + cert.toString());
        } catch (Exception e) {
            e.printStackTrace();  // Handle any potential exceptions
        }
    }
}
