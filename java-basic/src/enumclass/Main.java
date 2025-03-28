package enumclass;

// 枚举类
public class Main {

  public static void main(String[] args) {
    // 枚举类的使用
    ColorType colorType = ColorType.RED;

    System.out.println(colorType.name());
    System.out.println(colorType.ordinal());
    System.out.println(colorType.values());

  }

}
