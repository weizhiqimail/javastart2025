# 控制反转、依赖注入

- 控制反转（Inversion of Control，IoC）简称 IOC，对象的创建控制权由程序自身转移到外部容器，
  由外部容器来控制对象的创建和生命周期管理。**容器控制对象**。

- 依赖注入（Dependency Injection，DI）是实现控制反转的一种方式，容器为应用程序提供运行时所依赖的资源，称为依赖注入。
  - 依赖注入的方式有三种：构造器注入、属性注入和方法注入。**容器为对象提供一切所需的东西**。
- Bean 对象，IOC 容器中创建、管理的对象，称之为 Bean。

---

- 将 DAO 和 Service 的实现类，交给 IOC 容器管理。
- 为 Controller 及 Service 注入运行时所依赖的对象。

---

- 通过 `@Component` 将一个类交给 IOC 容器。
- 通过 `@Autowired` 从 IOC 容器里找到该类型的 bean。

# IOC 详解
- 要将某一个类交给 IOC 容器管理，必须在类上添加 `@Component` 注解。
- `@Controller` `@Service` `@Repository` 都是 `@Component` 的衍生注解。
- `@Controller` 用于标识控制器类，通常用于 MVC 模式中的控制器。
- `@Service` 用于标识服务类，通常用于业务逻辑处理。
- `@Repository` 用于标识持久层类，通常用于数据访问层。与 mybatis 整合使用。

---

- 声明 bean 的四个注解，想要生效，还需要被组件扫描注解 `@ComponentScan` 扫描。
- 该注解虽然没有显示配置，但是实际上已经包含在了启动类声明注解 `@SpringBootApplication` 中，默认扫描的范围时启动类所在包及其子包。

# DI 详解

- 依赖注入的方式有三种：属性注入、构造器注入和 setter 方法注入。
- 属性注入：方便简洁，隐藏了类之间的依赖关系，可能会破坏类的封装性。底层通过反射实现。
- 构造器注入：清晰看到类的依赖关系，提高代码安全性。代码繁琐，构造参数过多时不易维护。
  - 如果只有一个构造函数，那么构造器注入时的 `@Autowired` 可以省略。
- setter 方法注入：保持了类的封装性，依赖关系清晰，额外编写 setter 方法，增加代码量。

```java
@RestController
public class UserController {
  // 属性注入
  @Autowired
  private UserService userService;
  
  // 构造器注入
  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }
  
  // 方法注入
  @Autowired
  private void setUserService(UserService userService) {
    this.userService = userService;
  }
  
}
```

---

- `@Autowired` 默认是 **按照类型注入** 的，如果有多个同类型的 bean，可以： 
  - 方案1：使用 `@Primary` 注解，指定一个 bean 为首选项，提升某一个类的优先级。
  - 方案2：使用 `@Autowired` + `@Qualifier` 注解，指定 bean 的名称。
  - 方案3：使用 `@Resource` 注解，指定 bean 的名称。javaEE 规范提供，按照名称注入。
- 由于是 **按照类型注入**，所以一个类型可以有多个类，`@Autowired` 只能区分类型，所以在使用的时候，要用 `@Primary`、`@Autowired` + `@Qualifier`、`@Resource` 来指定使用的是哪一个类，以确保依赖注入的时候，会找到正确的类。

