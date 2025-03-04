* == service-provider interface
  * uses
    * | applications,
      * -- provide a -- particular type of authentication
      * -> write | `LoginContext` API
      * 👀allowed SEVERAL `LoginModule` / NO require modify the application 👀
      * == 1! operation
    * | authentication technology providers,
      * implement `LoginModule`
      * == 
        * 1ª phase
          * `LoginModule.login()` -- is invoked by the -- `LoginContext.login()`
        * 2ª phase
          * if `LoginContext`'s overall authentication 
            * succeeded -> `LoginModule.commit()` is invoked
            * failed -> `LoginModule.abort()` is invoked
* -- depends on -- `Configuration`
* `initialize(Subject subject, CallbackHandler callbackHandler, Map<String,?> sharedState, Map<String,?> options)`
  * `Subject`
    * == CURRENT Subject / is
      * authenticated
      * if authentication succeeds -> updated -- via -- relevant Credentials 
  * `callbackHandler`
    * allows
      * -- communicating with -- users
      * prompting for usernames & passwords
  * `sharedState`
    * == shared `LoginModule`
    * allows
      * sharing state -- between -- `LoginModule`S
  * `options`
    * == LoginModule-specific options
    * == configured options | login `Configuration`
    * -- defined by the -- `LoginModule`
    * allows
      * controlling the `LoginModule`'s behavior
    * `key=value`
      * 👀syntax 👀
  * TODO:
* `boolean login()`
  * in charge of
     * actual authentication
       * _Example:_ prompt for & verify a password
       * if there is an error ->
         * throws an error
         * ❌NO retry the authentication ❌
         * ❌NO introduce delays ❌
     * saves its authentication status (`boolean`) -- as -- private state information
     * return authentication status
  * TODO:
* `boolean commit()`
  * checks `LoginModule`'s privately saved state
  * if `LoginModule`'s own authentication succeeded -> associates the relevant Principals (authenticated identities) & Credentials (authentication data) -- with the -- `Subject` | `LoginModule`
  * TODO:
* `boolean abort()`
  * removes/destroys ANY save authentication state
  * TODO:
* `boolean logout()`
  * done | 1! phase
  * -- invoked by the -- `LoginContext`
  * == remove Principals or Credentials |
    * `Subject` or
    * logging session information 
  * TODO:
* implementations' requirements
  * ALL methods
  * constructor / NO arguments
  