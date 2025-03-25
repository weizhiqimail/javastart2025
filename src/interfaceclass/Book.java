package interfaceclass;

public class Book implements BookInterface {

  private String name;

  private String author;

  private double price;

  public Book(String name, String author, double price) {
    this.name = name;
    this.author = author;
    this.price = price;
  }

  @Override
  public void printName() {
    System.out.println("书名：" + name);
  }


}
