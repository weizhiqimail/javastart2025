package threadpool;

// 这是一个线程任务，不是线程类。
public class MyRunnable implements Runnable {

  @Override
  public void run() {
    // 获取当前线程的名称
    String threadName = Thread.currentThread().getName();
    System.out.println("Runnable " + threadName + " 开始运行");
    for (int i = 0; i < 5; i++) {
      System.out.printf("Runnable 线程 %s 正在运行 %d\n", threadName, i);
      try {
        Thread.sleep(Integer.MAX_VALUE);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    System.out.println("Runnable " + threadName + " 结束运行");
  }
}
