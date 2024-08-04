# The jdb Command
* Information hosted in internet by Oracle -- https://docs.oracle.com/en/java/javase/XY/docs/specs/man/jdb.html
  * [Java SE 22](https://docs.oracle.com/en/java/javase/22/docs/specs/man/jdb.html)
* allows
  * finding & fixing bugs | Java platform (local or remote)
* `jdb [options] [classnameMainToDebug] [arguments]`
  * `[options] `
    * TODO:
  * `[arguments]`
    * == arguments / -- passed to -- `main()`
* JDB == Java DeBugger
* ways to start a JDB session
  * `jdb ...`
    * how does it work?
      * call to a 2@ JVM / specified parameters
      * loads the main class
      * stop JVM / before executing class's first instruction (?)
  * launch a JVM +      attach `jdb` | existing JVM
    * launch a JVM
      * `java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n MyClass`
    * attach `jdb` | existing JVM
      * `jdb -attach 8000`
        * 8000  ==  address of running JVM
* TODO:
* breakpoints
  * TODO:
  * set a breakpoint
    * `stop at className:numberLine`
    * `stop in className.part`
  * `clear`
    * remove the breakpoints
* `step`
  * advances execution -- to the -- next line
* TODO: