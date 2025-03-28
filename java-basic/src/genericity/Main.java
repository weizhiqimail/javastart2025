package genericity;

import java.util.ArrayList;

// 泛型、集合不支持基本数据类型，只能使用对象类型（引用类型）
// 泛型消除，编译时会将泛型转换为Object类型
public class Main {

  public static void main(String[] args) {
    Integer[] arr1 = {10, 20, 30};
    Double[] arr2 = {10.0, 20.0, 30.0};
    String[] arr3 = {"Hello", "World", "java"};

    genericity(arr1);
    genericity(arr2);
    genericity(arr3);

    StudentData stuData = new StudentData();
    Student stu1 = new Student();
    Student stu2 = new Student();

    stuData.add(stu1);
    stuData.add(stu2);

    ArrayList<Car> cars = new ArrayList<>();

    cars.add(new Car());
    cars.add(new Lixiang());
    cars.add(new Xiaomi());

    carsGo(cars);

    // 自动装箱和拆箱
    Integer age = Integer.valueOf(20);
    ArrayList<Integer> list = new ArrayList<>();
    list.add(120);
    list.add(age);

    int age1 = age.intValue();

    System.out.println(age);
    System.out.println(age1);
    System.out.println("age == age1: " + (age == age1)); // true


  }

  // 泛型方法
  public static <E> void genericity(E[] list) {
    for (E e : list) {
      System.out.printf("%s ", e);
    }
    System.out.println();
  }

  // 通配符，上下限
  public static void carsGo(ArrayList<? extends Car> cars) {
    for (Car car : cars) {
      car.print();
    }
  }

}
