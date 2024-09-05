* == classes / support functional-style operations | streams of elements
  * _Example:_ map-reduce transformations | collections
* stream
  * ⭐key abstraction ⭐
  * uses
    * elements from a source (Example: data structure, array, generator function, I/O channel) -- are conveyed through a -- pipeline of computational operations
  * classes-related
    * "java.util.stream.Stream"
      * := class / streams | objects
    * "java.util.stream.IntStream"
      * := class / streams | int
    * "java.util.stream.LongStream"
      * := class / streams | long
    * "java.util.stream.DoubleStream"
      * := class / streams | double
  * types of stream operations
    * intermediate
    * terminal
  * vs Collections
    * NO storage
      * == 👁️stream is NOT a data structure / store elements 👁️
    * functional-related 
      * operation on a stream -> produces a result / ⚠️ source NOT modified ⚠️
    * laziness-seeking
      * most stream operations -- can be implemented -- lazily
      * 👁️ ALL intermediate stream operations are lazy 👁️
    * possibly (NOT needed) unbounded (== undefined size)
      * 👁️ collections have finite size 👁️
      * != there are short-circuiting operations
        * _Example:_ `limit(n)` or `findFirst()`
    * consumable
      * == stream's elements -- are visited -- 1! | life of the stream
        * Reason: 🧠 once they are consumed (== terminal operations applied) -> NOT can be consumed /or read again  🧠
        * if you want to revisit the elements -> generate a new stream
  * ways to obtain
    * `java.util.Collection`
      * `.stream()`
      * `.parallelStream()`
    * `java.util.Arrays.stream(Object[])`
    * static factory methods | stream classes
      * `java.util.stream.Stream.of(Object[])`
      * `java.util.stream.IntStream.range(int, int)`
      * `java.util.stream.Stream.iterate(Object, UnaryOperator)`
    * `BufferedReader.lines()`
      * == lines of a file
    * `java.nio.file.Files`
    * `java.util.Random.ints()`
    * stream-bearing methods in the JDK
      * == methods / return streams
      * `java.util.BitSet.stream()`
      * `java.util.regex.Pattern.splitAsStream(java.lang.CharSequence)`
      * `java.util.jar.JarFile.stream()`
  * TODO: