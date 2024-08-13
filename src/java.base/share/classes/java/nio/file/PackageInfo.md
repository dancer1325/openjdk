* == interfaces + classes / 
  * VM -- can access to --
    * files
    * file attributes -- "java.nio.file.attribute" --
    * file systems
  * "java.nio.file.spi"
    * use
      * extend platform default provider
      * construct other provider implementations
    * audience
      * service provider implementors
* symbolic link
  * := special file / -- is reference to -- another file
    * mostly, it's transparent to –– applications
    * operations | symbolic links -- are automatically redirected to the -- target of the link 
      * exception:
        * deletion of symbolic links
        * rename
        * move
  * supported by many
    * OS
    * file systems
  * requirements
    * implementations -- provide -- semantics
* interoperability
  * TODO:
* visibility
  * TODO:
* TODO: