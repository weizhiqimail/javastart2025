package abstractclass;

// 模板方法设计模式：提供一个方法作为完成某类功能的目标那，模板方法封装了每一个实现步骤，但允许子类提供特定步骤的实现。
// 模板方法设计可以：提高代码服用，简化子类设计

public abstract class BeverageTemplate {

  public final void prepareBeverage() {
    boilWater();
    brew();
    pourInCup();
    addCondiments();
  }


  private void boilWater() {
    System.out.println("烧水");
  }

  // 冲泡
  abstract void brew();

  private void pourInCup() {
    System.out.println("倒入杯子");
  }

  abstract void addCondiments();

}
