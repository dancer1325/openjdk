# The javac Command
* Information hosted in internet by Oracle -- https://docs.oracle.com/en/java/javase/XY/docs/specs/man/javac.html --
  * [Java SE 22](https://docs.oracle.com/en/java/javase/22/docs/specs/man/javac.html)
* allows
  * Java declarations -- are compiled to -- ".class"
* `javac [options] [sourcefiles-or-classnames]`
  * `[options]`
    * == CL options
    * == standard options + extra options
      * standard options
        * TODO:
        * `-Joption`
          * Java options / described | `java ...`  -- are passed to the -- runtime system
            * _Example:_ `-J-Xms48m`
            * NOT recommended to configure `-classpath`, `-bootclasspath`, `-extdirs`
        * TODO: 
      * extra options
        * TODO:
  * `[sourcefiles-or-classnames]`
    * `sourcefiles` -- _Example:_ "Shape.java" --
    * `classnames`
      * := classes / previously compiled, -- for being -- processed by annotations -- _Example:_ `geometry.MyShape` --
* TODO:
* 
