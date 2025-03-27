package multithreadsafe;

public class DrawThread extends Thread {

  private Account account;

  public DrawThread(String name, Account account) {
    super(name);
    this.account = account;
  }

  @Override
  public void run() {
//    this.account.drawMoney(100000);
//    this.account.drawMoneySyncBlock(100000);
//    this.account.drawMoneySynchronized(100000);
    this.account.drawMoneyReentrantLock(100000);
  }
}
