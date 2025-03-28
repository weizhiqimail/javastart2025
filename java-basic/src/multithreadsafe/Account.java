package multithreadsafe;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

  private String cardId;
  public double money;

  private final Lock lock = new ReentrantLock();

  /**
   * 这是一个模拟出现的线程安全问题的方法
   * <p>
   * ---------------控制台输出结果---------------
   * <p>
   * 当前线程 小红
   * 当前线程 小明
   * 当前线程 小红 取款成功，取款金额：100000.0元
   * 当前线程 小明 取款成功，取款金额：100000.0元
   * 当前线程 小红 当前余额为：0.0元
   * 当前线程 小明 当前余额为：-100000.0元
   */
  public void drawMoney(double money) {
    // 获取当前线程的名称
    String threadName = Thread.currentThread().getName();
    // 打印当前线程的名称
    String threadNamePrefix = "当前线程 " + threadName + " ";
    System.out.println(threadNamePrefix);
    if (this.money >= money) {
      // 打印取款成功的信息
      System.out.println(threadNamePrefix + "取款成功，取款金额：" + money + "元");
      this.setMoney(this.getMoney() - money);
    } else {
      // 打印取款失败的信息
      System.out.println(threadNamePrefix + "取款失败，余额不足");
    }
    System.out.println(threadNamePrefix + "当前余额为：" + this.getMoney() + "元");


  }

  // 使用【同步代码块】解决线程安全问题
  public void drawMoneySyncBlock(double money) {
    // 获取当前线程的名称
    String threadName = Thread.currentThread().getName();
    // 打印当前线程的名称
    String threadNamePrefix = "当前线程 " + threadName + " ";
    System.out.println(threadNamePrefix);
    // 这里的 `synchronized()` 里的参数，必须是一个不可变的对象，不能是 new Object()；
    // 使用最普通的常量，会影响其他用户使用 account 的操作，比如使用"sync"
    // 所以可以使用 this 关键字，表示当前对象的引用
    synchronized (this) {
      if (this.money >= money) {
        // 打印取款成功的信息
        System.out.println(threadNamePrefix + "取款成功，取款金额：" + money + "元");
        this.setMoney(this.getMoney() - money);
      } else {
        // 打印取款失败的信息
        System.out.println(threadNamePrefix + "取款失败，余额不足");
      }
      System.out.println(threadNamePrefix + "当前余额为：" + this.getMoney() + "元");
    }


  }

  // 使用【同步方法】解决线程安全问题
  public synchronized void drawMoneySynchronized(double money) {
    this.drawMoney(money);
  }

  // 使用【ReentrantLock】解决线程安全问题
  public void drawMoneyReentrantLock(double money) {
    // 获取当前线程的名称
    String threadName = Thread.currentThread().getName();
    // 打印当前线程的名称
    String threadNamePrefix = "当前线程 " + threadName + " ";
    System.out.println(threadNamePrefix);
    lock.lock();
    try {
      if (this.money >= money) {
        // 打印取款成功的信息
        System.out.println(threadNamePrefix + "取款成功，取款金额：" + money + "元");
        this.setMoney(this.getMoney() - money);
      } else {
        // 打印取款失败的信息
        System.out.println(threadNamePrefix + "取款失败，余额不足");
      }
      System.out.println(threadNamePrefix + "当前余额为：" + this.getMoney() + "元");
    } finally {
      lock.unlock();
    }
  }

}
