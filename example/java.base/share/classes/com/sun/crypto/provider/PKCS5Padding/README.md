# Goal
* `PKCS5Padding`

## How to run it locally?
* | "example/java.base",
  * `javac ...`
    * Attempts:
      * `javac share/classes/com/sun/crypto/provider/PKCS5Padding/Main.java`
        * "error: package com.sun.crypto.provider is not visible"
      * `javac --add-exports java.base/com.sun.crypto.provider=ALL-UNNAMED share/classes/com/sun/crypto/provider/PKCS5Padding/Main.java`
        * "error: PKCS5Padding is not public"
    * Solution: TODO: ONLY SOLUTION to put code | SAME package ❓
* `java share.classes.javax.net.ssl.HostnameVerifier.Main`

## Problems
* Problem1: