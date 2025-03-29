# MyBatis基础使用

## 介绍
- MyBatis是一个优秀的持久层框架，它支持定制化SQL、存储过程以及高级映射。用于简化 JDBC 操作。

## Spring 里的 MyBatis
- 在 application.properties 里配置数据库连接信息

### 数据库连接池

- 数据库连接池是一个容器，负责分配、管理数据库连接 Connection。
- 它允许应用程序重复使用一个现有的数据库连接，而不是再新建一个。
- 释放空闲时间超过最大空闲时间的连接，来避免因为没有释放连接而引起数据库连接遗漏。

### 数据库连接池优势

- 资源重用
- 提升系统相应速度
- 避免数据库连接遗漏

### 标准接口：DataSource
- 
- Sun 提供的数据库连接池接口，由第三方组织实现此接口。
- 功能：获取连接 `Connection getConnection() throws SQLException;`
- Springboot 默认使用 HikariCP 作为数据库连接池
- 还可以使用 Druid 作为数据库连接池，如果使用 Druid 作为数据库连接池，需要在 pom.xml 中添加 Druid 依赖，同时修改 application.properties 中的配置 `spring.datasource.type=com.alibaba.druid.pool.DruidDataSource`
- `@Param` 注解，用于传递多个参数。在 Springboot 官方的脚手架里，不需要使用 `@Param` 注解，Springboot 会自动将参数传递到 SQL 语句中。

## XML 映射配置

- 在 MyBatis 中，可以通过注解配置 SQL 语句，也可以通过 XML 映射配置 SQL 语句。
- 默认规则
  - XML 映射文件的名称与 Mapper 接口的名称相同，可以将 XML 映射文件和 Mapper 接口放在同一个包下。
  - XML 映射文件的 namespace 属性为 Mapper 接口的全限定名一致。
  - XML 映射文件的 id 与 Mapper 接口的方法名一致，并保持返回类型一致。
- XML 文件位置，要与 Mapper 接口放在同一个包下，或者在 resources 目录下的 mapper 目录下。
- 自定义配置 XML 映射文件的位置：`mytbatis.mapper-locations=classpath:mapper/*.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="org.dazi.javaspringboot.mapper.UserMapper">
    <select id="findAllUsers" resultType="org.dazi.javaspringboot.pojo.User">
        select id, name, age, gender, phone, email from hero
    </select>
</mapper>
```

## 数据封装
- 手动结果映射：通过 `@Result` 及 `@Results` 进行手动结果映射。
- 起别名：在SQL中，对不一样的列名起别名，别名与实体类属性名一致。
- 开启驼峰命名配置：如果字段名与属性名符合驼峰命名规则，mybatis 会自动进行映射。

```java
@Mapper
public interface DeptMapper {

  // 方式1：手动结果映射
  @Results({
          @Result(column = "create_time", property = "createTime"),
          @Result(column = "update_time", property = "updateTime"),
  })
  // 方式2：起别名
  @Select("select id, name, create_time createTime, update_time updateTime from dept")
  public List<Dept> getDeptList();
}
```

