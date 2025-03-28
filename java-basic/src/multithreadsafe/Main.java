package multithreadsafe;

public class Main {

  public static void main(String[] args) {
    // 创建一个账户对象
    Account account = new Account("ICBC-0001", 100000);

    // 创建两个线程对象
    new DrawThread("小明", account).start();
    new DrawThread("小红", account).start();

  }
}
