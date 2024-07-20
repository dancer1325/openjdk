* := interface /
  * allows
    * holding resources (_Example:_ file OR socket) / till it's closed
  * `close()`
    * := method /
      * if the object `Autocloseable` is defined in the header of `try-with-resources` block & exiting of this block -> 👁️ this method is called automatically 👁️
        * -> allows
          * prompt release
          * avoiding resource exhaustion exceptions (?)
    * TODO:
  * uses
    * base class

* `try-with-resource`
  * uses
    * code / must operate in complete
    * resource release is required
  * NOT to use
    * 'java.util.strea.Stream' & non-I/O- based forms