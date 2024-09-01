* := abstract class -- for -- tasks / run | `ForkJoinPool`
* == thread-like entity /
  * 's weight << thread weight
    * -> 👁️ MANY tasks & subtasks -- could be hosted by -- SMALL number of threads 👁️
    * == lightweight `Future`
* ways to launch the execution of `ForkJoinTask`
  * -- submitting to a -- `ForkJoinPool`
  * start the `ForkJoinTask` | `ForkJoinPool.commonPool()` -- via --  `.fork`, `.invoke`, or others
* if you start `ForkJoinTask` -> others subtasks are started
* main methods
  * `fork`
    * async execution
  * `join`
    * wait for task's result
* uses
  * computational tasks about 
    * pure functions
    * isolated objects
* recommendations
  * computation -- should avoid -- sync methods or blocks
  * subdividable tasks -- should 
    * NOT perform -- blocking I/O
    * access -- variables / runningTask-specific
* TODO: