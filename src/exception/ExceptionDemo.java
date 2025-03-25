package exception;

public class ExceptionDemo {

  public static void main(String[] args) {
    try {
      int r = div(20, 0);
      System.out.println(r);
    }catch (Exception e) {
      e.printStackTrace();
      System.out.println("div 方法执行失败");
    }
  }

  public static int div(int a, int b) {
    if (b == 0) {
      throw new ArithmeticException("Division by zero");
    }
    return a / b;
  }

}
