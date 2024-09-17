# Java Security Standard Algorithm Names
* Information hosted in internet by Oracle -- https://docs.oracle.com/en/java/javase/XY/docs/specs/security/standard-names.html
  * [Java SE 23](https://docs.oracle.com/en/java/javase/23/docs/specs/security/standard-names.html)
* standard names 
  * ⭐for⭐
    * algorithms
    * certificate
    * keystore types
  * 👁️required by Java SE Security API👁️
    * SE implementation may support additional algorithms / NOT defined here
  * rules
    * 👁️NOT case-sensitive 👁️
* `<items>` == placeholders
  * _Example:_ <digest> == placeholder / -- be replaced by a -- specific message digest

* TODO:

## **CertPathBuilder Algorithms**
* uses
  * generating an instance of `CertPathBuilder`
* `PKIX`
  * algorithm name
  * check [Service attributes](#service-attributes)
* `CertPathBuilder` instances / implement `PKIX` == `CertPath` / -- validated against the -- PKIX 

* TODO:

## Service attributes
* uses 
  * | cryptographic services
    * filters -- for -- selecting providers
* cryptographic service
  * 👁️ -- associated with -- particular algorithm or type 👁️
    * _Example1:_ digital signature service -- is associated with a -- particular algorithm (for example, DSA)
    * _Example2:_ CertificateFactory service -- is associated with a -- particular certificate type (for example, X.509)
* 👁️ attribute name & value are case-insensitive 👁️
* TODO:
* `ValidationAlgorithm`
  * == specification name of the certification path validation / -- supported by an -- implementation of `CertPathBuilder` or `CertPathValidator`
    * for RFCs -- "RFC#" -- _Example:_ "RFC5280"
    * for Internet Drafts -- "draft-name#" -- _Example:_ "draft-ietf-pkix-rfc2560bis-01.txt"
    * -> ALL PKIX implementations of `CertPathBuilder` must provide a value for this attribute
* TODO:
