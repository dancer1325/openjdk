# The jar Command
* Information hosted in internet by Oracle -- https://docs.oracle.com/en/java/javase/XY/docs/specs/man/jar.html
  * [Java SE 22](https://docs.oracle.com/en/java/javase/22/docs/specs/man/jar.html)
* ".jar"
  * := file format / 
    * == ".zip" + optional /META-INF
      * -- based on -- ".zip"
    * uses
      * \>1 files -- are aggregated into -- 1!
    * 👁️NO restriction for naming 👁️
  * ways to create it
    * `jar ...` 
      * CLI
    * "java.util.jar" API | Java platform
* modular ".jar"
  * == ".jar" / contains "module-info.class" | root directory
  * explicit module := modular ".jar" / deployed | module path (!= class path)
* non-modular ".jar"
  * automatic module := non-modular ".jar" /  deployed | module path (!= class path)
  * naming
    * -- derived from -- ".jar" / specified in `ModuleFinder.of(Path)`
    * if ".jar" has an attribute `Automatic-Module-Name` -> module name == `Automatic-Module-Name` 's value 
* multi-release ".jar"
  * TODO:
