* class /
  * provider-based architecture
  * 👁️standard `CertPathBuilder` algorithm / required to support by ALL implementation of the Java platform 👁️
    * `PKIX`
      * check "JavaSecurityStandardAlgorithmNamesSpecification.md"
* allows
  * building certification paths == certificate chains
* `CertPathBuilder getInstance(){}`
  * way to create `CertPathBuilder`
* `CertPathBuilderResult build()`
  * return an object / implements `CertPathBuilderResult`
* `CertPathChecker getRevocationChecker() {}`
  * allows
    * specifying additional
      * algorithm-specific parameters
      * options
  * uses
    * ALL additions | revocation status of certificates
* TODO:
