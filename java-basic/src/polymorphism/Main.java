package polymorphism;

public class Main {
  public static void main(String[] args) {
    Animal animal = new Animal();
    animal.run();
    animal.eat();
    System.out.println("-----------------");

    Dog dog = new Dog();
    dog.run();
    dog.eat();
    System.out.println("-----------------");

    Animal animalDog = new Dog();
    animalDog.run();
    animalDog.eat();
    System.out.println("-----------------");

    if (animalDog instanceof Dog) {
      System.out.println("animalDog is an instance of Dog");
      animalDog.eat();
    } else {
      System.out.println("animalDog is not an instance of Dog");
    }


  }
}
