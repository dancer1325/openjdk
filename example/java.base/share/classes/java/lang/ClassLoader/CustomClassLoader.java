package share.classes.java.lang.ClassLoader;

import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = name.replace('.', '/') + ".class";
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(path)) {
            if (input == null) {
                throw new ClassNotFoundException("Class not found: " + name);
            }
            byte[] classBytes = input.readAllBytes();
            return defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Error reading class bytes: " + name, e);
        }
    }
}
