* := implementation of `RunnableFuture` 
  * == `Runnable` + `Future`
    * ->
      * as soon as the computation is complete, blocking the methods, -> result can be retrieved
  * -> -- can be executed by -- `Executor`
    * Reason: 🧠 implements `Runnable` 🧠
* == 👁️cancellable asynchronous computation 👁️
  * `runAndReset`
    * once the computation is completed -> computation can be 
      * restarted or
      * cancelled
* uses
  * wrap a 
    * `Callable`
    * `Runnable`
  * standalone class or extensible custom one