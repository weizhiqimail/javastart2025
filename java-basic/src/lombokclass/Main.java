package lombokclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Main {
  public static void main(String[] args) {
    User user = new User();
    user.setName("John");
    user.setAge(30);
    System.out.println(user.getName());
    System.out.println(user.getAge());
  }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class User {

  public String name;

  public int age;
}
