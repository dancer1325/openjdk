# The keytool Command
* Information hosted in internet by Oracle -- https://docs.oracle.com/en/java/javase/XY/docs/specs/man/keytool.html
  * [Java SE 22](https://docs.oracle.com/en/java/javase/22/docs/specs/man/keytool.html)
* == key and certificate management utility
* allows
  * admin your own public/private key pairs + associated certificates
  * caching communicating peers' public keys
    * -- via -- cacerts
* uses
  * self-authentication
    * == user authenticates  himself -- to -- other users & services
  * data integrity
    * == NOT modified
  * authentication services
* certificate
  * := statement digitally signed from an entity / 
    * entity: person, company, ...
    * == public key + other information
* keystore
  * := place to store keys & certificates
* "jdk.certpath.disabledAlgorithms" & "jdk.security.legacyAlgorithms"
  * 's properties
    * -- determine -- algorithms / -- considered as -- security risk
    * defined | "$JAVA_HOME/conf/security"
  * if it's disabled OR legacy algorithms used -> emit warnings
* TODO:
* `keytool [commands]`
  * `keytool -importcert options`
    * import certificate OR certificate chain
    * `options`
      * `-trustcacerts`
        * trust certificates -- from -- cacerts
      * `-alias alias`
        * alias name of the entry to process
      * `-cacerts`
        * -- access to -- cacerts keystore
      * `-keypass changeit`
        * key password
      * `-storepass changeit`
        * keystore password
      * `-file file`
        * input file name
    * TODO:
  * `keytool -list options`
    * list keystore's entries
    * `options`
      * `-v`
        * verbose output
      * `-keystore keystorePath`
        * specify keystore
        * if you do NOT pass this option -> "$HOME.keystore" by default
    * TODO:
  * TODO: