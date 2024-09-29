package share.classes.java.beans.PropertyDescriptor;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            // Create a Person object
            Person person = new Person();

            // Create PropertyDescriptor for 'name' property
            PropertyDescriptor nameDescriptor = new PropertyDescriptor("name", Person.class);

            // Get the setter method for 'name'
            Method setter = nameDescriptor.getWriteMethod();

            // Set the 'name' property value using the setter
            setter.invoke(person, "Alice");

            // Get the getter method for 'name'
            Method getter = nameDescriptor.getReadMethod();

            // Get the 'name' property value using the getter
            String name = (String) getter.invoke(person);

            // Print the 'name' property
            System.out.println("Person's name: " + name);

            // Do the same for 'age'
            PropertyDescriptor ageDescriptor = new PropertyDescriptor("age", Person.class);
            Method setAge = ageDescriptor.getWriteMethod();
            setAge.invoke(person, 30);

            Method getAge = ageDescriptor.getReadMethod();
            int age = (int) getAge.invoke(person);
            System.out.println("Person's age: " + age);

        } catch (IntrospectionException | ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}
