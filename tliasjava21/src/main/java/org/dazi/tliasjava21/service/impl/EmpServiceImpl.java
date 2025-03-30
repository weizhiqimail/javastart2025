package org.dazi.tliasjava21.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.dazi.tliasjava21.dao.EmpQueryDto;
import org.dazi.tliasjava21.dao.EmpWithDeptAndExpr;
import org.dazi.tliasjava21.mapper.EmpMapper;
import org.dazi.tliasjava21.pojo.Emp;
import org.dazi.tliasjava21.pojo.PageResult;
import org.dazi.tliasjava21.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

  @Autowired
  private EmpMapper empMapper;

//  @Override
//  public PageResult<Emp> getEmpList(EmpQueryDto empQueryDto) {
//    int pageSize = empQueryDto.pageSize != null ? empQueryDto.pageSize : 10;
//    int pageNum = empQueryDto.pageNum != null ? empQueryDto.pageNum : 1;
//    int offset = (pageNum - 1) * pageSize;
//    List<Emp> empList = empMapper.getEmpList(offset, pageSize);
//    return new PageResult<>(20, empList);
//  }

  //    基于 PageHelper 分页
  @Override
  public PageResult<EmpWithDeptAndExpr> getEmpList(EmpQueryDto empQueryDto) {
    int pageSize = empQueryDto.pageSize != null ? empQueryDto.pageSize : 10;
    int pageNum = empQueryDto.pageNum != null ? empQueryDto.pageNum : 1;
    log.info("empQueryDto = {}", empQueryDto.toString());

    // 分页参数
    PageHelper.startPage(pageNum, pageSize);
    // 执行查询
    List<EmpWithDeptAndExpr> empList = empMapper.getEmpList(empQueryDto);
    // 解析结果
    Page<EmpWithDeptAndExpr> page = (Page<EmpWithDeptAndExpr>) empList;

    return new PageResult<EmpWithDeptAndExpr>(page.getTotal(), page.getResult());
  }
}
