package org.dazi.javaspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.dazi.javaspringboot.pojo.User;
import org.dazi.javaspringboot.mapper.UserMapper;

import java.util.List;

// 当前类中的测试方法运行时，会启动 SpringBoot 项目 - IOC 容器
@SpringBootTest
class JavaSpringbootApplicationTests {

  @Autowired
  private UserMapper userMapper;

  @Test
  public void testFindUserList() {
    List<User> userList= userMapper.findAllUsers();
    userList.forEach(System.out::println);

  }

}
