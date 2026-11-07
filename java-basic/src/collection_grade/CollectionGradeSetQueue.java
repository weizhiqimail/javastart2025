package collection_grade;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CollectionGradeSetQueue {

    public static void main(String[] args) {
        setQueueFn2();
    }

    public static void setQueueFn1() {
        Queue<String> q1 = new LinkedList<>();
        q1.offer("apple");
        q1.offer("banana");
        q1.offer("orange");

        System.out.println("head = " + q1.peek());

        System.out.println(q1);
        System.out.println("out = " + q1.poll());
        System.out.println(q1);

        System.out.println("size = " + q1.size());
        System.out.println("isEmpty = " + q1.isEmpty());
        System.out.println("contains('apple') = " + q1.contains("apple"));

        for (String key : q1) {
            System.out.println("for key = " + key);
        }

        Object[] qa1 = q1.toArray();
        for(int i = 0; i < qa1.length; i++ ){
            System.out.println("i = " + i + " value = " + qa1[i]);
        }

        String[] qArr1 = q1.toArray(new String[0]);
        System.out.println("qArr1 = " + Arrays.toString(qArr1));


    }

    public static void setQueueFn2() {
        Queue<User> qUser = new PriorityQueue<>(new UserComparator());
        User Jack = new User("Jack", 18);
        User Tom = new User("Tom", 20);
        User Sherry = new User("Sherry", 21);
        User Dazi = new User("Dazi", 12);
        qUser.offer(Jack);
        qUser.offer(Tom);
        qUser.offer(Sherry);
        qUser.offer(Dazi);

        System.out.println("qUser = " + qUser.toString());


    }
}
