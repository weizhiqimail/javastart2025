package org.dazi.javaspringboot.service.impl;

import org.dazi.javaspringboot.User;
import org.dazi.javaspringboot.dao.UserDao;
import org.dazi.javaspringboot.dao.impl.UserDaoImpl;
import org.dazi.javaspringboot.service.UserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * @author wei
 */
public class UserServiceImpl implements UserService {

  private final UserDao userDao = new UserDaoImpl();

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
