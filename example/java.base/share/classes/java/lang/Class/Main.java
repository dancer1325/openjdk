package share.classes.java.lang.Class;


public class Main {
    public static void main(String[] args) {
        // 1. getClassLoader()
        System.out.println("AnotherClass.class.getClassLoader() " + AnotherClass.class.getClassLoader());
        System.out.println("AnotherClass.class.getClassLoader().getName() " + AnotherClass.class.getClassLoader().getName());
        System.out.println("Main.class.getClassLoader() " + Main.class.getClassLoader());
        System.out.println("Main.class.getClassLoader().getName() " + Main.class.getClassLoader().getName());

        // 2. getClassLoader() | []Type
        System.out.println("String.class.getClassLoader() " + String.class.getClassLoader());
        System.out.println("String[].class.getClassLoader() " + String[].class.getClassLoader());
        int[] intArray = new int[10];
        System.out.println("intArray.getClass().getClassLoader() " + intArray.getClass().getClassLoader());
    }
}

