* `BasicPermission`
  * `abstract class`
    * 👀-> if you want to instantiate -> you need to use a concrete implementation 👀
  * 's name == name of the given permission
    * convention == hierarchical property naming convention
      * `*`
        * uses
          * by itself, OR
            * _Example:_ "*"
          * | end of the name, ".*"
            * _Example:_ "java.*"
  * `String actions`
    * -- inherited from -- `Permission`
    * ⚠️unused ⚠️
      * if you want -> subclasses -- may implement -- `actions` | on top of
  * uses
    * base class -- for -- permissions / 's naming convention == `BasicPermission`'s naming convention
      * == NO `actions`
      * Reason: 🧠`actions` is unused 🧠
  * TODO:
* `BasicPermissionCollection`
  * TODO: