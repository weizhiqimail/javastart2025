package org.zida.javaservlet.home;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
  public int id;
  public String name;
  public int age;
  public String address;
  public String job;
}
