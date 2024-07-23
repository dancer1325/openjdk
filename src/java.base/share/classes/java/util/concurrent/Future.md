* == 👁️ result of async computation 👁️
  * `get()`
    * once the computation is completed -> retrieve the result
      * ⚠️block, till it's ready ⚠️
  * `isDone()`
    * return boolean / -- indicates if -- task is completed (check previous cases / consider task as completed)
  * `cancel(boolean)`
    * try to cancel the execution of the task
      * if the task is ALREADY completed -> NO effect
    * TODO:
  * `isCancelled()`
    * return boolean / -- indicates if -- task was cancelled
* 👁️ possible cases of task completion 👁️
  * normal termination
  * exception
  * cancellation