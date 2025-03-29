package org.dazi.tliasjava21.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
  private Integer id;
  private String name;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
}
