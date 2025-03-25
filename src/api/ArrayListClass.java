package api;

import java.util.ArrayList;

public class ArrayListClass {

  public static void main(String[] args) {

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
