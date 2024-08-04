* extends `InputStream`
* input bytes -- come from a -- file | file system
  * available files -- depend on the -- host environment
  * _Example:_ image data
* if you want to read streams of characters -> use `FileReader`
* if you want to release resources / used by the stream -> 
  * `close()` or
  * `try-with-resources`
* `FileInputStream(String)`
  * open a connection to a –– file / named `String`
    * -> `FileDescriptor` is created
    * if named file does NOT exist OR is a directory OR any reason / can NOT be opened -> throw `FileNotFoundException`  
  * TODO:
* `FileInputStream(File)`
  * Check `FileInputStream(String)`
* TODO: