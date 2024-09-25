# Goal
* instantiate `SSLSocket`
* `ApplicationProtocol`

## How to run it locally?
* `javac share/classes/javax/net/ssl/SSLSocket/Main.java`
* `java share.classes.javax.net.ssl.SSLSocket.Main`

## Problems
* Problem1: HandshakeApplicationProtocol is null
  * Attempt1: create Socket against "www.google.com"
  * Attempt2: `startHandshake()` before trying to get it
  * Solution: TODO: