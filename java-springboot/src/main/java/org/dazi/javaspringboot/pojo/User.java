package org.dazi.javaspringboot.pojo;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private Integer id;
  private String name;
  private String gender;
  private Integer age;
  private String email;
  private String phone;
}
