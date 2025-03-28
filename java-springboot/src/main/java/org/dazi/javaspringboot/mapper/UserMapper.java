package org.dazi.javaspringboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.dazi.javaspringboot.pojo.User;

import java.util.List;

// 程序运行时，会自动为接口创建一个实例类对象（代理对象）
// 并且会自动将该实例类对象存入 IOC 容器中
@Mapper
public interface UserMapper {

  // 查询所有用户信息
  @Select("SELECT * FROM hero")
  public List<User> findAllUsers();

}
