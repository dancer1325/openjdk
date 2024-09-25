# Goal
* implement HostnameVerifier

## How to run it locally?
* `javac share/classes/javax/net/ssl/HostnameVerifier/Main.java`
* `java share.classes.javax.net.ssl.HostnameVerifier.Main`

## Problems
* Problem1: Why `.verify()` logs do NOT appear == why does handshake NOT invoked ?
  * Attempt1: `connection.getInputStream()`
  * Solution: TODO: