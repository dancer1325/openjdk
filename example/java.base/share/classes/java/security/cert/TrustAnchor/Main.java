package share.classes.java.security.cert.TrustAnchor;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.TrustAnchor;
import java.security.cert.CertificateException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws InvalidAlgorithmParameterException, FileNotFoundException, CertificateException {
        // 1. ways to instantiate TrustAnchor
        // 1.1 `TrustAnchor(X509Certificate trustedCert, byte[] nameConstraints)`
        // Trust anchor is a trusted certificate authority (CA)
        TrustAnchor trustAnchor = new TrustAnchor(getTrustedCert(), null);

        System.out.println("-- TrustAnchor.getCAPublicKey() --");
        System.out.println(trustAnchor.getCAPublicKey());
        System.out.println("-- TrustAnchor.getCAName() --");
        System.out.println(trustAnchor.getCAName());
        System.out.println("-- TrustAnchor.getCA() --");
        System.out.println(trustAnchor.getCA());
        System.out.println("-- TrustAnchor.getTrustedCert() --");
        System.out.println(trustAnchor.getTrustedCert());
        System.out.println("-- TrustAnchor.getNameConstraints() --");
        System.out.println(trustAnchor.getNameConstraints());
        /*System.out.println("-- TrustAnchor.isJdkCA() --");
        System.out.println(trustAnchor.isJdkCA());*/        // NOT accesible outside the pacakge
        System.out.println("-- ALL TrustAnchor --");
        System.out.println(trustAnchor);

        // 1.2 TrustAnchor(X500Principal caPrincipal, PublicKey pubKey, byte[] nameConstraints)
        // TODO:

        // 1.3 TrustAnchor(String caName, PublicKey pubKey, byte[] nameConstraints)
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
