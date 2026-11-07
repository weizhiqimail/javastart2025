package reflection;

import java.lang.reflect.Constructor;

public class ReflectionTest2 {
    public static void main(String[] args) throws Exception {
        Constructor cons1 = Integer.class.getConstructor(int.class);
        Integer n1 = (Integer) cons1.newInstance(123);
        System.out.println(n1);

        Object obj = null;
        String className = "collection_grade.User";
        Class<?> clazz = Class.forName(className);
        for(Constructor<?> c: clazz.getConstructors()) {
            Class<?>[] types = c.getParameterTypes();
            if (types.length ==2 && types[0] == String.class && types[1] == int.class) {
                obj = c.newInstance("Jerry", 21);
            }
        }
        System.out.println(obj);


    }

}
