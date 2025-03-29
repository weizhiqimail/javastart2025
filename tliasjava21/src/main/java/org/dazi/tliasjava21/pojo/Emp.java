package org.dazi.tliasjava21.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
  public Integer id;
  public String username;
  public String password;
  public String name;
  public Byte gender;
  public String phone;
  public String job;
  public Double salary;
  public LocalDate entryDate;
  public String image;
  public Integer deptId;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;

  private String deptName;
}
