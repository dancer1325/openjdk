* allows
  * reading the `Configuration`
  * 💡instantiating the appropriate `LoginModule` 💡
  * authenticating Subjects
    * recommendations
      * 👀1 `LoginContext` / `Subject` 👀
* provides
  * way to develop an application / -- independent of the -- underlying authentication technology
* `Configuration config`
  * == authentication technology or `LoginModule` / used | particular application
* support
  * <i>pluggable</i> authentication
  * <i>stacked</i> authentication
* 💡typical caller -- instantiates a -- `LoginContext` 💡/ 
  * has
    * <i>name</i>
      * uses
        * index | Configuration / determine the `LoginModules`
          * to use
          * which ones must succeed -- in order for the -- overall authentication to succeed 
    * `CallbackHandler`
      * passed | underlying `LoginModules` -> they -- may communicate and interact with -- users 
        * _Example:_ prompting for a username and password -- via a -- graphical user interface
  * -> invokes the `.login()`
    * if succeed -> caller -- can, via `getSubject()`, retrieve the -- newly authenticated `Subject`
    * if caller wants to logout -> invoke `logout()` 
* `public void login() {}`
  * authenticate a `Subject`
  * 👀invokes `.login()` / EACH `LoginModule` / configured | `new LoginContext(..., name, ...)` 👀
    * EACH module -- perform -- their respective type of authentication (username/password, smart card pin verification, etc.)
    * if MULTIPLE LoginModules fail -> exception is propagated -- through -- EACH `LoginModule`
      * Reason: 🧠proper cleanup & state restoration 🧠
  * ❌if the authentication fails -> NO attempt authentication retries nor introduce delays ❌ 
  * if returns / NO throw an exception -> overall authentication succeeded
* constructors
  * TODO:
* TODO: