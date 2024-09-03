* ALL files | this directory -- contains a -- CA certificate / PEM format
  * before the "-----BEGIN CERTIFICATE-----" line
    * suggestion & NOT arbitrary
  * can be generated via

    ```
    keytool -J-Duser.timezone=GMT -printcert -file ca.cert | sed -n '1,4p;8,10p'
    keytool -printcert -file ca.cert -rfc
    ```

* if you change this directory -> 
  * update the content of `test/jdk/sun/security/lib/cacerts/VerifyCACerts.java`
  * -- need to be approved by the -- Security group
