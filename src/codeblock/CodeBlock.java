package codeblock;

import java.util.Arrays;

/**
 * 代码块
 * <p>
 * 1. 静态代码块
 * 格式：static {}
 * 特点：类加载时自动执行，类只会加载一次，静态代码只会执行一次
 * 作用：完成类的初始化，对静态变量初始化赋值。
 * 2. 实例代码块
 */
public class CodeBlock {

  public static String name = "大山";

  public static String[] cards= new String[10];

  // 静态代码块：与类一起加载，执行一次。
  static {
    System.out.println("静态代码块");
    name = "小山";
    for (int i = 0; i < cards.length; i++) {
      cards[i] = "卡片" + i;
    }

    System.out.println(Arrays.toString(cards));

  }

  enum CodeType {
    JAVA,
    JS,
    PYTHON,
    CPP
  }

  public static void main(String[] args) {
    System.out.println(name);
    System.out.println(Arrays.toString(cards));
  }

}
