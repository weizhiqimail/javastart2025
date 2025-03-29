package org.dazi.tliasjava21.dao;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.time.LocalDateTime;
import java.time.LocalDate;

public class EmpQueryDto {

  @Schema(description = "员工ID")
  @Null()
  public Integer id;

  @Schema(description = "用户名，唯一")
  @Null()
  public String username;

  @Schema(description = "姓名")
  @Null()
  public String name;

  @Schema(description = "性别，0表示女，1表示男")
  @Null()
  public Byte gender;

  @Schema(description = "电话号码")
  @Null()
  public String phone;

  @Schema(description = "职位")
  @Null()
  public String job;

  @Schema(description = "薪资，精确到两位小数")
  @Null()
  public Double salary;

  @Schema(description = "部门ID，外键")
  @Null()
  public Integer deptId;

  @Schema(description = "分页大小")
  @Null()
  public Integer pageSize;

  @Schema(description = "当前页")
  @Null()
  public Integer pageNum;
}
