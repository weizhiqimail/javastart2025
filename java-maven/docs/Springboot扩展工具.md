# Springboot扩展工具

## 日志工具
- JUL(Java Util Logging)，官方提供，配置简单，性能差，不够灵活。
- Log4j，Apache提供，功能强大，配置灵活，支持多种输出目标。
- Logback，基于Log4j，性能更好，配置灵活，性能优于Log4j。
- Slf4j(Simple Logging Facade for Java)，简单易用，支持多种日志框架的适配器，提供统一的API。

### logback
- 准备工作，引入logback的依赖（springboot项目中该依赖已传递），配置文件 logback.xml
- 记录日志，定义日志对象Logger，记录日志。
  - 可以在 class 里使用 ` private static final Logger log = LoggerFactory.getLogger(LogbackTest.class);`
  - 或者直接使用注解 `@Slf4j`，在类上使用，自动生成日志对象。得到 `log` 对象。

```xml
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.4.11</version>
</dependency>
```

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {
  private static final Logger log = LoggerFactory.getLogger(LogbackTest.class);
  
  public void testLog() {
    logger.debug("Debug message");
    logger.info("Info message");
    logger.warn("Warn message");
    logger.error("Error message");
  }
}
```

### 日志级别
- TRACE：跟踪信息，最详细的日志级别，通常用于调试。
- DEBUG：调试信息，通常用于开发和调试阶段。
- INFO：普通信息，表示系统正常运行的状态。
- WARN：警告信息，表示可能存在问题，但不影响系统运行。
- ERROR：错误信息，表示系统出现异常或错误。

