* == tools / analyze dependencies | Java libraries & programs
  * `ToolProvider`
    * ways to create instances
      * `ToolProvider.findFirst`
      * `ServiceLoader("javap")` or `ServiceLoader("jdeps")` or `ServiceLoader("jdeprscan")`  
  * alternative, via CLI
    * `jdeps`
    * `javap`
    * `jdeprscan`