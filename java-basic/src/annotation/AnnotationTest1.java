package annotation;



public class AnnotationTest1 {

    public static void main(String[] args) {
        Class<?> clazz = AnnotationUser.class;
        if (clazz.isAnnotationPresent(Report.class)) {
            Report report = clazz.getAnnotation(Report.class);
            System.out.println(report.type());
            System.out.println(report.level());
            System.out.println(report.value());
        }

    }
}
