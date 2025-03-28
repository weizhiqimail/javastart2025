package interfaceclass;

public interface BookInterface {

  String name = "";

  String author = "";

  double price = 0;

  public default void printName() {
    System.out.println("书名：" + name);
    this.run();
    printAuthor();
  }

  // 外部不能调用，只能内部调用
  private void run() {
    System.out.println("run");
  }

  // 静态方法：使用当前接口名来调用。
  public static void printAuthor() {
    System.out.println("作者：" + author);
  }


}
