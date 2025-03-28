package multithreaduse;

public class MyThread extends Thread {

  public MyThread() {
    super();
  }

  public MyThread(String threadName) {
    super(threadName);
  }

  @Override
  public void run() {
    String threadName = Thread.currentThread().getName();
    System.out.println("Thread " + threadName + " 开始运行");
    for (int i = 0; i < 5; i++) {
      System.out.printf("Thread %s 正在运行 %d\n", threadName, i);
      try {
        // 让当前的进程，休眠100ms。
        Thread.sleep(1000); // 休眠1秒
      } catch (InterruptedException e) {
        System.out.println("Thread " + threadName + " 被中断");
      }
    }
  }
}
