package share.classes.java.security.cert.CertPathBuilder;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.PKIXRevocationChecker.Option;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.TrustAnchor;
import java.util.EnumSet;

public class Main {
    public static void main(String[] args) {
        // Trust anchor is a trusted certificate authority (CA)
        TrustAnchor trustAnchor = new TrustAnchor(getTrustedCert(), null); // Replace with the actual CA certificate

        PKIXBuilderParameters params = new PKIXBuilderParameters(EnumSet.of(trustAnchor), new X509CertSelector());

        CertPathBuilder cpb = CertPathBuilder.getInstance("PKIX");
        PKIXRevocationChecker rc = (PKIXRevocationChecker)cpb.getRevocationChecker();
        rc.setOptions(EnumSet.of(Option.PREFER_CRLS));
        params.addCertPathChecker(rc);
        CertPathBuilderResult cpbr = cpb.build(params);

        CertPath certPath = cpbr.getCertPath();
        System.out.println(certPath);
    }

    private static X509Certificate getTrustedCert() {
        try (InputStream inStream = new FileInputStream("share/classes/java/security/cert/X509Certificate/sample.cer.txt")) {
            // Get an instance of the CertificateFactory for X.509 certificates
            CertificateFactory cf = CertificateFactory.getInstance("X.509");

            // Generate the X.509 certificate from the input stream
            X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);
        } catch (Exception e) {
            e.printStackTrace();  // Handle any potential exceptions
        }
    }
}
