package abstractclass;

public class Coffee extends BeverageTemplate {

  @Override
  void brew() {
    System.out.println("冲泡咖啡");
  }

  @Override
  void addCondiments() {
    System.out.println("添加糖和牛奶");
  }


}
