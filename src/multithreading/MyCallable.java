package multithreading;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

  private final int n;

  public MyCallable() {
    this.n = 5;
  }

  public MyCallable(int n) {
    this.n = n;
  }

  @Override
  public String call() {
    String threadName = Thread.currentThread().getName();
    System.out.println("Callable 线程 " + threadName + " 开始运行");
    for (int i = 0; i < n; i++) {
      System.out.printf("Callable 线程 %s 正在运行 %d\n", threadName, i);
    }
    return "[call] Callable 线程 " + threadName + " 运行结束";
  }
}
