package collection_grade;

import com.mysql.cj.xdevapi.Collection;

import java.util.*;

public class CollectionGradeList {

//    public static void main() {}

    public static void main(String[] args) {

//        listFn1("username__xxx", "nickname__xxx");
//        listFn2();
        listFn3();
    }

    public static void listFn1(String userName, String nickName) {
        List<String> userList = new ArrayList<>();

        // 增加元素
        userList.add(userName);
        userList.add(nickName);
        userList.add(null);
        System.out.println(userList.size());

        // 修改元素
        userList.add(0, "Tom1");
        userList.addFirst("Tom0");
        userList.addAll(List.of("Jack", "Jim"));
        userList.addAll(userList.size(), List.of("Trump", "Bide"));
        printListFn1(userList);
    }

    public static void printListFn1(List<String> list) {
        System.out.println("====== printList start ======");
        // 遍历元素
        System.out.println("for循环遍历元素，拿不到索引");
        for (String user : list) {
            System.out.println("无索引user=" + user);
        }

        System.out.println("for循环，list.size() 遍历元素，可以拿到索引，通过索引获取值");
        for (int i = 0; i < list.size(); i++) {
            String user = list.get(i);
            System.out.println("索引=" + i + "，user=" + user);
        }

        System.out.println("Iterator迭代器获取元素，拿不到索引，通过 next() 获取元素");
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println("Iterator迭代器获取 user" + s);
        }

        System.out.println("ListIterator迭代器获取元素，可以拿到索引，通过 next() 获取元素");
        for (ListIterator<String> it = list.listIterator(); it.hasNext(); ) {
            int idx = it.nextIndex();
            String s = it.next();
            System.out.println("ListIterator迭代器 i=" + idx + " user=" + s);
        }

        System.out.println("简化版的 forEach 遍历元素，不能拿到索引，可以获取值");
        for (String s : list) {
            System.out.println("user=" + s);
        }

        System.out.println("list.forEach 遍历元素，不能拿到索引，可以获取值");
        list.forEach(s -> System.out.println("list.forEach user=" + s));

        System.out.println("list.forEach(System.out::println)，不能拿到索引，可以获取值");
        list.forEach(System.out::println);

        System.out.println("常规forEach 遍历元素，不能拿到索引，可以获取值");
        list.forEach(s -> {
            if (s != null) {
                System.out.println("user=" + s);
            }
        });

        System.out.println("====== printList end ======");

    }

    public static void listFn2() {
        List<String> userList = new ArrayList<>();

        userList.add("Tom");
        userList.add("Jack");
        userList.add("Sherry");


        // 把 List 转为 Array
        Object[] userArray = userList.toArray();
        for (int i = 0; i < userArray.length; i++) {
            System.out.println("List 转为 Array i=" + i + " user=" + userArray[i]);
        }

        Arrays.stream(userArray).forEach(s -> System.out.println("Arrays.stream(userArray).forEach " + s));

        List<Integer> yearList = List.of(2021, 2022, 2023);
        Integer[] yearArray = yearList.toArray(new Integer[yearList.size()]);
        for (Integer year : yearArray) {
            System.out.println("useList.toArray() year=" + year);
        }

        Integer[] ageArray = {18, 19, 20};
        for (Integer age : ageArray) {
            System.out.println("ageArray " + age);
        }


    }

    public static void printListFn2(List<String> list) {
        System.out.println("ListIterator迭代器获取元素，可以拿到索引，通过 next() 获取元素");
        for (ListIterator<String> it = list.listIterator(); it.hasNext(); ) {
            int idx = it.nextIndex();
            String s = it.next();
            System.out.println("ListIterator迭代器 i=" + idx + " user=" + s);
        }
    }

    public static void listFn3() {
        int startNum = 11;
        int endNum = 20;

        List<Integer> numList = new ArrayList<>();
        for (int i = startNum; i <= endNum; i++) {
            numList.add(i);
        }

        System.out.println(numList);

        // 混淆顺序
        //  Collections.shuffle(numList);
        int removedNum = numList.remove((int) (Math.random() * numList.size()));
        int foundNumV1 = findMissingNumberV1(startNum, endNum, numList);
        int foundNumV2 = findMissingNumberV2(startNum, endNum, numList);
        int foundNumV3 = findMissingNumberV3(startNum, endNum, numList);
        int foundNumV4 = findMissingNumberV4(startNum, endNum, numList);
        System.out.println("removedNum = " + removedNum);
        System.out.println("foundNumV1 = " + foundNumV1);
        System.out.println("foundNumV2 = " + foundNumV2);
        System.out.println("foundNumV3 = " + foundNumV3);
        System.out.println("foundNumV4 = " + foundNumV4);

    }

    // 只支持有序列表
    public static int findMissingNumberV1(int startNum, int endNum, List<Integer> list) {
        for (int i = startNum; i <= endNum; i++) {
            boolean found = false;
            for (int n = 0; n < list.size(); n++) {
                if (i == list.get(n)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return i;
            }

        }
        return -1;
    }

    // 只支持有序列表
    public static int findMissingNumberV2(int startNum, int endNum, List<Integer> list) {
        for (int i = startNum; i <= endNum; i++) {
            if (!list.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    // 支持有序列表和无序列表，列表循环
    public static int findMissingNumberV3(int startNum, int endNum, List<Integer> list) {
        int sum = 0;
        for (int i = startNum; i <= endNum; i++) {
            sum += i;
        }
        // 总和是 sum

        int listSum = 0;
        for (int i = 0; i < list.size(); i++) {
            listSum += list.get(i);
        }

        return sum - listSum;
    }

    // 支持有序列表和无序列表，HashSet
    public static int findMissingNumberV4(int startNum, int endNum, List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        for (int i = startNum; i<endNum;i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
