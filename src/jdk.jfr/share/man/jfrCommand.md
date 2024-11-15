# The jfr Command
* Information hosted in internet by Oracle -- https://docs.oracle.com/en/java/javase/XY/docs/specs/man/jfr.html
  * [Java SE 22](https://docs.oracle.com/en/java/javase/22/docs/specs/man/jfr.html)
* allows
  * about Flight Recorder files (.jfr)
    * filter
    * print | human-readable format 
    * manipulate
* Flight Recorder files (.jfr)
  * created and saved -- as -- binary formatted files
  * uses
    * debug performance issues
* commands
  * `jfr print [options] fileJFRToSpecify`
    * print the contents of a flight recording | standard out:
  * `jfr view [options] fileJFRToSpecify`
    * display aggregated event data | standard out
  * `jfr configure [options]`
    * configure a .jfc settings file
  * `jfr metadata [fileJFRToSpecify]`
    * print metadata information about flight recording events
  * `jfr summary fileJFRToSpecify`
    * view the summary statistics -- for a -- flight recording file
  * `jfr scrub [options] fileJFRToSpecify`
    * remove events -- from a -- flight recording file
  * `jfr assemble repositoryOfTheChunkFiles fileJFRToSpecify`
    * assemble chunk files | flight recording file
  * `jfr disassmble [options] fileJFRToSpecify`
    * disassemble a flight recording file | chunk files
  * notes
    * `[options]`
      * == optional CL options / -- separated by -- spaces
      * See the individual subcomponent sections for descriptions of the available options.
  * subcommands
    * TODO: