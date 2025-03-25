package constructor;

// 调用兄弟构造器
public class Child1 extends Parent {
  private String name;

  private int age;

  private String address;

  public Child1(String name) {
    this(name, 12);
    System.out.println("Child1 String name Constructor");
  }

  public Child1(String name, int age) {
    this(name, age, "unknown");
    System.out.println("Child1 String name, int age Constructor");
  }

  public Child1(String name, int age, String address) {
    this.name = name;
    this.age = age;
    this.address = address;
    System.out.println("Child1 String name, int age, String address Constructor");
  }

  public void printInfo() {
    System.out.println("-----printInfo start------");
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Address: " + address);
    System.out.println("-----printInfo end------");
    System.out.println();

  }

  public static void main(String[] args) {
    Child1 c1 = new Child1("John");
    c1.printInfo();

    Child1 c2 = new Child1("Jane", 25);
    c2.printInfo();

    Child1 c3 = new Child1("Doe", 30, "New York");
    c3.printInfo();
  }
}
