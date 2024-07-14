* thread-local variables vs thread variables
    * thread-local variables -- depend on the -- thread / access to it
      * == different copy of the variable / thread accessing to it
* `ThreadLocal` instances
  * 's fields
    * (typically) private and static
  * goal
    * ⭐ associate variable -- with -- 1! thread ⭐
  * -- related with a -- `Thread`
    * ⚠️as long as the thread is alive -> holds an implicit reference to its copy of ThreadLocal variable ⚠️
    * ⚠️ if thread goes away -> ALL it's copies of ThreadLocal instances subject to garbage collection ⚠️  
* `ThreadLocal<T>`
  * := class / admits a generic
* TODO: