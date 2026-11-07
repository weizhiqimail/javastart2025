package reflection;

import collection_grade.User;

import java.lang.reflect.Field;

public class ReflectionTest1 {

    public static void main(String[] args) throws Exception {
        reflectionFn2();
    }

    public static void reflectionFn1() throws NoSuchFieldException {
        Class stdClass = User.class;
        System.out.println("stdClass.getName() = " + stdClass.getName());
        System.out.println("stdClass.getField(userName) = " + stdClass.getField("userName"));
        System.out.println("stdClass.getDeclaredField(age) = " + stdClass.getDeclaredField("age"));

        Field userNameField = stdClass.getField("userName");
        System.out.println(userNameField.getType());
        System.out.println(userNameField.getName());
        System.out.println(userNameField.getModifiers());
    }

    public static void reflectionFn2() throws NoSuchFieldException, IllegalAccessException {
        User Jack = new User("Jack1111", 18);
        Class<?> userClass = Jack.getClass();
        Field field = userClass.getField("userName");
        System.out.println("field.get(Jack) = " + field.get(Jack));


    }
}
