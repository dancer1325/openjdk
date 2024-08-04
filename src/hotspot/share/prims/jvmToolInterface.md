# JVM Tool Interface
* Information hosted in internet by Oracle -- https://docs.oracle.com/en/java/javase/XY/docs/specs/jvmti.html
  * [Java SE 22](https://docs.oracle.com/en/java/javase/22/docs/specs/jvmti.html)
* := programming interface /
  * uses
    * development & debugging tools
    * monitoring tools
    * profiling tools
    * thread analysis tools
    * coverage analysis tools
  * allows
    * about applications / running | JVM
      * inspecting the state
      * controlling the execution
  * 👁️ optional | JVM 👁️
    * == NOT available | ALL JVM implementations
  * == 2-way interface
    * client of JVM TI or agent (naming)
      * relative compact
      * 👁️it's notified of interesting occurrences -- via -- events 👁️
      * 's process == JVM's process / run the application
      * -- communicate directly, via JVM TI, with -- JVM / run the application
    * functions
      * way to control or query the applications
* ways to write to tools
  * JVM TI 
  * higher level interfaces
    * _Example:_ Java Platform Debugger Architecture
    * more appropriate | most of the tools
* TODO: