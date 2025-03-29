package org.dazi.tliasjava21.pojo;

import lombok.Data;

@Data
public class Result {
  // 状态码：1成功，0失败
  private Integer code;

  private String msg;

  private Object data;

  public static Result success() {
    Result result = new Result();
    result.setCode(1);
    result.setMsg("success");
    return result;
  }

  public static Result success(Object data) {
    Result result = success();
    result.setData(data);
    return result;
  }

  public static Result error(String msg) {
    Result result = new Result();
    result.setCode(0);
    result.setMsg(msg);
    return result;
  }
}
