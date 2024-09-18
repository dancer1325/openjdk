* == immutable sequence of serializable certificates /
  * each `Certificate` has
    * type
    * \>=1 supported encodings
      * `byte[] getEncoded(){}`
      * one of those must be marked as default encoding
  * once it's built -> can NOT change externally no field, method or subclass member
    * Reason: 🧠it's immutable either the list & each certificate of the list 🧠
  * serialize
    * == object -- is serialized into an -- equivalent representation
    * Reason: 🧠`implements Serializable` 🧠
  * if X.509 `CertPath` -> 
    * conventions
      * ordered / [target certificate, certificate / -- issued by -- trust anchor] 
      * 👁️issuer of a certificate == subject of the following one 👁️
      * 👁️ certificate / represents the `TrustAnchor` -> must NOT be included | `CertPath` 👁️
    * 👁️PKIX `CertPathValidator` detects if the previous conventions are followed 👁️
      * if that's the case -> 
        * invalid `CertPath` &
        * throws a `CertPathValidatorException` 
* == abstract class / 
  * defines methods & fields common to ALL `CertPath`
    * `String type`
      * == type of `Certificate`
  * subclasses -- can handle -- different kinds of certificates (_Example:_ X.509, PGP)
  * 👁️each `CertPath` object must be thread-safe 👁️
    * multiple threads -- may invoke -- methods of >=1 `CertPath` object / NO side effects 
* way to create `CertPath` objects, via 
  * `CertificateFactory`
  * `CertPathBuilder`
* 👁️ALL implementation of Java platform need to support the `CertPath` encodings 👁️
  * `PKCS7`
  * `PkiPath`
* TODO: