# Goals
* input bytes -- come from a -- file | file system
* if you want to release resources / used by the stream -- TODO:
* `FileInputStream(Something)` -- opens a -- connection to a file

## How to run locally?
* Place the cursor at package declaration
* via commands
  * `javac share/classes/java/io/FileInputStream/Main.java` 
  * `java share/classes/java/io/FileInputStream/Main`
  * `java -agentlib:jdwp=transport=dt_socket,address=127.0.0.1:62066,suspend=y,server=n -classpath /Users/ADP0253/Documents/Projects/openjdk/example/production/openjdk share/classes/java/io/FileInputStream/Main`
    * run in debug mode
    * Problems: "ERROR: transport error 202: connect failed: Connection refused"
      * Attempt1: `java -agentlib:jdwp=transport=dt_socket,address=127.0.0.1:62066,suspend=y,server=n share/classes/java/io/FileInputStream/Main`
      * Note: TODO: How to debug native methods?
      * Solution: TODO:
* via IDE
  * Problems:
    * Problem1: "file NOT found"
      * Solution: TODO: