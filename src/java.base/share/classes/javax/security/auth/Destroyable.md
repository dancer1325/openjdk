* use cases
  * 💡credentials / can destroy its contents💡
* `default void destroy() throws DestroyFailedException {}`
  * this Object
    * ⚠️is destroyed ⚠️
      * ⚠️!=  reference == `null` ⚠️
    * 's sensitive information is destroyed or cleared
  * if afterward, you try to `thisObject.method()` -> throws `IllegalStateException`
  * `{throw new DestroyFailedException();}`
    * 👀default implementation 👀
  * if `destroy` fails -> throws `DestroyFailedException` 
  * if the caller does NOT have permission -> throws `SecurityException`
* TODO: