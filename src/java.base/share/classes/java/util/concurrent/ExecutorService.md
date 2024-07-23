* == `Executor` /
  * == methods allow
    * managing termination
      * if it's shutdown -> tasks will be rejected
        * `shutdown()`
          * 👁️ tasks submitted previously -- are executed -- before terminating 👁️
        * `shutdownNow()`
          * 👁️ tasks submitted previously -- are NOT waiting for executed -- before terminating 👁️
    * produce `Future`
* `submit()`
  * create a `Future` / 
    * uses
      * cancel execution
      * wait for completion
* `Future<T> submit(Callable<T>)`
  * `Callable<T>` is a task value-returning
  * `Future<T>` == pending results of the task
  * TODO:
* TODO: