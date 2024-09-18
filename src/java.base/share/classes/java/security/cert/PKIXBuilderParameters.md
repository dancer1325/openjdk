* == parameters /
  * uses
    * inputs for `CertPathBuilder`
      * `CertPathBuilderResult CertPathBuilder.build(CertPathParameters){}`
      * if the inputs validated against `PKIX` certification -> creates `CertPath`
* ways to instantiate
  * `PKIXBuilderParameters(Set<TrustAnchor> trustAnchors, CertSelector targetConstraints)`
    * `Set<TrustAnchor>` / each one identifies a most-trusted CA
    * `CertSelector targetConstraints`
      * used to filter the certificate -- by -- `CertPathBuilder`
        * _Example:_ minimal criteria for an `X509Certificate`
          * subject name
          * \>= 1 subject alternative names
        * if enough criteria NOT specified -> `CertPathBuilder` throws a `CertPathBuilderException`
  * `PKIXBuilderParameters(KeyStore keystore, CertSelector targetConstraints)`
    * TODO:
* ⚠️these methods are NOT thread-safe ⚠️
  * if multiple threads manipulate 1! object concurrently -> should
    * sync amongst themselves
    * provide the necessary locking
* TODO: