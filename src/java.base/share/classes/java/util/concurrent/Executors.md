* == factory & utility methods
  * for
    * `Executor`
    * `ExecutorService`
    * `ScheduledExecutorService`
    * `ThreadFactory`
    * `Callable`
* `newSingleThreadExecutor()`
  * allows
    * creating an `Executor` / use 1! worker thread | unbounded queue (?)
      * 👁️ if this single thread terminates due to failure / prior to shutdown -> NEW one is created 👁️
      * tasks are executed SEQUENTIALLY
        * == 1! active task / given time
* TODO: