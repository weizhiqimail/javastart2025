package collection_grade;

import java.time.DayOfWeek;
import java.util.*;

public class CollectionGradeMap {

    public static void main(String[] args) {
        mapFn3();
    }

    public static void mapFn1() {
        User Jack = new User("Jack", 18);
        User Tom = new User("Tom", 20);
        User Sherry = new User("Sherry", 21);

        Map<String, User> userMap = new HashMap<>();
        userMap.put("Jack", Jack);
        userMap.put("Tom", Tom);
        userMap.put("Sherry", Sherry);

        System.out.println("userMap.get(\"Jack\") == Jack is " + (userMap.get("Jack") == Jack));
        System.out.println("Objects.equals(userMap.get(\"Jack\"), Jack) is " + (Objects.equals(userMap.get("Jack"), Jack)));

        for (Map.Entry<String, User> userEntry : userMap.entrySet()) {
            String key = userEntry.getKey();
            User user = userEntry.getValue();
            System.out.println("key = " + key + "； user = " + user.toString());
        }

    }

    public static void mapFn2() {
        Map<DayOfWeek, String> map = new EnumMap<>(DayOfWeek.class);

        map.put(DayOfWeek.MONDAY, "周1");
        map.put(DayOfWeek.TUESDAY, "周2");

        System.out.println(map);
        System.out.println(map.get(DayOfWeek.MONDAY));

        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("orange", 1);
        treeMap.put("apple", 2);
        treeMap.put("pear", 3);
        System.out.println(treeMap);
        for (String key : treeMap.keySet()) {
            System.out.println(key + " : " + treeMap.get(key));
        }
        for (String key : treeMap.keySet()) {
            System.out.println("key = " + key + " value = " + treeMap.get(key));
        }
    }

    public static void mapFn3() {
        Map<String, User> userMap = new TreeMap<>();
        User Jack = new User("Jack", 18);
        User Tom = new User("Tom", 20);
        User Sherry = new User("Sherry", 21);

        userMap.put("Jack", Jack);
        userMap.put("Tom", Tom);
        userMap.put("Sherry", Sherry);

        System.out.println("userMap.entrySet()" + userMap.entrySet());
        System.out.println("userMap.entrySet().stream()" + userMap.entrySet().stream());

        userMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(entry -> {
            String key = entry.getKey();
            User user = entry.getValue();
            System.out.println("正序 key = " + key + " value = " + user.getAge());
        });

        userMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(entry -> {
            String key = entry.getKey();
            User user = entry.getValue();
            System.out.println("倒序 key = " + key + " value = " + user.getAge());
        });
    }
}