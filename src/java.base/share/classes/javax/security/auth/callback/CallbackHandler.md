* allows
  * retrieving specific authentication data (_Example:_ usernames and passwords)
  * displaying certain information (_Example:_ error and warning messages)
* uses
  * pass it | underlying security services /
    * make requests / DIFFERENT types of information
* way to implement
  * application-dependent fashion
    * _Examples:_
      * _Example1:_ implementation / graphical user interface (GUI) pop up windows to request information
      * _Example2:_  implementation / obtain requested information -- WITHOUT asking the end user, from an -- alternate source 
* if you set `auth.login.defaultCallbackHandler`
  * -> it's specified a default `CallbackHandler` class implementation
    * requirements
      * ⚠️0 arguments constructor ⚠️
  * = `fullyQualifiedNameOfCallbackHandler` -> `LoginContext`
    * load the specified `CallbackHandler`
      * if NONE was provided -> loads ONLY the default handler
    * pass it -- to the -- underlying `LoginModules`
* TODO: