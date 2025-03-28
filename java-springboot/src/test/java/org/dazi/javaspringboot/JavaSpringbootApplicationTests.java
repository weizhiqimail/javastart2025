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

  @Test
  public void testDeleteUserById() {
    int id = 1;
    int result = userMapper.deleteUserById(id);
    System.out.println("删除结果：" + result);
  }

  @Test
  public void testUpdateUserById() {
    int id = 2;
    int age = 30;
    int result = userMapper.updateUserById(id, age);
    System.out.println("更新结果：" + result);
  }

  @Test
  public void testInsertUser() {
    User user = new User();
    user.setName("萧远山");
    user.setAge(48);
    int result = userMapper.insertUser(user);
    System.out.println("插入结果：" + result);
  }

  @Test
  public void testInsertUserByObject() {
    User user = new User();
    user.setName("周芷若");
    user.setAge(21);
    user.setGender("女");
    user.setPhone("15976368888");
    user.setEmail("zhouzhiruo@example.com");
    int result = userMapper.insertUserByUser(user);
    System.out.println("插入结果：" + result);
  }

}
