* == reference dynamic strongly typed to
  * variable or
  * family of variables, parametrically-defined, as
    * static fields
    * non-static fields
    * array elements
    * components of an off-heap data structure
* access modes == ways to access the variables
  * plain read/write access
  * volatile read/write access
  * compare-and-set
* `Class<?> varType(){}`
  * return variable or variables type / -- referenced by -- this variable
* `List<Class<?>> coordinateTypes() {}`
  * returns the coordinate types -- for -- this `VarHandle`
    * empty may be possible
    * variable and coordinate types
      * -- may be -- primitive or reference
      * -- are represented by -- `Class` objects
* TODO: