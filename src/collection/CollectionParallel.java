package collection;

import java.util.ArrayList;

/**
 * 遍历集合的同时，又存在增删集合元素的行为，可能会出现业务异常，这种现象被称为并发修改异常问题。
 * <p>
 * 1. 迭代器遍历集合时，不能在遍历的同时修改集合元素，否则会抛出 ConcurrentModificationException 异常。
 * <p>
 * 2. 如果使用迭代器，使用迭代器自身的 remove() 方法删除元素是安全的。
 * <p>
 * 3. 使用 for 循环遍历集合时，可以在遍历的同时修改集合元素，但需要注意索引的变化。
 * <p>
 * 4. forEach 在使用 lambda 表达式时，底层使用的还是迭代器，所以不能在遍历的同时修改集合元素。
 * <p>
 * 5. for 和 forEach 最好只用于遍历集合，不要在遍历的同时修改集合元素。
 */
public class CollectionParallel {


  public static void main(String[] args) {
    ArrayList<String> list1 = new ArrayList<>();

    list1.add("入门");
    list1.add("进阶");
    list1.add("高级");
    list1.add("面试");
    list1.add("实战");
    list1.add("项目");
    list1.add("框架");
    list1.add("工具");
    list1.add("设计模式");
    list1.add("多线程");
    list1.add("网络编程");
    list1.add("数据库");
    list1.add("虚拟机");

    System.out.println("初始化 list1：" + list1);

    ArrayList<String> list2 = (ArrayList<String>) list1.clone();
    System.out.println("初始化 list2：" + list2);

    ArrayList<String> list3 = (ArrayList<String>) list1.clone();
    System.out.println("初始化 list3：" + list3);

//    for (String name : list1) {
//      System.out.println(name);
//      if (name.equals("面试")) {
//        list1.remove(name); // 这里会抛出并发修改异常
//      }
//    }

    for (int i = 0; i < list2.size(); i++) {
      String name = list2.get(i);
      if (name.equals("面试")) {
        list2.remove(name); // 这里不会抛出异常
        i--;
      }
    }
    System.out.println("list2 删除面试后：" + list2);

  }

}
