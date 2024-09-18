package share.classes.java.security.cert.CertPath;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. Ways to creata a CertPath instance
            // 1.1 via CertificateFactory
            // Load the certificates from a file (replace with your cert file path)
            InputStream certStream = new FileInputStream("share/classes/java/security/cert/X509Certificate/sample.cer.txt");

            // Create a CertificateFactory for X.509 certificates
            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");

            // Generate individual certificates from the input stream
            List<Certificate> certList = new ArrayList<>();
            while (certStream.available() > 0) {
                X509Certificate cert = (X509Certificate) certFactory.generateCertificate(certStream);
                certList.add(cert);
            }

            // Create a CertPath using the CertificateFactory
            CertPath certPath = certFactory.generateCertPath(certList);

            // Print out the generated CertPath
            System.out.println("CertPath created using CertificateFactory:");
            System.out.println(certPath);

            // 1.2 via CertPathBuilder
            // check "../CertPathBuilder"
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
