* == most-trusted CA
  * == `PublicKey` + `caName` + constraints
    * `PublicKey`
      * == public key of the CA 
    * `caName`
      * CA's name
    * constraints | set of paths / validated with the key
* uses
  * trust anchor -- for -- validating X.509 certification paths
* ways to instantiate
  * `TrustAnchor(X509Certificate trustedCert, byte[] nameConstraints){}`
    * == parameters are specified -- via -- `X509Certificate` 
  * `TrustAnchor(X500Principal caPrincipal, PublicKey pubKey, byte[] nameConstraints){}`
    * TODO:
  * `TrustAnchor(String caName, PublicKey pubKey, byte[] nameConstraints){}`
    * TODO:
* 👁️`TrustAnchor` instances are immutable & thread-safe 👁️
  * thread-safe == if multiple thread invoke methods | 1! object -> NO side effects