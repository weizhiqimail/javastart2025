package collection_grade;

import lombok.Getter;

@Getter
public class User implements Comparable<User> {

    public String userName;

    private int age;

    public  User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "userName = " + this.userName + "，age = " + this.age + "。";
    }

    @Override
    public int compareTo(User u) {
        return Integer.compare(this.age, u.age);
    }
}
