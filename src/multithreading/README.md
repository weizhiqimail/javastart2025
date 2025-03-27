# 多线程

- 线程是第一个程序内部的一条执行流程。
- 多线程是指从软硬件上实现的多条执行流程的技术。（多条线程由CPU负责执行调度）
- 创建多线程
  - 【常用】继承 Thread 类
    - 编码简单
    - 启用必须使用 start() 方法。如果调用了 run() 方法，就被认为是一个普通的类，与线程无关。
    - 不支持多继承，线程类已经继承了 Thread，无法继承其他的类。
  - 【常用】实现 Runnable 接口
    - 任务类只是实现接口，可以继承其他类，实现其他接口，扩展性强
    - 需要多一个 Runnable 对象来启动线程
  - 【不常用】基于 Runnable 创建匿名内部类
    - 可以创建 Runnable 的匿名内部类对象
    - 交给 Thread 线程对象
    - 调用 start() 方法启动线程
  - 【常用】基于 Callable 接口，使用 FutureTask
    - 【Thread】【Runnable】的问题在于，假如线程执行完毕后，有一些数据需要返回，run() 方法不能直接返回结果。
    - 步骤
      - 定义一个类实现 Callable 接口，重写 call() 方法，封装方法，返回数据。
      - 创建一个 FutureTask 对象，传入 Callable 对象
      - 创建一个 Thread 对象，传入 FutureTask 对象
      - 调用 start() 方法启动线程
      - 调用 FutureTask 对象的 get() 方法获取线程执行结果
      - 注意：get() 方法是阻塞的，直到线程执行完毕才会返回结果
      - 注意：Callable 接口的 call() 方法可以抛出异常，run() 方法不能抛出异常

```java
public class MyThread extends Thread {
  @Override
  public void run() {
    System.out.println("线程 " + Thread.currentThread().getName() + " 正在执行");
  }
}

public class MyRunnable implements Runnable {
  @Override
  public void run() {
    System.out.println("线程 " + Thread.currentThread().getName() + " 正在运行");
  }
}

public class MyAnonymousRunnable {
  public static void main(String[] args) {
    // 继承 Thread 类创建线程
    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("线程 " + Thread.currentThread().getName() + " 正在运行");
      }
    }).start();

    // 使用 Lambda 表达式创建线程
    new Thread(() -> System.out.println("线程 " + Thread.currentThread().getName() + " 正在运行")).start();
    
  }
}

```

# 多线程安全
- 多个线程，同时操作一个资源，可能会导致数据的错误和不一致。
- 线程安全是指多个线程同时访问同一个资源时，能够保证数据的正确性和一致性。
- 线程同步是线程安全的解决方案
  - 解决方式：加锁，每次只允许一个线程加锁，加锁后才能进入访问，访问完毕后自动解锁，然后其他线程才能再加锁进入访问。
  - 方式1：同步代码块，对比同步方法，性能上几乎无差异
    - 作用：把访问共享资源的核心代码上锁，依次保证线程安全。
    - 原理：每次只允许一个线程加锁后进入，执行完毕后自动解锁，其他线程才可以进来执行。
    - 注意：对于当前同时执行的线程来说，同步锁必须是同一把（同一个对象），否则会出现bug。
    - 锁对象，随便使用一个唯一的随便不好，会影响其他无关线程的执行
    - 规范：建议使用共享资源作为锁对象，
      - 对于实例方法建议使用 this 作为锁对象，
      - 对于静态方法建议使用字节码（类名.class）作为锁对象。
        - `public class M { public static void m() { synchronized (M.class) { } } }`
  - 方式2：同步方法
    - 作用：把访问共享资源的核心代码上锁，依次保证线程安全。
      - `public synchronized void m() { 操作共享资源代码 }`
    - 特点：代码简洁，清晰可读
  - 方式3：使用 lock 锁
    - lock 锁可以创建出锁对象进行加锁和解锁，更灵活、方便、强大。
    - lock 是接口，不能直接实例化，可以采用他的实现类 `ReentrantLock` 来构建 Lock 锁对象。
    - 使用 final 修饰，防止被修改 `private final Lock lock = new ReentrantLock();`
    - 建议将锁操作放在 finally 里，确保一定会被释放。
- 核心思想：让多个线程先后依次访问共享资源，可以避免出现线程安全问题。
- 创建临时线程
  - 新任务提交，发现现有核心任务都在处理任务，且任务队列已满，并且可以创建临时线程，此时才会创建临时线程。
- 拒绝临时线程
  - 核心线程在处理任务，临时线程也在处理任务，且任务队列已满，并且不能创建临时线程，此时会拒绝新任务的提交。

# 进程

- 正在运行的程序（软件）就是一个独立的进程。
- 线程属于进程，一个进程中可以由多个线程。
- 进程中的多个线程是并发和并行执行的。
- 进程中的线程由CPU负责调度执行，但是CPU能够同时处理的线程数量悠闲，为了保证全部线程都能够执行，CPU会轮询位系统的每个线程服务，由于CPU切换的速度很快，给人的感觉是在同时进行，这就是并发。
