package org.dazi.tliasjava21.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expr {
  private int id;
  private int empId;
  private String companyName;
  private String job;
  private String startDate;
  private String endDate;
}
