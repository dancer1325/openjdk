* == parameters /
  * uses
    * inputs for `CertPathValidator`
* vs PKIXBuilderParameters 
  * `CertPathValidator` vs `CertPathBuilder`
* ways to instantiate
  * `PKIXParameters(Set<TrustAnchor> trustAnchors)`
    * check "PKIXBuilderParameters"
  * `PKIXParameters(KeyStore keystore)`
    * TODO:
* if a parameter NOT set or == null -> default value
* ⚠️these methods are NOT thread-safe ⚠️
  * if multiple threads manipulate 1! object concurrently -> should
    * sync amongst themselves
    * provide the necessary locking
* TODO: