* == TLAB
* := descriptor -- for -- thread-local storage
  * 👀descriptor == data structure == resource 👀
  * thread-private | ANY time
    * == ONLY accessible -- by -- 1! thread | ANY time
  * it -- can be -- multiplexed overtime | ACROSS multiple threads
    * == 1! TLAB -- can be associated to -- MULTIPLE threads | ALONG the time
* uses
  * by the threads -- for -- allocation
* TODO:
  