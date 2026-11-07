package collection_grade;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {

    @Override
    public int compare(User a, User b) {
        return Integer.compare(a.getAge(), b.getAge());
    }
}
