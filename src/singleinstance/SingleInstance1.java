package singleinstance;

// 单例简化模式
// 饿汉单例：拿对象时，对象已经创建好了
// 懒汉单例：拿对象时，才开始创建对象。延迟加载对象。
public class SingleInstance1 {

  public static final SingleInstance1 singleInstance1 = new SingleInstance1();

  private SingleInstance1() {
    // Private constructor to prevent instantiation
  }

}
