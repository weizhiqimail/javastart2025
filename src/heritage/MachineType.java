package heritage;

public enum MachineType {

  DESKTOP("DESKTOP", 1),
  LAPTOP("LAPTOP", 2),
  SERVER("SERVER", 3),
  PHONE("PHONE", 4);

  private final String code;
  private final int id;

  MachineType(String code, int id) {
    this.code = code;
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public int getId() {
    return id;
  }

}
