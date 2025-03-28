package org.dazi.javaspringboot.mapper;

import org.apache.ibatis.annotations.*;
import org.dazi.javaspringboot.pojo.User;

import java.util.List;

// 程序运行时，会自动为接口创建一个实例类对象（代理对象）
// 并且会自动将该实例类对象存入 IOC 容器中
@Mapper
public interface UserMapper {

  // 使用注解的方式来编写 SQL 语句
//  @Select("SELECT * FROM hero")
//  public List<User> findAllUsers();
//
//  @Delete("delete from hero where id = #{id}")
//  public int deleteUserById(int id);
//
//  @Update("update hero set age = #{age} where id = #{id}")
//  public int updateUserById(@Param("id") int id, @Param("age") int age);
//
//  @Insert("insert into hero (name, age) values (#{name}, #{age})")
//  public int insertUser(User user);
//
//  @Insert("insert into hero(name, age, gender, phone, email) values (#{name}, #{age}, #{gender}, #{phone}, #{email})")
//  public int insertUserByUser(User user);

  // 使用 xml 文件的方式来编写 SQL 语句
  public List<User> findAllUsers();

  @Delete("delete from hero where id = #{id}")
  public int deleteUserById(int id);

  @Update("update hero set age = #{age} where id = #{id}")
  public int updateUserById(@Param("id") int id, @Param("age") int age);

  @Insert("insert into hero (name, age) values (#{name}, #{age})")
  public int insertUser(User user);

  @Insert("insert into hero(name, age, gender, phone, email) values (#{name}, #{age}, #{gender}, #{phone}, #{email})")
  public int insertUserByUser(User user);

}
