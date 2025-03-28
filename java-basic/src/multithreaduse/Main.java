package multithreaduse;


/**
 *
 */

public class Main {

  public static void main(String[] args) {
    MyThread2 thread2 = new MyThread2();
    thread2.start();

    Thread mainThread = Thread.currentThread();
    String mainThreadName = mainThread.getName();
    System.out.println("主线程 " + mainThreadName + " 开始运行");

    for (int i = 1; i <= 5; i++) {
      System.out.println("主线程 " + mainThreadName + " 正在运行 " + i);
      if (i == 2) {
        try {
          thread2.join();
        }catch (Exception e) {
          System.out.println("Thread " + mainThreadName + " 被中断");
          e.printStackTrace();
        }
      }
    }



  }

}




































