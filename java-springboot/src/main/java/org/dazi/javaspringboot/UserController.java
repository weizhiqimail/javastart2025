package org.dazi.javaspringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @RequestMapping("/getUserName")
  public String queryUserName(String name) {
    System.out.println("queryUserName: "+name);
    return "name: " + name;
  }
}
