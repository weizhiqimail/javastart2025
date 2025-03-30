package org.dazi.tliasjava21.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dazi.tliasjava21.pojo.Dept;
import org.dazi.tliasjava21.pojo.Expr;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpWithDeptAndExpr {
  private int id;
  private String username;
  private String name;
  private String job;
  private double salary;
  private String entryDate;
  // 员工所属部门
  private String deptName;
  // 员工的工作经历
  private List<Expr> exprList;
}
