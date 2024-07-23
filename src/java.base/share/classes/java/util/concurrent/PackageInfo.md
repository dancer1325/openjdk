* Notes from 'package-info.java'

* == utility classes /
  * use
    * concurrent programming
  * == frameworksStandardizedAndExtensible + classesWithUsefulFunctionality + classesTediousToImplement
    * subpackages
      * java.util.locks
      * java.util.concurrent.atomic

# Executors
## Interfaces
* 'java.util.concurrent.Executor'
  * := interface /
    * characteristics
      * simple
      * standardized
    * allows
      * defining custom thread-like subsystems
        * _Example:_
          * thread pools
          * asynchronous I/O
          * lightweight task frameworks
  * 👁️ based on concrete Executor class used -> tasks may execute 👁️
    * in
      * newly created thread
      * existing task-execution thread
      * thread / calling
    * type
      * sequentially
      * concurrently
* 'java.util.concurrent.ExecutorService'
  * := interface /
    * vs '...Executor'
      * async task execution: more complete
    * allows
      * about tasks
        * queuing
        * scheduling
      * controlling shutdown
  * subinterfaces
    * 'java.util.concurrent.ScheduledExecutorService'
      * := subinterface /
        * allows
          * about tasks
            * delay execution
            * periodic execution
* 'java.util.concurrent.Future'
  * := interface /
    * allows
      * determining if an execution was completed
        * -- returns the result
      * cancelling an execution
  * 'java.util.concurrent.RunnableFuture'
    * := Future /
      * characteristics
        * there is a method / set results | it's execution

## Implementations
* TODO:

# Queues

# Timing
* TODO:


# Memory Consistency Properties
* TODO:

