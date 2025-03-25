package codeblock;

interface Swim {
  void swimming();
}

public class Swimming {

  public static void main(String[] args) {
    Swim s1 = new Swim() {
      @Override
      public void swimming() {
        System.out.println("s1游泳");
      }
    };

    start(s1);

    start(new Swim() {
      @Override
      public void swimming() {
        System.out.println("s2游泳");
      }
    });

  }

  public static void start(Swim s) {
    System.out.println("开始...");
    s.swimming();
    System.out.println("结束...");
  }

}
