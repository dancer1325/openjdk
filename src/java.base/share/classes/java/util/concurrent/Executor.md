* := object /
  * execute submitted `Runnable` tasks
    * == 👁️ task submission -- is decoupled from -- mechanism to run the task, thread use, scheduling, .. 👁️
    * ⚠️ NOT require that execution is async ⚠️
    * if there are actions | thread / -- prior to -- submitting the task -> task execution's thread != (can be) previous actions's thread
      * Check '../PackageInfo/MemoryVisibility'
  * uses
    * alternative to create threads
  * use cases
    * submitted task -- run it -- IMMEDIATELY | caller's thread
    * submitted task -- run it -- | thread / != caller's thread 
      * == new thread / task to be executed
    * limitations on how & when tasks are scheduled