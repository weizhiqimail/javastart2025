package cardemo;

public class GoldCard extends Card {

 public GoldCard(String cardNumber, String username, String number, double price) {
  super(cardNumber, username, number, price);
 }

  @Override
  public void cost(double currentCostMoney) {
    System.out.println("金卡消费折扣前金额：" + currentCostMoney + "元");
    double realCost = currentCostMoney * 0.8;
    System.out.println("金卡实际消费金额：" + realCost + "元");
    double restMoney = this.getMoney() - realCost;
    if (restMoney < 0) {
      System.out.println("余额不足，请充值...");
      return;
    }
    this.setMoney(this.getMoney() - restMoney);
    System.out.println("金卡剩余余额：" + restMoney);
    if (restMoney > 200) {
      System.out.println("消费大于200元，打印票据");
    } else {
      System.out.println("消费小于200元，不打印票据");
    }
  }
}
