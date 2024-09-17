* 👁️this is "master security properties file" 👁️
  * if it fails to load -> JDK implementation throws unspecified error | initializing "java.security.Security"
  * 's properties
    * -- used by -- "java.security"
    * -- are parsed -- 1! time
      * ⚠️if SOME property is modified -> application should be restarted ⚠️ 
  * allows
    * registering Cryptography Package Providers
      * `security.provider.<n>=<provName | className>`
        * way to register a provider
        * `<n>`
          * preference order of the provider | requested algorithms
            * order is 1-based == 1 MOST preferred, afterward 2, ...
        * TODO:
      * == implementation of Java Security API's cryptography aspects
        * ⚠️ each provider must implement Provider's subclass ⚠️ 
      * \>=1 digital signature algorithms or message digest algorithms / provider
* `-Djava.security.properties=<URL>`
  * masterSecurityProperties + oneYouPassHere
    * oneYouPassHere properties override shared keys
* `security.overridePropertiesFile=false` | masterSecurityProperties
  * disable specify additional properties
  * `=true`, by default