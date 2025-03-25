package enumclass;

/**
 * 枚举类都是 final class
 * <p>
 * 枚举类的第一行只能罗列名称，而且都是常量。
 * 枚举类的构造器都是私有的，不能对外创建对象。
 * 如果枚举里只有一个常量，那么就是单例类
 */
public enum ColorType {

  RED("RED", 1),
  GREEN("GREEN", 2),
  BLUE("BLUE", 3);

  private String color;

  private int id;

  ColorType(String color, int id) {
    this.color = color;
    this.id = id;
  }

}
