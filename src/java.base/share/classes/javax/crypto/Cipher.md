* == class / 
  * provides functionality of a cryptographic cipher -- for --
    * encrypting
    * decrypting
* == Java Cryptographic Extension (JCE) framework's core
* ways to create an instance
  * `Cipher.getInstance()`
* `String transformation`
  * == operation OR operations / 
    * based on inputs -- produce -- outputs 
  * pattern == `cryptographicAlgorithmName/feedbackMode/paddingScheme`
    * `feedbackMode`
      * ALLOWED ones
        * `CFB`
        * `OFB`
      * allows
        * ciphers -- can encrypt -- data | units smaller /  than the cipher's actual
        * block size
* TODO: