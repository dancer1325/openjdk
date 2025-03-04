* uses
  * 💡system resource access decisions -- are based on the -- context / it encapsulates 💡
* use cases
  * \+  `SecurityManager`
* ⚠️deprecated & PENDING to be removed ⚠️
  * Reason: 🧠`SecurityManager` is deprecated & MAIN use case 🧠
* `ProtectionDomain[] context`
  * == encapsulated context
* `public void checkPermission(Permission perm){}`
  * vs `AccessController.checkPermission()`
    * 👀access decisions -- are based on -- encapsulated context vs current execution thread 👀 
  * code | DIFFERENT context -> can call to `.checkPermission()`
* `AccessController.getContext()`
  * ⚠️== way to instantiate `AccessControlContext` ⚠️
* TODO: