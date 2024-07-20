* == classes / 
  * allows
    * implementing network applications
* == Low Level API + High Level API
  * Low Level API's abstractions
    * _Addresses_
      * == networking IDs -- _Example:_ IP address --
      * uses
        * 👁️ throughout the java.net APIs 👁️as
          * host identifier or
          * socket endpoint identifier
      * InetAddress
        * := class / -- represents an -- IP address
          * 👁️ Normally, it's enough -- rather than -- their subclasses 👁️
        * subclasses
          * Inet4Address
          * Inet6Address
    * _Sockets_
      * == bidirectional data communication mechanisms
        * == communication link between machine1 <-- over the network with --> machine2
      * types
        * java.net.Socket
          * := TCP client API
          * uses
            * -- connect, via InputStreams, to a -- remote host
        * java.net.ServerSocket
          * := TCP server API
          * uses
            * accept connections -- via InputStreams, from -- client sockets
        * java.net.DatagramSocket
          * TODO:
        * java.net.MulticastSocket
          * TODO:
    * _Interfaces_
      * allows
        * describing network interfaces
      * NetworkInterface
        * := class / allows ️
          * browse network interfaces of the 👁️ local machine 👁
          * query network interfaces of the 👁️ local machine 👁
        * uses
          * checking if some local interface supports IPv6
        * ANY implementation must support >= 1 NetworkInterface object / -- must be connected to --
          * a network OR
          * "loopback" interface
  * High Level API's abstractions
    * _URIs_
      * := class / -- represent -- Universal Resource Identifiers ([RFC2396](https://www.rfc-editor.org/info/rfc2396))
        * ⚠️NO means provided -- to access to the -- resource ⚠️ 
    * _URLs_
      * := class / -- represent -- Universal Resource Locators
    * _Connections_
      * == link between URLs -- & -- resource / pointed out
        * ⚠️NO dedicated class for it ⚠️
      * types
        * URLConnection
          * := class / 
            * -- created from a -- URL
            * -- delegate most of the work to the -- underlying protocol handlers (_Example:_ HTTP or HTTPS) 
          * uses
            * -- access to -- resource / pointed by the URL
        * HttpURLConnection
          * := subclass of URLConnection /
            * additional functionalities HTTP-specific
          *  ⚠️replaced by java.net.http ⚠️
    * how to use?
      * URI -- to identify -- resources
      * if you want to access to the resource -> convert URI -- to -- URL
      * from URL -- get
        * URLConnection OR
        * InputStream
* TODO: