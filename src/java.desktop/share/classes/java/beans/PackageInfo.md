* == classes / beans-related
  * == JavaBeans architecture
  * uses
    * by beans | running the application
      * _Example:_ event classes
    * by bean editor
      * == development environment / put beans together -- to create an -- application
      * _Example:_ `PropertyEditor`
      * 👁️classes / used by bean editors -- are -- loaded | ONLY when the bean is being edited 👁️
        * Reason: 🧠 minimize the resources / used by a bean 🧠
* `null` & empty `String` are NOT valid method's parameters | this package
  * unless it's explicitly stated
  * if you use it -> exceptions are thrown
* TODO: