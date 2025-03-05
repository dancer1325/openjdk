* := grouping of related information / 1! entity (_Example:_ person)
* == Subject's identities + security-related attributes (_Example:_ passwords & cryptographic keys)
  * identities
    * -- represented by a -- `Principal` 
    * 👀allowed MULTIPLE identities / EACH subject 👀 
      * _Example:_ let's have the person Alice, as a `Subject` / has as `Principal`
        * "Alice Bar" == name | her driver license
        * "999-99-9999" == number | her student identification card
  * security-related attributes
    * ' types
      * `pubCredentials`
      * `privCredentials`
    * if you want to access & modify them -> you need permissions
* `Set<Principal> principals;`
  * 💡bind names -- to a -- `Subject` 💡
  * if you want to ADD -> `.getPrincipals().add(principal)`
* `Set<Object> privCredentials`
  * _Example:_ private cryptographic keys
* `Set<Object> pubCredentials;`
  * uses
    * share them
  * _Example:_ public key certificates or Kerberos server tickets
  * if you want to ADD -> `.getPublicCredentials().add(credential)`
* `implements java.io.Serializable`
  * TODO:
* `Subject(boolean readOnly, Set<? extends Principal> principals, Set<?> pubCredentials, Set<?> privCredentials) {}`
  * create a `Subject` instance / copies the passed `principals`, `pubCredentials` & `privCredentials`
  * `principals`
    * if you want to modify it -> requires `AuthPermission("modifyPrincipals")` & `readOnly=false`
  * `pubCredentials`
    * if you want to modify it -> requires `AuthPermission("modifyPublicCredentials")` & `readOnly=false`
  * `privCredentials`
    * if you want to modify it -> requires `AuthPermission("modifyPrivateCredentials")` & `readOnly=false`
* TODO:
