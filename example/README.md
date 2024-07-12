# Examples
* Examples / follow the same tree structure that the "src" 

## How to run locally?
* From each specific path 
  * `javac fileName.java`
  * `java fileName`
    * Problems: 
      * Problem1: "java.lang.ClassNotFoundException: example.java.base.sharees.java.net.Example"
        * Attempt1: `java src.example.java.base.sharees.java.net.Example`
        * Attempt2: `java -cp src example.java.base.sharees.java.net.Example`
        * Solution: ⭐Move outside /src ⭐

## How to debug locally?
* Mark "example" as source root directory
* Select as projectBuild with jdk 17
* via
  * IDE
    * right click in "main()"
  * command
    * TODO: