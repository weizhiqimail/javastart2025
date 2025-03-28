package cardemo;


public class Card {
  private String cardNumber;

  private String username;

  private String phone;

  private double money;

  public Card(String cardNumber, String username, String phone, double money) {
    this.cardNumber = cardNumber;
    this.username = username;
    this.phone = phone;
    this.money = money;
  }

  public void deposit(double money) {
    this.setMoney(this.money + money);
  }

  public void cost(double money) {
    this.setMoney(this.money - money);
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }
}
