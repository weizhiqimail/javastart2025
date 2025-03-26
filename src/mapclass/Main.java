package mapclass;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * HashMap 无序，允许重复键，允许重复值
 * LinkedHashMap 有序，允许重复键，允许重复值。每一个元素都有一个双向链表的前后指针，指向下一个元素和上一个元素。
 * TreeMap 有序，允许重复键，允许重复值
 * Hashtable 无序，不允许重复键，不允许重复值
 * Properties 有序，允许重复键，允许重复值
 */
public class Main {

  public static void main(String[] args) {
    // HashMap 无序，允许重复键，允许重复值
    Map<String, String> hashMap = new HashMap<>();
    put(hashMap);
    traverseMap(hashMap);
  }

  public static Map<String, String> put(Map<String, String> map) {
    map.put("California", "加州");
    map.put("Texas", "德克萨斯州");
    map.put("Florida", "佛罗里达州");
    map.put("New York", "纽约州");
    map.put("Illinois", "伊利诺伊州");
    return map;
  }

  public static void diffMaps() {
    // HashMap 无序，允许重复键，允许重复值
    Map<String, String> hashMap = new HashMap<>();
    put(hashMap);
    System.out.println("遍历 traverseMap hashMap");
    traverseMap(hashMap);

    // LinkedHashMap 有序，允许重复键，允许重复值
    Map<String, String> linkedHashMap = new LinkedHashMap<>();
    put(linkedHashMap);
    System.out.println("遍历 traverseMap linkedHashMap");
    traverseMap(linkedHashMap);

    // TreeMap 有序，允许重复键，允许重复值
    Map<String, String> treeMap = new TreeMap<>();
    put(treeMap);
    System.out.println("遍历 traverseMap treeMap");
    traverseMap(treeMap);

    // Hashtable
    Map<String, String> hashtable = new Hashtable<>();
    put(hashtable);
    System.out.println("遍历 traverseMap hashtable");
    traverseMap(hashtable);
  }

  public static void traverseMap(Map<String, String> map) {

    // 使用 for 的 keySet() 循环遍历
    System.out.println("使用 for 的 keySet() 循环遍历");
    for (String key : map.keySet()) {
      System.out.println("key: " + key + " value: " + map.get(key));
    }
    System.out.println();

    // 使用 for 的 values() 循环遍历
    System.out.println("使用 for 的 values() 循环遍历");
    for (String value : map.values()) {
      System.out.println("value: " + value);
    }
    System.out.println();

    // 使用 for 的 entrySet() 循环遍历
    System.out.println("使用 for 的 entrySet() 循环遍历");
    Set<Map.Entry<String, String>> entries = map.entrySet();
    for (Map.Entry<String, String> entry : entries) {
      System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
    }
    System.out.println();

    // 使用 forEach() 的 lambda 表达式循环遍历
    System.out.println("使用 forEach() 的 lambda 表达式循环遍历");
    map.forEach((key, value) -> {
      System.out.println("key: " + key + " value: " + value);
    });
    System.out.println();

    // 使用 forEach() 的 BiConsumer 循环遍历
    System.out.println("使用 forEach() 的 BiConsumer 循环遍历");
    map.forEach(new BiConsumer<String, String>() {
      @Override
      public void accept(String key, String value) {
        System.out.println("key: " + key + " value: " + value);
      }
    });

  }

}
