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
            System.out.println("-- X509Certificate.getSubjectX500Principal() --");
            System.out.println(cert.getSubjectX500Principal());
            System.out.println("-- X509Certificate.getIssuerX500Principal() --");
            System.out.println(cert.getIssuerX500Principal());
            System.out.println("-- ALL X509Certificate --");
            System.out.println(cert.toString());
        } catch (Exception e) {
            e.printStackTrace();  // Handle any potential exceptions
        }
    }
}
