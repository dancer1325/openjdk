# Goal
* comprehend `javap`

## How to run locally?
* Place the cursor at package declaration
* `javac javap/Main.java` 
  * check `.class` is generated
* `java javap/Main`
  * Open immediately a browser window with the JFrame
* `javap javap.Main`
  * print it's output by `stdout`
* `javap -c javap.Main`
  * disassemble the code & print it