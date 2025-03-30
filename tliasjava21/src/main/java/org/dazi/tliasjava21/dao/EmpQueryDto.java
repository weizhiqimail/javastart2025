package org.dazi.tliasjava21.dao;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.LocalDate;

@Data
public class EmpQueryDto {

  @Schema(description = "用户名，唯一")
  public String username;

  @Schema(description = "姓名")
  public String name;

  @Schema(description = "性别，0表示女，1表示男")
  public Byte gender;

  @Schema(description = "入职开始日期")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  public LocalDate startDate;

  @Schema(description = "入职结束日期")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  public LocalDate endDate;

  @Schema(description = "分页大小")
  public Integer pageSize;

  @Schema(description = "当前页")
  public Integer pageNum;
}
