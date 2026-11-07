package annotation;

import collection_grade.User;
import lombok.Getter;

@Report(type = 1, level = "warning", value = "空白 value")
@Getter
public class AnnotationUser implements Comparable<User> {

    public String userName;

    private int age;

    public AnnotationUser(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "userName = " + this.userName + "，age = " + this.age + "。";
    }

    @Override
    public int compareTo(User u) {
        return Integer.compare(this.age, u.getAge());
    }
}
