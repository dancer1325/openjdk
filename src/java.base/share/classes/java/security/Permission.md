* := abstract class -- for representing, 👀 access to a -- system resource 👀
* `String name`
  * 's interpretation -- depends on the -- subclass
    * _Example:_ `FilePermission.name` == pathname of a file (or directory)
* `abstract boolean implies(Permission permission)` & `abstract boolean equals(Object obj);` & `abstract int hashCode();`
  * ALL are abstract
    * Reason: 🧠be defined -- by the -- subclass 🧠
  * ⚠️MANDATORY to implement ⚠️
  * `abstract boolean implies(Permission permission)`
    * allows
      * comparing Permissions 
        * _Example:_ "permission p1 implies permission p2" == if one is granted permission p1 -> one is naturally granted permission p2
    * TODO:
* `String actions`
  * == actions / -- allowed by the -- object
    * -> 's interpretation -- depends on the -- subclass
      * _Example:_ `FilePermission.actions` == actions list ("read, write, ...") / granted | specified file OR directory's files
  * OPTIONAL
    * _Example:_ `RuntimePermission` NOT have
* vs `String` objects
  * BOTH are immutable
    * -> ONCE permission has been created -> subclasses should NOT have methods / change the state
* TODO: