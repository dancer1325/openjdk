* `SSLSocket` == class /
  * extends `Socket`
  * provides secure sockets
    * -- via -- protocols
      * _Example of these protocols:_
        * "Secure Sockets Layer" (SSL)
        * IETF "Transport Layer Security" (TLS)
    * == 👁️ stream sockets / extra layer of security protections 👁️ 
      * type of protections / -- specified by a -- "cipher suite"
        * Integrity Protection
          * == modification of messages
        * Authentication
          * _Example:_ peer authentication
        * Confidentiality (Privacy Protection)
          * encrypting data / exchanged between client <- & -> server
  * once you create a `SSLSocket` -> NO "handshaking" agreed
    * applications set their communication preferences
      * cipher suite to use
      * where to place the socket (client or server)
      * ...
    * security is provided | time / application data is exchanged
  * 👁️ways to create it 👁️
    * `SSLSocketFactory`
    * accept a connection -- from a -- `SSLServerSocket`
  * places | operate
    * client
    * server
  * if you want to close the connection -> client & server should close it / specific order
    * ways
      * `Socket.close()`
        * close both sides
      * `Socket.shutdownOutput()` or `Socket.shutdownInput()` | client & server
    * if NO closed | specific order -> exceptions could be thrown
    * -> new `SSLSocket` must be created == must be reusable
* "cipher suite"
  * == combination of cryptographic algorithms / -- used by a -- SSL connection
    * ⚠️ if there is NO suite in common -> NO SSL connection can be established -> NO data can be exchanged ⚠️
    * established | "handshaking"
  * groups
    * supported cipher suites
      * == suites / supported by the SSL implementation
      * `getSupportedCipherSuites`
        * get the list of them
    * enabled cipher suites
      * 👁by default, set of cipher suites are part of it 👁
      * `setEnabledCipherSuites(setANewCipherSuite)`
      * `getEnabledCipherSuites`
        * get the list of them
  * 👁️ONLY "cipher suite" / authentication & confidentiality protection -> are enabled by default 👁️
* "handshaking"
  * == negotiation process / 
    * goal
      * create or rejoin a "session" / -- may protect -- connections | time
    * requires
      * client
      * server
    * based on place | operate `SSLSocket` -> determines who begins this process
  * once it's completed
    * -> you can access session attributes -- `getSession()` --
    * -- you may receive -- event notification
      * requirements
        * register it -- via using --
          * `HandshakeCompletedEvent`
          * `HandshakeCompletedListener`
  * ways to initiate it
    * `startHandshake`
      * -- explicitly begins -- handshakes
    * attempting to read OR write application data | socket
    * `getSession()`
      * if there is NO current valid session -> tries to set up a session -> initiate a handshake
  * 👁️ if handshaking fails -> `SSLSocket` is closed -> NO further communications can be done 👁️
  * 👁 ONLY, if BOTH sides agree to unauthenticated & non-private communications -> such "cipher suite" is selected 👁️
  * once initial handshaking has started -> socket can NOT switch client <-- & --> server 
* `ApplicationProtocol`
  * | network byte representation / -- sent by the -- peer
    * way to compare bytes 
      * directly
      * converting to -- its Unicode

* TODO: