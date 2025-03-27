package multithreadpractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

  public static void main(String[] args) {
    // 1. 拿到200个红包
    List<Integer> redPackets = getRedPackets();

    // 2. 定义线程类，创建100个线程，竞争同一个集合
    for (int i = 0; i < 100; i++) {
      GetRedPacketThread thread = new GetRedPacketThread(redPackets, i);
      thread.start();
    }

  }

  // 准备200个随机红包返回，每一个红包在10-30元之间
  public static List<Integer> getRedPackets() {
    List<Integer> redPackets = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < 200; i++) {
      int redPacket = random.nextInt(21) + 10; // 10-30元
      redPackets.add(redPacket);
    }
    return redPackets;
  }

}

class GetRedPacketThread extends Thread {
  private final List<Integer> redPackets;

  public GetRedPacketThread(List<Integer> redPackets, int num) {
    super("【线程" + num + "】");
    this.redPackets = redPackets;
  }

  @Override
  public void run() {
    String threadName = Thread.currentThread().getName();
    while (true) {
      synchronized (redPackets) {
        if (redPackets.isEmpty()) {
          break;
        }

        int index = (int) (Math.random() * redPackets.size());
        Integer money = redPackets.remove(index);
        System.out.println(threadName + "抢到红包，金额为：" + money);

        if(redPackets.isEmpty()) {
          System.out.println(threadName + "活动结束，红包抢完了");
          break;
        }
      }
    }
  }
}
