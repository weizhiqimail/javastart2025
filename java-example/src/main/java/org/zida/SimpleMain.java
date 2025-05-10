package org.zida;

interface Chargeable {
  void charge();
}

abstract class Appliance {
  String brand;

  public Appliance() {
    System.out.println("Appliance 无参构造函数");
  }

  public Appliance(String brand) {
    this.brand = brand;
    System.out.println("Appliance 有参构造函数，品牌：" + brand);
  }

  public void turnOn() {
    System.out.println("Appliance 电器开启");
  }

  public abstract void operate();

}

class Computer extends Appliance implements Chargeable {
  static int computerCount = 0;

  final String type = "电子设备";

  public Computer() {
    super();
    computerCount++;
    System.out.println("Computer 无参构造函数");
  }

  public Computer(String brand) {
    super(brand);
    computerCount++;
    System.out.println("Computer 有参构造函数，品牌：" + brand);
  }

  public void charge() {
    System.out.println("Computer 正在充电...");
  }

  @Override
  public void operate() {
    System.out.println("Computer 正在运行程序");
  }

  public void installSoftware() {
    System.out.println("Computer 正在安装软件");
  }

  public void installSoftware(String softwareName) {
    System.out.println("Computer 正在安装软件，软件名字：" + softwareName);
  }
}

class Phone extends Appliance implements Chargeable {
  public Phone(String brand) {
    super(brand);
  }

  @Override
  public void charge() {
    System.out.println("Phone 正在充电...");
  }

  @Override
  public void operate() {
    System.out.println("Phone 正在运行");
  }

}

public class SimpleMain {
  public static void main(String[] args) {
    Computer c1 = new Computer("戴尔");
    c1.turnOn();
    c1.charge();
    c1.operate();
    c1.installSoftware();
    c1.installSoftware("浏览器");


    Phone p1 = new Phone("blackberry");
    p1.turnOn();
    p1.charge();
    p1.operate();
  }
}