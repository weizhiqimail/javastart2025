public class Human implements Cloneable {

  public int id;

  public Human(int id) {
    this.id = id;
  }


  public void setId(int id) {
    this.id = id;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }


}
