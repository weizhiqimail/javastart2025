import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    generateStudentList();
  }

  public static void testClone()  {
    Student stu1 = new Student(1, "jack", 18);
    try {
      Student stu2 = (Student) stu1.clone();
      System.out.println("stu1 ------------------------");
      System.out.println(stu1.id);
      System.out.println(stu1.name);
      System.out.println(stu1.age);
      System.out.println(stu1.animal.getName());

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

  public static void init() {
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

  public static void generateStudentList () {
    Student[] stuList = new Student[5];
    stuList[0]= new Student(1, "jack", 18);
    stuList[1]= new Student(2, "rose", 20);
    stuList[2]= new Student(3, "tom", 22);
    stuList[3]= new Student(4, "jerry", 24);
    stuList[4]= new Student(5, "lucy", 26);


    for (int i = 0; i < stuList.length; i++) {
      printStudentInfo(stuList[i]);
    }

    System.out.println("请输入要查询的用户 id：");
    Scanner sc = new Scanner(System.in);
    int inputStuId = sc.nextInt();
    for (Student student : stuList) {
      if (student.id == inputStuId) {
        System.out.println("查询到的用户信息如下：");
        printStudentInfo(student);
        return;
      }
    }
    System.out.println("未查询到该用户");

  }

  public static void printStudentInfo(Student stu) {
    System.out.println("id:" + stu.id + "\t" + "name:" + stu.name + "\t" + "age:" + stu.age);

  }

}