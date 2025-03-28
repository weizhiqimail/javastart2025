package singleinstance;

public class SingleInstanceUse {

  public static void main(String[] args) {
    SingleInstance1 st1 = SingleInstance1.singleInstance1;
    SingleInstance2 st2 = SingleInstance2.getInstance();

  }
}
