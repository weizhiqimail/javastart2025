package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 遍历集合的几种方式
 * 1. 迭代器
 * 2. for 循环
 * 3. forEach 循环
 * <p>
 */

public class CollectionTraverse {

  public static void main(String[] args) {
    Collection<String> names = new ArrayList<>();

    names.add("Tom");
    names.add("Jerry");
    names.add("Alice");
    names.add("Bob");
    names.add("Charlie");
    names.add("David");

    System.out.println("迭代器遍历");
    traverseCollection(names);

    System.out.println("for 循环遍历");
    traverseCollectionFor(names);

    System.out.println("for 循环泛型遍历");
    traverseCollectionForGenericity(names);

    System.out.println("forEach 遍历");
    traverseCollectionForEach(names);
  }

  // collection 的迭代器
  public static void traverseCollection(Collection<String> collection) {
    Iterator<String> iterator = collection.iterator();
    while (iterator.hasNext()) {
      String element = iterator.next();
      System.out.println(element);
    }
  }

  // for 循环遍历
  public static void traverseCollectionFor(Collection<String> collection) {
    for (String element : collection) {
      System.out.println(element);
    }
  }

  // forEach 遍历
  public static void traverseCollectionForEach(Collection<String> collection) {
    collection.forEach(new Consumer<String>() {
      @Override
      public void accept(String s) {
        System.out.println(s);
      }
    });

    // collection.forEach(s -> System.out.println(s));
    // collection.forEach(System.out::println);

  }

  // for 循环遍历，泛型
  public static <E> void traverseCollectionForGenericity(Collection<E> collection) {
    for (E element : collection) {
      System.out.println(element);
    }
  }

}
