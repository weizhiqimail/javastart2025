package org.dazi.tliasjava21.mapper;

import org.apache.ibatis.annotations.*;
import org.dazi.tliasjava21.dao.DeptCreateDto;
import org.dazi.tliasjava21.dao.DeptUpdateDto;
import org.dazi.tliasjava21.pojo.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {
  // 方式1：手动结果映射
  //  @Results({
  //      @Result(column = "create_time", property = "createTime"),
  //      @Result(column = "update_time", property = "updateTime"),
  //  })
  // 方式2：起别名
  // @Select("select id, name, create_time createTime, update_time updateTime from dept")
  // 方式3：mybatis开启驼峰命名配置
  @Select("select id, name, create_time, update_time from dept")
  public List<Dept> getDeptList();

  @Delete("delete from dept where id = #{deptId}")
  public void deleteDept(int deptId);

  @Insert("insert into dept (name) values (#{name})")
  public void addDept(DeptCreateDto dept);

  @Update("update dept set name = #{dept.name} where id = #{deptId}")
  public void updateDept(@Param("dept") DeptUpdateDto dept, @Param("deptId") Integer deptId);

  @Select("select id, name, create_time, update_time from dept where id = #{deptId}")
  Dept getDept(Integer deptId);
}
