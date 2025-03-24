public class Main {

  public static void main(String[] args) {
    testClone();
  }

  public static void testClone()  {
    Student stu1 = new Student(1, "jack", 18);
    try {
      Student stu2 = (Student) stu1.clone();
      System.out.println("stu1 ------------------------");
      System.out.println(stu1.id);
      System.out.println(stu1.name);
      System.out.println(stu1.age);

      System.out.println("stu2 ------------------------");
      System.out.println(stu2.id);
      System.out.println(stu2.name);
      System.out.println(stu2.age);


      stu1.setId(2);
      stu1.setName("rose");
      stu1.setAge(20);

      System.out.println("修改 stu1 后------------------------");
      System.out.println("stu1 ------------------------");
      System.out.println(stu1.id);
      System.out.println(stu1.name);
      System.out.println(stu1.age);

      System.out.println("stu2 ------------------------");
      System.out.println(stu2.id);
      System.out.println(stu2.name);
      System.out.println(stu2.age);


    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
  }


  public void init() {
    Student stu1 = new Student(1, "jack", 18);
    Student stu2 = stu1;

    System.out.println("stu1 ------------------------");
    System.out.println(stu1.id);
    System.out.println(stu1.name);
    System.out.println(stu1.age);

    System.out.println("stu2 ------------------------");
    System.out.println(stu2.id);
    System.out.println(stu2.name);
    System.out.println(stu2.age);

    stu1.setId(2);
    stu1.setName("rose");
    stu1.setAge(20);

    System.out.println("修改 stu1 后------------------------");


    System.out.println("stu1 ------------------------");
    System.out.println(stu1.id);
    System.out.println(stu1.name);
    System.out.println(stu1.age);

    System.out.println("stu2 ------------------------");
    System.out.println(stu2.id);
    System.out.println(stu2.name);
    System.out.println(stu2.age);
  }


}