package share.classes.java.security.cert.PKIXParameters;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.security.cert.PKIXParameters;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.TrustAnchor;
import java.security.cert.CertificateException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws InvalidAlgorithmParameterException, FileNotFoundException, CertificateException {
        // 1. ways to instantiate PKIXParameters
        // 1.1 `PKIXParameters(Set<TrustAnchor> trustAnchors)`
        // Trust anchor is a trusted certificate authority (CA)
        TrustAnchor trustAnchor = new TrustAnchor(getTrustedCert(), null); // Replace with the actual CA certificate

        PKIXParameters params = new PKIXParameters(Collections.singleton(trustAnchor));

        System.out.println("-- PKIXParameters.getDate() --");
        System.out.println(params.getDate());
        System.out.println("-- PKIXParameters.getCertPathCheckers() --");
        System.out.println(params.getCertPathCheckers());
        System.out.println("-- PKIXParameters.getSigProvider() --");
        System.out.println(params.getSigProvider());
        System.out.println("-- PKIXParameters.isRevocationEnabled() --");
        System.out.println(params.isRevocationEnabled());
        System.out.println("-- PKIXParameters.getInitialPolicies() --");
        System.out.println(params.getInitialPolicies());
        System.out.println("-- PKIXParameters.isExplicitPolicyRequired() --");
        System.out.println(params.isExplicitPolicyRequired());
        System.out.println("-- PKIXParameters.isPolicyMappingInhibited() --");
        System.out.println(params.isPolicyMappingInhibited());
        System.out.println("-- PKIXParameters.isAnyPolicyInhibited() --");
        System.out.println(params.isAnyPolicyInhibited());
        System.out.println("-- PKIXParameters.getPolicyQualifiersRejected() --");
        System.out.println(params.getPolicyQualifiersRejected());
        System.out.println("-- PKIXParameters.getCertStores() --");
        System.out.println(params.getCertStores());
        System.out.println("-- PKIXParameters.getTargetCertConstraints() --");
        System.out.println(params.getTargetCertConstraints());
        System.out.println("-- PKIXParameters.getTrustAnchors() --");
        System.out.println(params.getTrustAnchors());       // vs ALL == most of PKIXParameters are default
        System.out.println("-- ALL PKIXParameters --");
        System.out.println(params);

        // 1.2 PKIXParameters(KeyStore keystore)
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
