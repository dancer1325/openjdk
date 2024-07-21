package share.classes.java.lang.ClassLoader;

public class Main {
    public static void main(String[] args) {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        try {
            // Load the class using the custom class loader
            // TODO: Where is the binaryName? I just see a String
            Class<?> clazz = customClassLoader.loadClass("share.classes.java.lang.ClassLoader");

            // Create an instance of the loaded class and invoke its method
            Object instance = clazz.getDeclaredConstructor().newInstance();
            clazz.getMethod("printMessage").invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
