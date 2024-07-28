# The javap Command
* Information hosted in internet by Oracle -- https://docs.oracle.com/en/java/javase/XY/docs/specs/man/javap.html --
  * [Java SE 22](https://docs.oracle.com/en/java/javase/22/docs/specs/man/javap.html)
* allows
  * disassembling `.class`
* `javap [options] class1 class2 ...`
  * syntax
  * classX
    * found | class path / look up by
      * file name -- _Example:_ path/to/MyClass.class --
      * URL -- _Example:_ jar:file:///path/to/MyJar.jar!/mypkg/MyClass.class -- 
      * fully qualified className -- _Example:_ java.lang.Object --
  * output
    * -- depends on -- `[options]`
      * if NO `options` passed -> prints | `stdout` the 
        * `.class` 's fields 
          * protected & 
          * public
        * `.class` 's methods 
  * NOT multirelease JAR aware
    * TODO: