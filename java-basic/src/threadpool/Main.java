package threadpool;

import java.util.concurrent.*;

public class Main {

  public static void main(String[] args) {
    createPoolWithExecutors();
  }

  // 使用 Callable 创建线程池
  public static void createPoolWithCallable() {
    // 1. 使用线程池的实现类创建线程池，声明7个参数
    ExecutorService executorService = new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    // 2. 使用线程池处理任务
    // 提交第1个任务，创建线程，自动启动线程处理任务
    Future<String> future1 = executorService.submit(new MyCallable(100));
    // 提交第2个任务
    Future<String> future2 = executorService.submit(new MyCallable(200));
    // 提交第3个任务
    Future<String> future3 = executorService.submit(new MyCallable(300));
    // 提交第4个任务，线程池不会死亡，会继续使用前边的3个线程【任务队列】
    Future<String> future4 = executorService.submit(new MyCallable(400));


    try {
      System.out.println(future1.get());
      System.out.println(future2.get());
      System.out.println(future3.get());
      System.out.println(future4.get());
      executorService.shutdown();
      System.out.println("线程池已关闭");
    } catch (InterruptedException | ExecutionException e) {
      throw new RuntimeException(e);
    }
  }

  // 使用 Runnable 创建线程池
  public static void createPoolWithRunnable() {
    // 1. 使用线程池的实现类创建线程池，声明7个参数
    ExecutorService executorService = new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    // 2. 使用线程池处理任务
    Runnable target = new MyRunnable();
    // 提交第1个任务，创建线程，自动启动线程处理任务
    executorService.execute(target);
    // 提交第2个任务
    executorService.execute(target);
    // 提交第3个任务
    executorService.execute(target);
    // 提交第4个任务，线程池不会死亡，会继续使用前边的3个线程【任务队列】
    executorService.execute(target);
    // 提交第5个任务【任务队列】
    executorService.execute(target);
    // 提交第6个任务【任务队列】此时三个核心线程在忙，任务队列已满
    executorService.execute(target);
    // 临时线程1
    executorService.execute(target);
    // 临时线程2
    executorService.execute(target);
    // 此时三个核心线程在忙，任务队列已满，临时线程也满了
    executorService.execute(target);

    // 关闭线程池
    executorService.shutdown();// 等所有任务结束后，再关闭线程池
//    executorService.shutdownNow();// 直接关闭所有线程池，不等待任何线程
    System.out.println("关闭线程池");

  }

  // 使用 Executors 创建线程池
  public static void createPoolWithExecutors() {
    // 1. 使用 Executors 创建线程池
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    // 2. 使用线程池处理任务
    // 提交第1个任务，创建线程，自动启动线程处理任务
    Future<String> future1 = executorService.submit(new MyCallable(100));
    // 提交第2个任务
    Future<String> future2 = executorService.submit(new MyCallable(200));
    // 提交第3个任务
    Future<String> future3 = executorService.submit(new MyCallable(300));
    // 提交第4个任务，线程池不会死亡，会继续使用前边的3个线程【任务队列】
    Future<String> future4 = executorService.submit(new MyCallable(400));

    try {
      System.out.println(future1.get());
      System.out.println(future2.get());
      System.out.println(future3.get());
      System.out.println(future4.get());
      executorService.shutdown();
      System.out.println("线程池已关闭");
    } catch (InterruptedException | ExecutionException e) {
      throw new RuntimeException(e);
    }

  }
}
