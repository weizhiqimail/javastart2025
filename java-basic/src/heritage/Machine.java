package heritage;

public class Machine {

  private String name;

  private MachineType type;

  private String brand;

  private double price;

  public Machine() {

  }

  public Machine(String name, MachineType type, String brand, double price) {
    this.name = name;
    this.type = type;
    this.brand = brand;
    this.price = price;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MachineType getType() {
    return type;
  }

  public void setType(MachineType type) {
    this.type = type;
  }


  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
