* := object / 
  * -- responsible for -- loading classes -- based on a -- binaryName
    * how does it work?
      * locate resource / fileName == binaryName
        * resource
          * can be 
            * .class
            * configuration data
            * image
            * ...
          * -- typically packaged with -- application OR library
        * location -- is based on -- 👁️ delegation model 👁️
          * parent ClassLoader / ClassLoader instance
          * steps
            * parent ClassLoader -- tries to find the -- resource
            * if NOT found by the parent -> own ClassLoader instance -- tries to -- find it
          * if delegation model is NOT strictly hierarchical -> ClassLoader need to be parallel capable
            * Reason: 🧠 if NOT parallel -> loader process locks other loader processes 🧠
      * generate data 
  * == abstract clas
    * if you implement it -- extends --> manner / JVM dinamically loads classes 
  * uses
    * indicate security domains -- by -- security managers
* parallel capable ClassLoader
  * := ClassLoader / -- support -- concurrent loading of classes
    * -> `registerAsParallelCapable` | class initialization time
      * == required to register themselves
  * "java.lang.ClassLoader" is registered as parallel, by default
  * `isRegisteredAsParallelCapable()`
    * check if they are
* Java run-time, built-in
  * Bootstrap class loader
    * TODO:
  * Platform class loader
    * TODO:
  * System class loader
    * TODO:
* TODO: