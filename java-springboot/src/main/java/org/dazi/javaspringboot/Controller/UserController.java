package org.dazi.javaspringboot.Controller;

import cn.hutool.core.io.IoUtil;
import org.dazi.javaspringboot.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController // @ResponseBody
public class UserController {

  @RequestMapping("/getUserName")
  public String queryUserName(String name) {
    System.out.println("queryUserName: " + name);
    return "name: " + name;
  }

  @GetMapping("/getUserList")
  public List<User> queryUserList() throws FileNotFoundException {
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
