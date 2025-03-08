* == name == "target name" /
  * ❌NO actions allowed | it ❌
    * == have or NOT the permission
  * standard names
    * `doAs -`
      * TODO:
    * `doAsPrivileged -`
      * TODO:
    * `getSubject -`
      * TODO:
    * `getSubjectFromDomainCombiner -`
      * TODO:
    * `setReadOnly -`
      * enable the caller -- to set a -- `Subject` / read-only
    * `modifyPrincipals -`
      * enable the 
        * the caller -- to modify the -- `Subject.principals`
        * JAAS login module -- to populate -- `Subject.principals`
        * -- can contain -- sensitive information
          * _Example:_ user ids, groups & domain names
    * `modifyPublicCredentials -`
      * enable the caller -- to modify the -- `Subject.pubCredentials`
      * JAAS login module -- to populate -- `Subject.pubCredentials`
      * -- can contain -- sensitive information
        * _Example:_ user ids, groups & domain names
    * `modifyPrivateCredentials -`
      * enable the caller -- to modify the -- `Subject.privCredentials`
      * JAAS login module -- to populate -- `Subject.privCredentials`
      * -- can contain -- sensitive information
        * _Example:_ user ids, groups & domain names
    * `refreshCredential -`
      * TODO:
    * `destroyCredential -`
      * TODO:
    * `createLoginContext.{name} -`
      * -- replacement of -- `createLoginContext -`
      * TODO:
    * `getLoginConfiguration -`
      * TODO:
    * `createLoginConfiguration.{type} -`
      * TODO:
    * `setLoginConfiguration -`
      * TODO:
    * `refreshLoginConfiguration -`
      * TODO:
  * if you implement it -> you can define additional target names / use naming conventions (_Example:_ reverse domain name notation)
* uses
  * -- keep access to the -- 
    * `Subject`
    * `LoginContext`
    * `Configuration`
* if you want to read information | private credentials -> you need `PrivateCredentialPermission`
* TODO: