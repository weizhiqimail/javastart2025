package collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionList {

  public static void main(String[] args) {
    List<String> nameList = new ArrayList<>();
    nameList.add("Tom");
    nameList.add("Jerry");
    nameList.add("Alice");
    nameList.add("Bob");
    nameList.add("Charlie");

    System.out.println("nameList: " + nameList);

    String removeName = nameList.remove(2);
    System.out.println("removeName: " + removeName);
    System.out.println("nameList: " + nameList);
    nameList.set(0, removeName);
    System.out.println("nameList: " + nameList);


    nameList.forEach(System.out::printf);



  }

}
