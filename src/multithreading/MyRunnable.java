package multithreading;

// 这是一个线程任务，不是线程类。
public class MyRunnable implements Runnable {

  @Override
  public void run() {
    // 获取当前线程的名称
    String threadName = Thread.currentThread().getName();
    System.out.println("Runnable 线程 " + threadName + " 正在运行");
    for (int i = 0; i < 5; i++) {
      System.out.printf("Runnable 线程 %s 正在运行 %d\n", threadName, i);
    }
  }
}
