* uses
  * | system input & output -- through -- data streams
    * serialization
    * file system
* 👁️by default, if you `SomeConstructorHereInThisPackage(null, ...)` or `SomeMethodHereInThisPackage(null, ...)` -> throws `NullPointerException` 👁️
* 👁️if you `SomeConstructorHereInThisPackage(pathNameString, ...)` or `SomeMethodHereInThisPackage(pathNameString, ...)` -- interpreted based on -- `File` 👁️
* recommendations
  * 👁️NOT deserialize untrusted data 👁️ 
    * Check
      * [Secure Coding Guidelines for Java SE](https://www.oracle.com/java/technologies/javase/seccodeguide.html)
      * [Java Object Serialization Specification](https://docs.oracle.com/en/java/javase/21/docs/specs/serialization/index.html)
      * [Serialization Filtering](https://docs.oracle.com/en/java/javase/21/core/serialization-filtering1.html)
      * [The serialver Command](https://docs.oracle.com/en/java/javase/21/docs/specs/man/serialver.html)
