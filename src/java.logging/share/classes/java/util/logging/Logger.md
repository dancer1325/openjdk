* := main entity / 
  * uses
    * log messages | specific system OR application component
    * 👁️forward -- logging messages to -- registered `Handler` objects 👁️
  * hierarchy of loggers -- based on -- naming
  * `Level` -- associated with -- it
* naming
  * arbitrary String / 
    * recommended practices
      * `.` -- as -- hierarchical namespace separation
      * -- based on -- className or packageName
        * _Example:_ "java.net" or "javax.swing" 
* factory methods
  * `getLogger()`
    * create or return an existing one
    * if a strong reference to the Logger is NOT kept -> 👁️may be garbage collected 👁️
* TODO: From "The log level can be configured based on the"