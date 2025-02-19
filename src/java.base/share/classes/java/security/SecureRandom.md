* == class / 
  * 👀-- provides a -- cryptographically strong Random Number Generator (RNG) 👀
    * cryptographically RNG -- minimally complies with the -- [statistical random number generator tests](https://nvlpubs.nist.gov/nistpubs/FIPS/NIST.FIPS.140-2.pdf)
  * 👀-- produce -- non-deterministic output 👀
    * ->
      * ANY seed material passed | SecureRandom -> MUST be unpredictable
      * ALL `SecureRandom` output sequences are [cryptographically strong](https://tools.ietf.org/html/rfc4086)
  * ways to create an instance
    * no-argument constructor
    * one of the `SecureRandom.getInstance()`
* `SecureRandom` implementations
  * MOST, are pseudo-random number generator (PRNG)
    * == deterministic random bits generator (DRBG)
    * == from a random seed, produce -- via a deterministic algorithm, a -- pseudo-random sequence 
  * OTHER, produce true random numbers
  * OTHERS, combination of PREVIOUS ones
* TODO:
* `SecureRandom getInstance(String algorithm, SecureRandomParameters params){}`
  * return `SecureRandom` /
    * implements the RNG `algorithm`
    * supports the `SecureRandomParameters`
  * TODO:
* TODO:
