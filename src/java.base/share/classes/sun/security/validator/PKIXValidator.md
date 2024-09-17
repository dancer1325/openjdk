* == validator implementation / built | PKIX CertPath API
  * -> requires
    * PKIX validator
    * PKIX builder
* allows
  * better
    * performance
    * exception messages
* 's instances
  * are immutable
    * Reason: 🧠 `final` class 🧠
  * if instance ALREADY created -> NOT add methods / can change the state of the instance
* TODO: