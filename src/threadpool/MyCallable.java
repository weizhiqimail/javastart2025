package threadpool;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

  private int n;

  public MyCallable(int n) {
    this.n = n;
  }

  @Override
  public String call() {
    String threadName = Thread.currentThread().getName();
    System.out.println("Callable 线程 " + threadName + " 开始运行");
    int sum = 0;
    for (int i = 1; i <= this.n; i++) {
      sum += i;
    }
    return threadName + "计算 1-" + n + " 运行结束。结果是：" + sum;
  }
}
