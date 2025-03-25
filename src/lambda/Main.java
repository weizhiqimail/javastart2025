package lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

  public static void main(String[] args) {
    sortName();
  }

  public static void sortName() {
    // 列出20个英文名字
    String[] nameList = {"John", "jane", "alice", "Alice", "Charlie", "david", "eve", "Frank", "Grace", "Hannah", "Isaac", "Jack", "Kathy", "liam", "mia", "noah", "Olivia", "Paul", "Quinn"};

    // 对 nameList 进行排序
    Arrays.sort(nameList, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        // 忽略大小写进行比较
        return o1.compareToIgnoreCase(o2);
      }
    });

    // 打印排序后的结果
    System.out.println(Arrays.toString(nameList));

  }

  public static void testCompare() {
    Lambda1 lambda1 = new Lambda1();
    Double[] arr = {10.0, 20.0, 30.0};
    Arrays.sort(arr, lambda1::compareDouble);
  }
}
