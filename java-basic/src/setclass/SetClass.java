package setclass;

import java.util.*;

/**
 *
 * HashSet 无序，不重复，无索引
 *
 * LinkedHashSet：有序，不重复，无索引
 *
 * TreeSet：有序，不重复，无索引，按字典顺序排序
 *
 * JDK 8 开始的哈希表：数组+链表+红黑树，
 * 假设数组位置上有多个元素，则使用链表存储这些元素，新元素会添加到链表的头部，旧元素会添加到链表的尾部。
 * 当链表长度超过8，且数组长度超过64时，链表会转换为红黑树。
 *
 * */
public class SetClass {

  public static void main(String[] args) {

    // HashSet 无序，不重复，无索引
    Set<String> hSet = new HashSet<>();
    hSet.add("加州");
    hSet.add("德克萨斯州");
    hSet.add("德克萨斯州");
    hSet.add("佛罗里达州");
    hSet.add("纽约州");
    hSet.add("纽约州");
    hSet.add("伊利诺伊州");
    System.out.println(hSet);
    traverse(hSet);

    // LinkedHashSet：有序，不重复，无索引
    Set<String> linkedHashSet = new LinkedHashSet<>();
    linkedHashSet.add("加州");
    linkedHashSet.add("德克萨斯州");
    linkedHashSet.add("德克萨斯州");
    linkedHashSet.add("佛罗里达州");
    linkedHashSet.add("纽约州");
    linkedHashSet.add("纽约州");
    linkedHashSet.add("伊利诺伊州");
    System.out.println(linkedHashSet);

    // TreeSet：有序，不重复，无索引，按字典顺序排序
    Set<String> treeSet = new TreeSet<>();
    treeSet.add("加州");
    treeSet.add("德克萨斯州");
    treeSet.add("德克萨斯州");
    treeSet.add("佛罗里达州");
    treeSet.add("纽约州");
    treeSet.add("纽约州");
    treeSet.add("伊利诺伊州");
    System.out.println(treeSet);



  }

  public static void traverse(Set<String> set) {

    // 迭代器遍历
    System.out.println("迭代器遍历");
    Iterator<String> iterator = set.iterator();
    while (iterator.hasNext()) {
      String element = iterator.next();
      System.out.println(element);
    }

    // forEach 遍历
    System.out.println("forEach 遍历");
    set.forEach(element -> {
      System.out.println(element);
    });

    // 增强 for 循环遍历
    System.out.println("增强 for 循环遍历");
    for (String element : set) {
      System.out.println(element);
    }




  }


}
