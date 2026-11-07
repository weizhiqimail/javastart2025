package enumclass;

import lombok.Getter;

/**
 * 枚举类都是 final class
 * <p>
 * 枚举类的第一行只能罗列名称，而且都是常量。
 * 枚举类的构造器都是私有的，不能对外创建对象。
 * 如果枚举里只有一个常量，那么就是单例类
 */
@Getter
public enum ColorType {

  RED("RED", 1, "a"),
  GREEN("GREEN", 2, "b"),
  BLUE("BLUE", 3, "c");

  private final String color;

  private final int id;

  private final String str;

  ColorType(String color, int id, String str) {
    this.color = color;
    this.id = id;
    this.str = str;
  }

}
