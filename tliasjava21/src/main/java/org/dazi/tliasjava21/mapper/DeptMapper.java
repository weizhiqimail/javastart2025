package org.dazi.tliasjava21.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.dazi.tliasjava21.pojo.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {

  @Select("select id, name, create_time, update_time from dept")
  public List<Dept> getDeptList();
}
