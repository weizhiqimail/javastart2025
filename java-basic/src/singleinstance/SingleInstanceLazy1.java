package singleinstance;

/**
 * 懒汉式单例类
 * <p>
 * 1.把类的构造器私有
 * 2.定义额一个静态变量用于存储对象
 * 3.提供一个静态方法，保证返回的是同一个对象
 */
public class SingleInstanceLazy1 {
  private static SingleInstanceLazy1 singleInstanceLazy1 ;

  private SingleInstanceLazy1() {}

  public static SingleInstanceLazy1 getInstance() {
    if (singleInstanceLazy1 == null) {
      singleInstanceLazy1 = new SingleInstanceLazy1();
    }
    return singleInstanceLazy1;
  }

}
