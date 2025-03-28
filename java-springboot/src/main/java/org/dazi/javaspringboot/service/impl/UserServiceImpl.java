package org.dazi.javaspringboot.service.impl;

import org.dazi.javaspringboot.User;
import org.dazi.javaspringboot.dao.UserDao;
import org.dazi.javaspringboot.dao.impl.UserDaoImpl;
import org.dazi.javaspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * @author wei
 */
@Component // 将当前类交给 IOC 容器处理
public class UserServiceImpl implements UserService {
  // 最基本的使用 OOP 形式创建对象
//  private final UserDao userDao = new UserDaoImpl();

  // 使用 Spring 的 DI 方式创建对象
  @Autowired // 应用程序运行时，会自动的查询该类型的 bean 对象，并赋值给该成员变量
  private UserDao userDao;


  @Override
  public List<User> findUserList() {
    // 调用 dao 获取数据
    List<String> lines = userDao.findUserList();

    return lines.stream().map(line -> {
      String[] arr = Arrays.stream(line.split(",")).map(String::trim).toArray(String[]::new);
      Integer id = Integer.parseInt(arr[0]);
      String name = arr[1];
      LocalDateTime dateTime = LocalDateTime.parse(arr[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
      return new User(id, name, dateTime);
    }).toList();
  }

}
