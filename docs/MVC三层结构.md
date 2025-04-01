## MVC三层结构

- 三层架构的流程
  - Http Request
  - Controller
    - 接收请求
    - 调用Service
    - 响应结果
  - Service
    - 使用 Mapper 接口
  - Mapper
    - DB 操作
  - Http Response

## 简单http参数获取
- 使用 HttpServletRequest 获取请求参数。
- 使用 @RequestParam 注解获取请求参数，使用后参数默认为必传。
- 参数名与形参变量名一致。

## 全局异常处理

```java
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
```

## ThreadLocal

- ThreadLocal 并不是一个 Thread，而是 Thread 的句局部变量。
- ThreadLocal 为每一个线程提供一份单独的存储空间，具有线程隔离的效果，不同的线程之间不会互相影响。
- ThreadLocal 常用方法
  - `public void set(T value)`：设置当前线程的值
  - `public T get()`：获取当前线程的值
  - `public void remove()`：删除当前线程的值

