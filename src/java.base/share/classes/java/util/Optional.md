* TODO:
* `void ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction)`
  * if `value` is present 
    * -> perform `action`, else `emptyAction`
    * & `action=null` OR `value=null` & `emptyAction=null` -> `NullPointerException` is thrown
* TODO:
* `T orElse(T other)`
  * if `value` is present -> returns `value`, else -> returns `other`