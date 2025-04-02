# Maven 高级使用

## 继承

- 两个工程间的关系，与 java 的继承类似，子工程可以继承父工程中的配置信息，常用于依赖的继承。
- 实现：`<parent>` 标签

- 打包
  - jar：普通模块打包，springboot 项目基本都是 jar 包，内嵌 tomcat 运行
  - war：web 程序打包，需要部署在 tomcat 上运行
  - pom：父工程打包，pom 包不包含任何代码，只是一个配置文件，通常用于聚合多个模块的父工程

- 父工程，打包方式为 pom
- 子工程的 pom.xml 文件中，配置继承关系
- 在父工程中配置各个工程共有的依赖，子工程会自动继承父工程的依赖。
- 在子工程中，配置了继承关系，坐标中的 groupId 可以省略，因为会自动继承父工程的 groupId
- relativePath 指定父工程的 pom 文件的相对位置，如果不指定，将从本地仓库、远程仓库查找。
- 如果父子工程都配置了同一个依赖的不同版本，以子工程的为准。

## 自定义属性、引用属性

```xml
<properties>
    <lombok.version>1.8.30</lombok.version>
    <jjwt.version>1.1.1</jjwt.version>
</properties>
```
