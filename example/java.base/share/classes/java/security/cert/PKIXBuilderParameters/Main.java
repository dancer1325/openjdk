package share.classes.java.security.cert.PKIXBuilderParameters;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.TrustAnchor;
import java.security.cert.CertificateException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws InvalidAlgorithmParameterException, FileNotFoundException, CertificateException {
        // 1. ways to instantiate PKIXBuilderParameters
        // 1.1 `PKIXBuilderParameters(Set<TrustAnchor> trustAnchors, CertSelector targetConstraints)`
        // Trust anchor is a trusted certificate authority (CA)
        TrustAnchor trustAnchor = new TrustAnchor(getTrustedCert(), null); // Replace with the actual CA certificate

        PKIXBuilderParameters params = new PKIXBuilderParameters(Collections.singleton(trustAnchor), new X509CertSelector());

        System.out.println(params);

        // 1.2 PKIXBuilderParameters(KeyStore keystore, CertSelector targetConstraints)
        // TODO:
    }

    private static X509Certificate getTrustedCert() throws FileNotFoundException, CertificateException {
        InputStream inStream = new FileInputStream("share/classes/java/security/cert/X509Certificate/sample.cer.txt");

        // Get an instance of the CertificateFactory for X.509 certificates
        CertificateFactory cf = CertificateFactory.getInstance("X.509");

        // Generate the X.509 certificate from the input stream
        return (X509Certificate) cf.generateCertificate(inStream);
    }
}
