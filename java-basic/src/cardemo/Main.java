package cardemo;

import java.util.Scanner;

public class Main {

  public static void payment(Card card) {
    System.out.println("请输入本次消费金额");
    Scanner scanner = new Scanner(System.in);
    double money = scanner.nextDouble();
    card.cost(money);
  }

  public static void main(String[] args) {
    GoldCard goldCard = new GoldCard("A123456", "张三", "12345678901", 10000);
    payment(goldCard);
    SliverCard sliverCard = new SliverCard("A1234567", "李四", "12345678901", 20000);
    payment(sliverCard);
  }

}
