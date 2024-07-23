* := functional interface /
  * `call()`
* == task / 
  * return a result &
  * -- may thrown an -- exception
* vs `Runnable`
  * both -- are designed for -- classes / their instances -- are 👁️potentially executed by -- another thread 👁️
  * `Runnable`
    * does NOT return a result
    * can NOT throw a checked exception
* `Executors` have got methods / other forms -- convert to -- `Callable`