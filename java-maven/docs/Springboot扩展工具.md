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
- Filter 处理全局业务，可修改 req 和 res，传递到下一个 filter。会拦截所有资源，包括静态动态资源。
- Interceptor 处理与业务逻辑相关的任务，用于补充业务逻辑，不能修改 req 和 res。只会拦截spring里的资源，即 controller 里的资源。


## AOP

- 连接点：`JoinPoint`，可以被 AOP 控制的方法，暗含方法执行时的相关信息。
- 通知：`Advice`，指那些重复的逻辑，也就是共性的功能，最终体现为一个方法。
  - `@Around`：环绕通知，此注解标注的方法在目标方法前、后都执行。
    - 需要自己调用 `proceed()` 方法，表示执行目标方法，其他的四个方法不用调用。
  - `@Before`：前置通知，此注解标注的方法在目标方法执行前执行
  - `@After`：后置通知，此注解标注的方法在目标方法执行后执行
  - `@AfterReturning`：返回通知，此注解标注的方法在目标方法执行后执行，有异常不执行
  - `@AfterThrowing`：异常后通知，此注解标注的方法在目标方法异常后执行
  - 当多个切面的切入点都匹配到了目标方法，目标方法运行时，多个通知方法都会被执行。
    - 执行顺序：
      - 不同切面类中，默认按照切面类的类名字母排序。
      - 目标方法前的通知方法，字母排名靠前的先执行。
      - 目标方法后的通知方法，字母排名靠前的后执行。
    - 用 `@Order` 注解可以指定切面的优先级，数字越小优先级越高。
      - 目标方法前的通知方法，数字小的先执行。
      - 目标方法后的通知方法，数字小的后执行。
- 切入点表达式 `@annotation`，用于匹配标识有特定注解的方法。
- 切入点：`Pointcut`，匹配连接点的条件，通知仅会在切入点方法执行时被应用。
  - 定义一个方法，加上 `@Pointcut` 注解，方法体为空，方法名就是切入点表达式。
- 切面：`Aspect`，描述通知与切入点的对应关系。（通知+切入面）。
- 目标对象：`Target`，通知所应用的对象。

```java
package org.dazi.tliasjava21.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@Aspect
public class RecordTimeAspect {

  // 切入点表达式
  @Pointcut("execution(* org.dazi.tliasjava21.service.*.*(..))")
  public void pointcut() {}

  @Around("pointcut()")
  public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
    long beginTime = System.currentTimeMillis();
    Object result = joinPoint.proceed();
    long endTime = System.currentTimeMillis();
    log.info("RecordTimeAspect {} recordTime: {}" , joinPoint.getSignature(), (endTime - beginTime));
    return result;
  }
}

```


