package heritage;

public class Worker {

  private String name;

  public Worker(String name) {
    this.name = name;
  }

  public void buyMachine() {
    Desktop desktop = new Desktop("Desktop", MachineType.DESKTOP, "Dell", 1000);
    System.out.println("Worker " + name + " bought a " + desktop.getName() + " " + desktop.getBrand() + " " + desktop.getType().getCode() + " for " + desktop.getPrice());
  }

  @Override
  public String toString() {
    return "Worker [name=" + name + "]";
  }


}
