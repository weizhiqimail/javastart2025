package org.dazi.javaspringboot.controller;

import cn.hutool.core.io.IoUtil;
import org.dazi.javaspringboot.User;
import org.dazi.javaspringboot.service.UserService;
import org.dazi.javaspringboot.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wei
 */
@RestController // @ResponseBody
public class UserController {

  public UserService userService = new UserServiceImpl();


  @RequestMapping("/getUserName")
  public String queryUserName(String name) {
    System.out.println("queryUserName: " + name);
    return "name: " + name;
  }

  @GetMapping("/getUserList")
  public List<User> queryUserList() throws FileNotFoundException {
    // 调用 Service 获取数据
    List<User> list = userService.findUserList();
    // 响应数据
    return list;
  }

  @GetMapping("/getUserListBackup")
  public List<User> queryUserListBackup() throws FileNotFoundException {
    System.out.println("queryUserList: ");

    InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("user.txt");
    ArrayList<String> lines = IoUtil.readLines(inputStream, StandardCharsets.UTF_8, new ArrayList<>());

    return lines.stream().map(line -> {
      String[] arr = Arrays.stream(line.split(",")).map(String::trim).toArray(String[]::new);
      Integer id = Integer.parseInt(arr[0]);
      String name = arr[1];
      LocalDateTime dateTime = LocalDateTime.parse(arr[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
      return new User(id, name, dateTime);
    }).toList();
  }
}
