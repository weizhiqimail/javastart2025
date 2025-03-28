package multithreading;

public class MyThread extends Thread {

  @Override
  public void run() {
    String threadName = Thread.currentThread().getName();
    System.out.println("Thread 子线程 " + threadName + " 正在运行");
    for (int i = 0; i < 5; i++) {
      System.out.printf("Thread 子线程 %s 正在运行 %d\n", threadName, i);
    }
  }
}
