package share.classes.com.sun.crypto.provider.PKCS5Padding;

//import java.base.share.classes.com.sun.crypto.provider;
import com.sun.crypto.provider.PKCS5Padding;

public class Main {
    public static void main(String[] args) {
        PKCS5Padding pkcs5Padding = new PKCS5Padding(8);
        byte[] in = new byte[8];

        pkcs5Padding.padLenght(2);
    }
}