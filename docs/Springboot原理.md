# 原理篇

## Springboot 核心 - 起步依赖

**各种 starter**

- spring-boot-starter-parent，父级 pom，提供了默认的依赖版本。
- spring-boot-starter-web，web 相关的依赖。
- spring-boot-starter-data-jpa，JPA 相关的依赖。
- spring-boot-starter-security，安全相关的依赖。
- spring-boot-starter-test，测试相关的依赖。
- spring-boot-starter-actuator，监控相关的依赖。
- spring-boot-starter-cache，缓存相关的依赖。
- spring-boot-starter-aop，AOP 相关的依赖。
- spring-boot-starter-logging，日志相关的依赖。
- spring-boot-starter-validation，数据校验相关的依赖。
- spring-boot-starter-websocket，websocket 相关的依赖。
- spring-boot-starter-mybatis，mybatis 相关的依赖。
- spring-boot-starter-jdbc，jdbc 相关的依赖。

## 【重要】Springboot 核心 - 自动配置

- 自动配置是当 Spring 项目启动后，一些配置类、bean 对象就自动存入到 IOC 容器中，不需要手动声明，从而简化了开发，省去繁琐的配置操作。
- 启动类具备组件扫描功能，，但是扫描的启动类所在包及子包。

### 导入包的方式

- 1、使用 `@ComponentScan`
  - 如果启动类扫描的不能够满足需要，那么就要使用 `@ComponentScan` 注解来指定扫描的包。但是导入太多，性能就差。
  - 如果添加了新的包，那么默认的就不生效了，所以要手动引入
    - `@ComponentScan(basePackages = {"com.example", "org.dazi"})`
- 使用 `@Import`，会被 spring 加载到 IOC 里，导入形式有
  - 2、导入 普通类、配置类
  - 3、导入 ImportSelector 接口实现类。在 new String 里导入多个数组。
- 4、使用 `@EnableHeaderConfig` 注解

```java

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;

@SpringBootApplication
// 1：使用 @ComponentScan 注解
@ComponentScan(basePackages = {"com.example", "org.dazi"})
// 2：使用 @Import 注解导入普通类、配置类
@Import({MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
// 3：使用 @Import 注解导入 ImportSelector 接口实现类
@Import(MyImportSelector.class)
// 4：使用 EnableHeaderConfig 注解，底层使用的也是 @Import 注解
@EnableHeaderConfig
public class JavaSpringbootApplication {

  public static void main(String[] args) {
    SpringApplication.run(JavaSpringbootApplication.class, args);
  }

}

// 使用 ImportSelector 接口
public class MyImportSelector implements ImportSelector {

  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    return new String[]{"com.example.MyBean"};
  }
}

// 使用 EnableHeaderConfig 注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MyImportSelector.class)
public @interface EnableHeaderConfig {

}
```

### 自动配置 - 源码跟踪 - 底层原理

#### 自动配置原理
- 自动配置，是在 `spring-boot-autoconfigure-3.4.4.jar` 这个 jar 包里，已经准备好了一系列的自动配置类，放在 `META-INF/spring.factories` 里。
- 在项目启动的时候，在 `AutoConfigurationImportSelector` 的 `getAutoConfigurationEntry` 方法里，调用 `getCandidateConfigurations` 方法，执行 `List<String> configurations = importCandidates.getCandidates();` 这段代码，调用 `ImportCandidates`类的 `getCandidates` 方法，获取到所有的自动配置类。
- 在 `ImportCandidates` 类里，已经硬编码写死了一个变量值 `private static final String LOCATION = "META-INF/spring/%s.imports";` 用来标记自动配置类的路径。
- 自动配置导入文件路径 `spring-boot-autoconfigure-3.4.4.jar!\META-INF\spring\org.springframework.boot.autoconfigure.AutoConfiguration.imports`。
- **配置文件里的所有的类，不一定全部都导入 IOC**，会有一个 `Conditional` 的注解，在满足给定条件后，才会注册对应的 bean 对象到 IOC 容器中。可用于 `class` 和 方法。
  - `@Conditional` 是一个父注解，派生出大量的子注解。
  - `@ConditionalOnClass(XXX.class)`，判断环境中是否有 `XXX` 的字节码文件，如果有就注册 bean。
  - `@ConditionalOnMissingClass`，判断环境中没有对应的 bean，才注册 bean。
  - `@ConditionalOnProperty`，判断 `application.properties.yml` 配置文件中是否有对应属性和值，如果有就注册 bean。

```java
@AutoConfiguration
@ConditionalOnClass(Gson.class)
@EnableConfigurationProperties(GsonProperties.class)
public class GsonAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public Gson gson(GsonBuilder gsonBuilder) {
    return gsonBuilder.create();
  }
}
```


#### 代码继承逻辑

- 入口，启动类 `class JavaSpringbootApplication`

```java
@SpringBootApplication
public class JavaSpringbootApplication {
  public static void main(String[] args) {
    SpringApplication.run(JavaSpringbootApplication.class, args);
  }
}
```

- `@SpringBootApplication`

```java
// 上边的 4 个是元注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
// 用来标识 Spring Boot 的配置类
@SpringBootConfiguration  
// 用来开启自动配置，底层是 @Import(AutoConfigurationImportSelector.class)
@EnableAutoConfiguration  
// 扫描当前类所在包及子包
@ComponentScan(excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
		@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })

public @interface SpringBootApplication {
  
}
```

- `@SpringBootConfiguration`

```java
@Configuration
@Indexed
public @interface SpringBootConfiguration { }
```

- `@EnableAutoConfiguration`
  - `@Import(AutoConfigurationImportSelector.class)`
    - `public class AutoConfigurationImportSelector implements DeferredImportSelector {}`
      - `public interface DeferredImportSelector extends ImportSelector {}`

```java
@Inherited
@AutoConfigurationPackage
@Import(AutoConfigurationImportSelector.class)
public @interface EnableAutoConfiguration { }


// 重点在这里的 String[] 里，这里是所有导入的配置项
public class AutoConfigurationImportSelector implements DeferredImportSelector {
  @Override
  public String[] selectImports(AnnotationMetadata annotationMetadata) {
    if (!isEnabled(annotationMetadata)) {
      return NO_IMPORTS;
    }
    AutoConfigurationEntry autoConfigurationEntry = getAutoConfigurationEntry(annotationMetadata);
    return StringUtils.toStringArray(autoConfigurationEntry.getConfigurations());
  }
}
```

- `@ComponentScan`

```java
@Documented
@Repeatable(ComponentScans.class)
public @interface ComponentScan { }
```

## 自定义 starter

- 自定义 starter 里，会定义一些公共组件，提供给各个项目团队使用。包含起步依赖和自动配置的功能。
- 以 MyBatis 为例，引入 `starter` 依赖即可。
  - Maven: org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3
  - Maven: org.mybatis.spring.boot:mybatis-spring-boot-autoconfigure:3.0.3

- 示例：创建 aliyun-oss-spring-boot-starter
  - 创建 aliyun-oss-spring-boot-starter 模块。
  - 创建 aliyun-oss-spring-boot-starter-autoconfigure 模块，在 starter 模块里引入该模块。
  - 在 aliyun-oss-spring-boot-autoconfigure 模块中的定义自动配置功能，并定义自动配置文件 `META-INF/spring/xxxx.imports`。



















