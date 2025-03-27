package multithreaduse;

public class MyThread2 extends Thread {
  @Override
  public void run() {
    String threadName = Thread.currentThread().getName();
    System.out.println("Thread " + threadName + " 开始运行");
    for (int i = 1; i <= 5; i++) {
      System.out.printf("子线程 %s 正在运行 %d\n", threadName, i);
    }
  }
}
