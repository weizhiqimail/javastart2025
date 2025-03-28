package polymorphism;

public class Dog extends Animal {

  public Dog() {
    System.out.println("Dog Constructor");
  }

  @Override
  public  void run() {
    System.out.println("Dog is running");
  }

  @Override
  public void eat() {
    System.out.println("Dog is eating");
  }

}
