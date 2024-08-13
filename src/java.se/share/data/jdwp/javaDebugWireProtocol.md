# Java Debug Wire Protocol (JDWP)
* Information hosted in internet by Oracle -- https://docs.oracle.com/en/java/javase/XY/docs/specs/jdwp/jdwp-spec.html
  * [Java SE 22](https://docs.oracle.com/en/java/javase/22/docs/specs/jdwp/jdwp-spec.html)
* uses
  * debugger -- can communicate with -- JVM / is debugged
    * JVM -- also called -- target VM
* ⚠️optional ⚠️
  * == might NOT be available | some JDK implementations
  * if it exists -> debugger can work |
    * same computer / != process
    * remote computer
* 👁️vs other protocol specifications 👁️
  * ONLY detailed
    * format
    * layout
  * NOT transport specified
* JDWP implementation can be designed -- via simple API, to accept -- several transport mechanisms
* layer | JPDA
  * allows
    * JDI is used efficiently
* 