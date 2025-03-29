package org.dazi.tliasjava21.service.impl;

import org.dazi.tliasjava21.dao.EmpQueryDto;
import org.dazi.tliasjava21.mapper.EmpMapper;
import org.dazi.tliasjava21.pojo.Emp;
import org.dazi.tliasjava21.pojo.PageResult;
import org.dazi.tliasjava21.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

  @Autowired
  private EmpMapper empMapper;

  @Override
  public PageResult<Emp> getEmpList(EmpQueryDto empQueryDto) {
    int pageSize = empQueryDto.pageSize != null ? empQueryDto.pageSize : 10;
    int pageNum = empQueryDto.pageNum != null ? empQueryDto.pageNum : 1;
    int offset = (pageNum - 1) * pageSize;
    long total = empMapper.countEmp(empQueryDto);
    List<Emp> empList = empMapper.getEmpList(offset, pageSize);
    return new PageResult<>(total, empList);
  }
}
