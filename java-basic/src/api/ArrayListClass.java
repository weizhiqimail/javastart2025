package api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListClass {

  public static void main(String[] args) {

    ArrayList<Number> yearList = new ArrayList<>(List.of(1, 2, 3));
    List<Integer> yearList2 = Stream.of(1, 2, 3).collect(Collectors.toList());
    List<Integer> yearList3 = Stream.of(1, 2, 3).toList();



    ArrayList<String> companyList = new ArrayList<String>();
    companyList.add("Google");
    companyList.add("Apple");
    companyList.add("Microsoft");

    System.out.println(companyList);
    System.out.println(companyList.size());

    ArrayList<String> cloneCompanyList = (ArrayList<String>) companyList.clone();
    companyList.remove("Google");
    System.out.println(companyList);
    System.out.println(cloneCompanyList);
    System.out.println(cloneCompanyList.contains("Google"));
    System.out.println("==================================");

    companyList.clear();
    System.out.println(companyList);

  }

}
