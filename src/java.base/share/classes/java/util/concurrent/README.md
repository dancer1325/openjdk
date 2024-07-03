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
  * TODO:
## Implementations

# Queues

# Timing
* TODO:
