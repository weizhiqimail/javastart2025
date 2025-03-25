package codeblock;

import java.util.Arrays;
import java.util.Comparator;

public class AnonymousClassUse2 {

  public static class Student {
    public String name;
    public int age;
    public double height;
    public String gender;

    public Student(String name, int age, double height, String gender) {
      this.name = name;
      this.age = age;
      this.height = height;
      this.gender = gender;
    }

    public static void main(String[] args) {
      Student[] students = new Student[10];
      students[0] = new Student("谢逊", 60, 1.8, "男");
      students[1] = new Student("张无忌", 30, 1.75, "男");
      students[2] = new Student("赵敏", 27, 1.65, "女");
      students[3] = new Student("周芷若", 25, 1.6, "女");
      students[4] = new Student("小昭", 18, 1.55, "女");
      students[5] = new Student("小昭", 18, 1.7, "男");
      students[6] = new Student("小昭", 18, 1.6, "男");
      students[7] = new Student("王昭君", 18, 1.65, "女");
      students[8] = new Student("貂蝉", 22, 1.7, "女");
      students[9] = new Student("殷素素", 23, 1.65, "女");

//      Arrays.sort(students, (s1, s2) -> {
//        if (s1.age != s2.age) {
//          return s1.age - s2.age;
//        }
//        if (s1.height != s2.height) {
//          return Double.compare(s1.height, s2.height);
//        }
//
//        return s1.name.compareTo(s2.name);
//      });

      Arrays.sort(students, new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
          if (s1.age != s2.age) {
            return s1.age - s2.age;
          }
          if (s1.height != s2.height) {
            return Double.compare(s1.height, s2.height);
          }

          return s1.name.compareTo(s2.name);
        }
      });


      for (int i = 0; i < students.length; i++) {
        if (students[i] != null) {
         Student stu = students[i];
          System.out.println(stu.name + " " + stu.age + " " + stu.height);
        }
      }

    }

  }

}