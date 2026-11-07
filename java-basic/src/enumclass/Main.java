package enumclass;

// 枚举类
public class Main {

  public static void main(String[] args) {
    // 枚举类的使用
    ColorType redColor = ColorType.RED;

    System.out.println(redColor.name());
    System.out.println(redColor.ordinal());
    System.out.println(redColor.values());
    System.out.println("red color = " + redColor.getColor());
    System.out.println("red id = " + redColor.getId());
    System.out.println("red str = " + redColor.getStr());

  }

}
