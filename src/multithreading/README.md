# 多线程

- 线程是第一个程序内部的一条执行流程。
- 多线程是指从软硬件上实现的多条执行流程的技术。（多条线程由CPU负责执行调度）
- 创建多线程
  - 【常用】继承 Thread 类
    - 编码简单
    - 启用必须使用 start() 方法。如果调用了 run() 方法，就被认为是一个普通的类，与线程无关。
    - 不支持多继承，线程类已经继承了 Thread，无法继承其他的类。
  - 【常用】实现 Runnable 接口
    - 任务类只是实现接口，可以继承其他类，实现其他接口，扩展性强
    - 需要多一个 Runnable 对象来启动线程
  - 【不常用】基于 Runnable 创建匿名内部类
    - 可以创建 Runnable 的匿名内部类对象
    - 交给 Thread 线程对象
    - 调用 start() 方法启动线程
  - 【常用】基于 Callable 接口，使用 FutureTask
    - 【Thread】【Runnable】的问题在于，假如线程执行完毕后，有一些数据需要返回，run() 方法不能直接返回结果。
    - 步骤
      - 定义一个类实现 Callable 接口，重写 call() 方法，封装方法，返回数据。
      - 创建一个 FutureTask 对象，传入 Callable 对象
      - 创建一个 Thread 对象，传入 FutureTask 对象
      - 调用 start() 方法启动线程
      - 调用 FutureTask 对象的 get() 方法获取线程执行结果
      - 注意：get() 方法是阻塞的，直到线程执行完毕才会返回结果
      - 注意：Callable 接口的 call() 方法可以抛出异常，run() 方法不能抛出异常

```java
public class MyThread extends Thread {
  @Override
  public void run() {
    System.out.println("线程 " + Thread.currentThread().getName() + " 正在执行");
  }
}

public class MyRunnable implements Runnable {
  @Override
  public void run() {
    System.out.println("线程 " + Thread.currentThread().getName() + " 正在运行");
  }
}

public class MyAnonymousRunnable {
  public static void main(String[] args) {
    // 继承 Thread 类创建线程
    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("线程 " + Thread.currentThread().getName() + " 正在运行");
      }
    }).start();

    // 使用 Lambda 表达式创建线程
    new Thread(() -> System.out.println("线程 " + Thread.currentThread().getName() + " 正在运行")).start();
    
  }
}

```


