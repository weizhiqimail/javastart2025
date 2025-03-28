package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Main {
  public static void main(String[] args) {
//    useThread();
//    useRunnable();
    useCallable();
  }

  // 使用 Thread
  public static void useThread() {
    Thread myThread0 = new MyThread();
    // 启用线程
    myThread0.start();

    System.out.println("useThread 主线程 正在运行");
    for (int i = 0; i < 5; i++) {
      System.out.printf("useThread 主线程 正在运行 %d\n", i);
    }

  }

  // 使用 Runnable
  public static void useRunnable() {
    // 创建一个 Runnable 对象
    Runnable myRunnable = new MyRunnable();
    // 创建一个 Thread 对象，并传入 Runnable 对象
    Thread myThread1 = new Thread(myRunnable);
    // 启用线程
    myThread1.start();

    System.out.println("useRunnable 主线程 正在运行");
    for (int i = 0; i < 5; i++) {
      System.out.printf("useRunnable 主线程 正在运行 %d\n", i);
    }
  }

  // 使用 Callable
  public static void useCallable() {
    // 创建一个 Callable 对象
    MyCallable myCallable0 = new MyCallable();
    // 把 Callable 对象封装位一个真正的线程任务对象 FutureTask 对象
    FutureTask<String> futureTask0 = new FutureTask<>(myCallable0);
    // FutureTask 实际上是一个线程任务对象，可以交给 Thread 线程对象处理。
    // 可以获取线程执行完毕后的结果
    // 把 FutureTask 对象传入 Thread 对象
    Thread myThread0 = new Thread(futureTask0);
    // 启用线程
    myThread0.start();
    // 通过 FutureTask 对象获取线程执行完毕后的结果
    try {
      String result = futureTask0.get();
      System.out.println("【主线程等待子线程的结果】" + result);
      System.out.println("useCallable 主线程 正在运行");
      for (int i = 0; i < 5; i++) {
        System.out.printf("useCallable 主线程 正在运行 %d\n", i);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

//    MyCallable myCallable1 = new MyCallable();
//    FutureTask<String> futureTask1 = new FutureTask<>(myCallable1);
//    Thread myThread1 = new Thread(futureTask1);
//    myThread1.start();

  }

}
