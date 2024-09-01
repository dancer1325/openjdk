* == `ExecutorService` -- for running -- `ForkJoinTask`s
  * vs other `ExecutorService`s
    * ⭐ use work-stealing ⭐
      * == ALL pool's threads try to find & execute tasks | pool
      * -> efficient processing
* uses
  * entry point for submit non-ForkJoinTask clients
  * about operations
    * management
    * monitoring
  * if `constructor.asyncMode=true` -> event-style tasks / NEVER joined
* if `Thread.isDaemon=true` -> ALL worker threads are initialized
* TODO