* Service
  * := interface OR class / exist 0 or >=1 service providers
* Service provider
  * := class / implements the service
* ServiceLoader
  * := object / 
    * locate the service providers
    * load (when the application requires) service providers | run environment
    * created / service
  * `ServiceLoader.load()`
    * create a ServiceLoader
  * if the application is a module -> module declaration must have `uses` directive / specify the service
  * TODO: From "In addition, if the application"