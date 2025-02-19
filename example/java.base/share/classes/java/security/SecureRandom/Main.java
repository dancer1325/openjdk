package share.classes.java.security.SecureRandom;

import java.security.SecureRandom;
import static java.security.DrbgParameters.Capability.RESEED_ONLY;
import java.security.DrbgParameters;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // 1. ways to instantiate SecureRandom
        // 1.1 `new SecureRandom()`
        SecureRandom secureRandom1 = new SecureRandom();
        System.out.println("-- SecureRandom() -- " + secureRandom1);
        // 1.2 `SecureRandom.getInstance()`
        SecureRandom secureRandom2 = SecureRandom.getInstance("NativePRNG");
        System.out.println("-- SecureRandom.getInstance(\"NativePRNG\") -- " + secureRandom2);
        SecureRandom secureRandom3 = SecureRandom.getInstance("DRBG", DrbgParameters.instantiation(128, RESEED_ONLY, null));
        System.out.println("-- SecureRandom.getInstance(\"DRBG\") -- " + secureRandom3);

        // TODO:
    }
}
