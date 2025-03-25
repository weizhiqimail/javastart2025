package codeblock;

// 匿名内部类：子类，立即创建一个子类对象
public class AnonymousClass {

  public abstract class Animal {
    public abstract void eat();
  }

  public void animalEat(String[] args) {
    Animal animal = new Animal() {
      @Override
      public void eat() {
        System.out.println("吃东西");
      }
    };
    animal.eat();
  }


  public static void main(String[] args) {

  }


}
