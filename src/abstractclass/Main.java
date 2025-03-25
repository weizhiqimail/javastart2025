package abstractclass;

public class Main {

  public static void main(String[] args) {
    // 模板方法设计模式
    BeverageTemplate tea = new Tea();
    tea.prepareBeverage();

    System.out.println("===================================");

    BeverageTemplate coffee = new Coffee();
    coffee.prepareBeverage();

    System.out.println("===================================");

  }
}
