package org.dazi.tliasjava21.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
  private long total;
  private List<T> data;

  public PageResult(long total, List<T> data) {
    this.total = total;
    this.data = data;
  }

}




