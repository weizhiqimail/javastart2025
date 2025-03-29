package org.dazi.tliasjava21.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.dazi.tliasjava21.dao.EmpQueryDto;
import org.dazi.tliasjava21.pojo.Emp;

import java.util.List;

@Mapper
public interface EmpMapper {
  // 查询员工总数
  @Select("SELECT COUNT(*) FROM emp")
  long countEmp(EmpQueryDto empQueryDto);

  // 分页查询
  @Select("SELECT * FROM emp LIMIT #{offset}, #{pageSize}")
   List<Emp> getEmpList(int offset, int pageSize);
}
