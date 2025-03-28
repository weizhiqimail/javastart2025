public class Student extends Human {

  public String name;

  public int age;


  public Animal animal;

  public Student(int id, String name, int age) {
    super(id);
    this.name = name;
    this.age = age;
    this.animal = new Animal(name + "的 dog");
  }


  public void setAge(int age) {
    this.age = age;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

}