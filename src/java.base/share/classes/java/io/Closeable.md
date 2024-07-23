* := interface / 
  * uses
    * source (-- _Example:_ open files --) OR destination of data / can be closed
      * once you invoke `.close()` -> held objects are released  
* `close()`
  * allows
    * closing the stream
    * release any system resources / -- associated with -- it
  * if the stream is ALREADY closed -> NO effect
  * if it fails -> recommendation
    * relinquish underlying resources
    * mark as closed
    * NOT throw an IOException