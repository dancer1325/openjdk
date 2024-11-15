# The java Command
* Information hosted in internet by Oracle -- https://docs.oracle.com/en/java/javase/XY/docs/specs/man/java.html
  * [Java SE 22](https://docs.oracle.com/en/java/javase/22/docs/specs/man/java.html)
* allows
  * launching a Java application
* `java [options] mainclass [args ...]`
  * uses
    * main class is ".class"
* `java [options] -jar jarfile [args ...]`
  * uses
    * main class is ".jar"
* `java [options] -m module[/mainclass] [args ...]` or `java [options] --module module[/mainclass] [args ...]`
  * uses
    * main class is ".module"
* `java [options] source-file [args ...]`
  * uses
    * source-file program (TODO: ?)
* TODO:
* `[options]`
  * == standard + extra
    * standard
      * 👁️supported by ALL JVM implementations 👁️
      * TODO:
    * extra
      * TODO:
  * TODO:
  * advanced Runtime Options
    * TODO:
    * `-XX:StartFlightRecording=parameter=value`
      * ⭐️starts a JFR recording | Java application⭐
      * == `JFR.start` / starts a recording | runtime
      * available `parameter=value`
        * `delay=time`
          * TODO:Specifies the delay between the Java application launch time and the start of the recording. Append s to specify the time in seconds, m for minutes, h for hours, or d for days (for example, specifying 10m means 10 minutes). By default, there's no delay, and this parameter is set to 0.
        * `disk={true|false}`
          * Specifies whether to write data to disk while recording. By default, this parameter is enabled.
        * `dumponexit={true|false}`
          * Specifies if the running recording is dumped when the JVM shuts down. If enabled and a filename is not entered, the recording is written to a file in the directory where the process was started. The file name is a system-generated name that contains the process ID, recording ID, and current timestamp, similar to hotspot-pid-47496-id-1-2018_01_25_19_10_41.jfr. By default, this parameter is disabled.
        * `duration=time`
          * Specifies the duration of the recording. Append s to specify the time in seconds, m for minutes, h for hours, or d for days (for example, specifying 5h means 5 hours). By default, the duration isn't limited, and this parameter is set to 0.
        * `filename=path`
          * Specifies the path and name of the file to which the recording is written when the recording is stopped, for example:
      
                  recording.jfr
                  /home/user/recordings/recording.jfr
                  c:\recordings\recording.jfr
                  If %p and/or %t is specified in the filename, it expands to the JVM's PID and the current timestamp, respectively.
      
        * `name=identifier`
          * Takes both the name and the identifier of a recording.
        * `maxage=time`
          * Specifies the maximum age of disk data to keep for the recording. This parameter is valid only when the disk parameter is set to true. Append s to specify the time in seconds, m for minutes, h for hours, or d for days (for example, specifying 30s means 30 seconds). By default, the maximum age isn't limited, and this parameter is set to 0s.
        * `maxsize=size`
          * Specifies the maximum size (in bytes) of disk data to keep for the recording. This parameter is valid only when the disk parameter is set to true. The value must not be less than the value for the maxchunksize parameter set with -XX:FlightRecorderOptions. Append m or M to specify the size in megabytes, or g or G to specify the size in gigabytes. By default, the maximum size of disk data isn't limited, and this parameter is set to 0.
        * `path-to-gc-roots={true|false}`
          * Specifies whether to collect the path to garbage collection (GC) roots at the end of a recording. By default, this parameter is disabled.
      
                          The path to GC roots is useful for finding memory leaks, but collecting it is time-consuming. Enable this option only when you start a recording for an application that you suspect has a memory leak. If the settings parameter is set to profile, the stack trace from where the potential leaking object was allocated is included in the information collected.
      
        * `settings=path`
          * Specifies the path and name of the event settings file (of type JFC). By default, the default.jfc file is used, which is located in JAVA_HOME/lib/jfr. This default settings file collects a predefined set of information with low overhead, so it has minimal impact on performance and can be used with recordings that run continuously.
      
           A second settings file is also provided, profile.jfc, which provides more data than the default configuration, but can have more overhead and impact performance. Use this configuration for short periods of time when more information is needed.
      
           You can specify values for multiple parameters by separating them with a comma. Event settings and .jfc options can be specified using the following syntax:
        * `option=value`
          * Specifies the option value to modify. To list available options, use the JAVA_HOME/bin/jfr tool.
        *  `event-setting=value`
          * Specifies the event setting value to modify. Use the form: <event-name>#<setting-name>=<value>
          * To add a new event setting, prefix the event name with '+'.
          * You can specify values for multiple event settings and .jfc options by separating them with a comma. In case of a conflict between a parameter and a .jfc option, the parameter will take precedence. The whitespace delimiter can be omitted for timespan values, i.e. 20ms. For more information about the settings syntax, see Javadoc of the jdk.jfr package.