# Goal
* Comprehend `jar ..`

## How to run locally?
* `javac Foo.java Bar.java`
  * creates ".class"
* `jar --create --file classes.jar Foo.class Bar.class`
  * create "classes.jar" -- based on -- 2 ".class"
* `jar --create --date="2021-01-06T14:36:00+02:00" --file=classes2.jar Foo.class Bar.class`
  * set last modified date and time
* `jar --create --file classes3.jar --manifest MANIFEST.MF -C foo/`
  * Problems:
    * Problem1: "Error al analizar los argumentos de archivo"
      * Solution: TODO:
* TODO: