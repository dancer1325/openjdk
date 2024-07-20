# Goals
* Check that `InputStream` is a superclass of input stream of bytes

## How to run locally?
* Place the cursor at package declaration
* `javac share/classes/java/io/InputStream/Main.java` 
* `java share/classes/java/io/InputStream/Main`
  * Problems:
    * Problem1: "java.io.FileNotFoundException: example.txt"
      * Solution: Use relativePath of launching the command for the text "share/classes/java/io/InputStream/example.txt"
