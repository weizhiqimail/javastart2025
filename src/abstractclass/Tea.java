package abstractclass;

public class Tea extends BeverageTemplate {

  @Override
  void brew() {
    System.out.println("冲泡茶叶");
  }

  @Override
  void addCondiments() {
    System.out.println("添加柠檬");
  }
}
