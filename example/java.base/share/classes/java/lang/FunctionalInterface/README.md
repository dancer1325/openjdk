# Goals
* Prove that if a interface fulfil the functional interface requirements -> NOT necessary to annotate with `@FunctionalInterface`

## How to run locally?
* `javac Main.java`
  * Problems:
    * Problem1: "cannot find symbol Calculator"
      * Attempt1: Try to add some `import` statement
      * Attempt2: `javac Main.java Calculator.java` & `java Main.class Caculator.class` OR `java Main.class`
      * Attempt3: Create the structure "src.main", `javac main/Calculator.java main/Main.java` & `java main.Main`
      * Solution: ⭐ if the package is named "share.classes.java.lang.FunctionalInterface" -> you need to go to the roo of here, and run `javac share/classes/java/lang/FunctionalInterface/Main.java` & `java share.classes.java.lang.FunctionalInterface.Main` ⭐  
* `java Main.class`
