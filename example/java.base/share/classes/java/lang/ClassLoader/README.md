# Goals
* ClassLoader
  * -- is responsible for -- loading classes 
  * if you implement it -- extends --> manner / JVM dinamically loads classes -- TODO:How to check it? 

## How to run locally?
* Place the cursor | this path
  * `javac -d . ExampleClass.java`
    * Check that it's generated "share/classes/java/lang/ClassLoader/ExampleClass.class"
* Place the cursor at package declaration
  * `javac share/classes/java/lang/ClassLoader/CustomClassLoader.java share/classes/java/lang/ClassLoader/Main.java` 
  * `java share.classes.java.lang.ClassLoader.Main`
    * Problems:
      * Problem1: "Class not found: share.classes.java.lang.ClassLoader"
        * Solution: TODO:
  
