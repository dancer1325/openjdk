# Goals
* `CertPathBuilder` + PKIX algorithm 

## How to run locally?
* Place the cursor at package declaration
* `javac share/classes/java/security/cert/CertPathBuilder/Main.java` 
  * Problems
    * Problem1: `new PKIXBuilderParameters(EnumSet.of(trustAnchor), new X509CertSelector()); ... not applicable`
* `java share.classes.java.security.cert.CertPathBuilder.Main`
  * TODO:
