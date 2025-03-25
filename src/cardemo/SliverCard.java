package cardemo;

public class SliverCard extends Card {
  public SliverCard(String cardNumber, String username, String phone, double money) {
    super(cardNumber, username, phone, money);
  }

  @Override
  public void cost(double money) {
    System.out.println("银卡实际消费金额：" + money + "元");
    double restMoney = this.getMoney() - money;
    if (restMoney < 0) {
      System.out.println("余额不足，请充值...");
      return;
    }
    this.setMoney(this.getMoney() - restMoney);
    System.out.println("银卡剩余余额：" + restMoney);
  }

}
