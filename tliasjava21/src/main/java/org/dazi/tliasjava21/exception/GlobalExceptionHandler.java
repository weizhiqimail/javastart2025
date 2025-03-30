package org.dazi.tliasjava21.exception;

import lombok.extern.slf4j.Slf4j;
import org.dazi.tliasjava21.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler
  public Result handleException(Exception e) {
    String message = e.getMessage();
    return Result.error(message == null ? "服务异常，请稍后重试" :  message );
  }
}
