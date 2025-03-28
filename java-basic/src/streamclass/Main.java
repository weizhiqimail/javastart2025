package streamclass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * steam 流，用于操作集合或数组的数据。
 * steam 流，大量的结合了 lambda 表达式的使用。
 */
public class Main {

  public static void main(String[] args) throws IOException {
    testStream();
  }

  public static void testStream() throws IOException {
    List<String> nameList = new ArrayList<>();
    nameList.add("赵敏");
    nameList.add("张无忌");
    nameList.add("张翠山");
    nameList.add("张三丰");
    nameList.add("周芷若");
    nameList.add("小昭");

    List<String> nameList2 = nameList
        .stream()
        .filter(name -> name.startsWith("张"))
        .map(name -> {
          return name + "是个好人";
        })
        .collect(Collectors.toList());

    String nameSt1 = nameList.stream().collect(Collectors.joining(","));
    String nameStr2 = String.join(",", nameList);

    System.out.println(nameList2);

    System.out.println(nameSt1);
    System.out.println(nameStr2);
    System.out.println(nameSt1 == nameStr2);
    System.out.println(nameSt1.equals(nameStr2));

  }

}
