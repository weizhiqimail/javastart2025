# Springboot扩展工具

## 日志工具
- JUL(Java Util Logging)，官方提供，配置简单，性能差，不够灵活。
- Log4j，Apache提供，功能强大，配置灵活，支持多种输出目标。
- Logback，基于Log4j，性能更好，配置灵活，性能优于Log4j。
- Slf4j(Simple Logging Facade for Java)，简单易用，支持多种日志框架的适配器，提供统一的API。

### logback
- 准备工作，引入logback的依赖（springboot项目中该依赖已传递），配置文件 logback.xml
- 记录日志，定义日志对象Logger，记录日志。
  - 可以在 class 里使用 `private static final Logger log = LoggerFactory.getLogger(LogbackTest.class);`
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

## Filter
- 需要给启动类添加 `@ServletComponentScan`

```java
package org.dazi.tliasjava21.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/session/*")
public class TokenFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    Filter.super.init(filterConfig);
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    // 获取请求路径
    String requestURI = request.getRequestURI();
    // 获取请求方法
    String method = request.getMethod();

    // 获取请求头中的 authorization
    String authorization = request.getHeader("authorization");

    // 如果 authorization 不存在，返回错误 401
    if (authorization == null || authorization.isEmpty()) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }

    // 如果 authorization 存在，校验 authorization 是否有效，如果有效则放行，如果无效则返回错误 401

    // 处理无效逻辑

    // 有效逻辑
    chain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {
    Filter.super.destroy();
  }
}

```

## Interceptor

### 定义拦截器

- 需要给启动类添加 `@EnableWebMvc`，或者在配置类上添加 `@EnableWebMvc`

```java
package org.dazi.tliasjava21.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TestInterceptor implements HandlerInterceptor {


  // 目标资源方法执行前执行，放行 true，不放行 false
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    return HandlerInterceptor.super.preHandle(request, response, handler);
  }

  // 目标资源方法执行后执行
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }

  // 试图渲染完毕后实行，最后执行。一般采用前后端分离的架构，这一步可以忽略
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
  }
}

```

### 配置拦截器

```java
package org.dazi.tliasjava21.config;

import org.dazi.tliasjava21.interceptor.TestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Autowired
  private TestInterceptor testInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    WebMvcConfigurer.super.addInterceptors(registry);
    registry.addInterceptor(testInterceptor).addPathPatterns("/**");
  }
}
```

## Filter 和 Interceptor 对比
- Filter 优先执行 doFilter，再进入到 Interceptor 的拦截器。
- Filter 处理全局业务，可修改 req 和 res，传递到下一个 filter
- Interceptor 处理与业务逻辑相关的任务，用于补充业务逻辑，不能修改 req 和 res





