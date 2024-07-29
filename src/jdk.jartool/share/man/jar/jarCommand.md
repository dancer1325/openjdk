# The jar Command
* Information hosted in internet by Oracle -- https://docs.oracle.com/en/java/javase/XY/docs/specs/man/jar.html
  * [Java SE 22](https://docs.oracle.com/en/java/javase/22/docs/specs/man/jar.html)
* allows
  * from an archive -- to manipulate and restore -- individual classes OR resources
  * creating an archive -- for -- classes and resources 
* `jar [OPTION ...] [ [--release VERSION] [-C dir] files] ...`
  * == `tar` syntax
  * `[OPTION ...]`
    * == operation modes + modify the operation + perform the operation
      * operation modes
        * `-c` / `--create`
          * create ".jar"
        * TODO:
      * modify the operation
        * `-f FILE` or `--file=FILE`
          * specify the archive file name
        * `-C DIR`
          * specify the directory to generate the .jar
        * TODO:
        * / ONLY valid in Create, Update modes
          * `-m FILE or --manifest=FILE`
            * from given manifest -- include the -- manifest information
        * / ONLY valid in Create, Update, Generate-index modes
          * `--date=TIMESTAMP`
            * timestamp ISO-8601 | timestamps entries
* := tool
  * general-purpose
    * archiving
      * / -- enable individual entries to -- sign it
    * compression
      * -> improve download time
  * -- based on the -- compression formats
    * .zip
    * .zlib
  * / JDK version
    * \< v11 -- package Java applets --
    * \>= v11 -- create modular .jar --
* TODO:
