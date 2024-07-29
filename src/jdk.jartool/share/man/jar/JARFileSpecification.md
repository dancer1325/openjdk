# ".jar" specification
* Information hosted in internet by Oracle -- https://docs.oracle.com/en/java/javase/XY/docs/specs/jar/jar.html
  * [Java SE 22](https://docs.oracle.com/en/java/javase/22/docs/specs/jar/jar.html)
* ".jar"
  * := file format / 
    * == ".zip" + optional /META-INF
      * -- based on -- ".zip"
    * uses
      * \>1 files -- are aggregated into -- 1!
      * class path entry
    * 👁️NO restriction for naming 👁️
  * ways to create it
    * `jar ...` 
      * CLI
    * "java.util.jar" API | Java platform
* modular ".jar"
  * == ".jar" / contains "module-info.class" | root directory
  * explicit module := modular ".jar" / deployed | module path (!= class path)
  * uses
    * transportation
    * deployment
* non-modular ".jar"
  * automatic module := non-modular ".jar" /  deployed | module path (!= class path)
  * naming
    * -- derived from -- ".jar" / specified in `ModuleFinder.of(Path)`
    * if ".jar" has an attribute `Automatic-Module-Name` -> module name == `Automatic-Module-Name` 's value 
* multi-release ".jar"
  * := ".jar" / JAR manifest has got the attribute `Multi-Release: true`
  * allows
    * supporting multiple Java X (major) versions / 1! .jar 
      * -> ".class" -- depend on -- different API versions
      * == decouple of API version
  * _Example:_ multi-release JAR / -- depends on -- Java 8 & 9
  * if ".class" & resources files -- depend on -- Java 9+ -> they could be located | "META-INF/versions/N"
    * N := Java major version / used
    * rather than | root
  * if ".class" | "META-INF/versions/N" & multi-release jar -> ".class"'s version <= ".class" of Java platform Nth
  * TODO: From "If the class of the class file is public or"
  * modular multi-release ".jar"
    * TODO:
* "META-INF/"
  * files & directories / recognized and interpreted by the Java platform
    * uses
      * configure
        * applications
        * class loaders
        * services
    * MANIFEST.MF
      * use
        * -- define -- package related data
    * x.SF
      * x == base file name
      * := ".jar"'s signature
    * x.DSA, x.RSA, or x.EC
      * := signature block file / -- associated with the -- signature file / == base file name (TODO:?)
      * uses
        * stores the digital signature / PKCS #7 structure (TODO:?)
    * services/
      * uses
        * store ALL
          * service provider configuration ".jar" / deployed | classpath
            * Check `ServiceLoader.java`
          * ".jar" / -- deployed as -- automatic modules | module path
    * versions/
      * == versioned ".class" + resource files / multi-release ".jar"
* TODO:
* ".jar" manifest
  * := main-section + other sections -- Check [syntax](https://docs.oracle.com/en/java/javase/22/docs/specs/jar/jar.html#manifest-specification) --
  * TODO:
* Signed ".jar"
* TODO:
