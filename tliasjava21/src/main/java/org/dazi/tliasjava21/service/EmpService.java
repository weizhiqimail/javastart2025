package org.dazi.tliasjava21.service;

import org.dazi.tliasjava21.dao.EmpQueryDto;
import org.dazi.tliasjava21.pojo.Emp;
import org.dazi.tliasjava21.pojo.PageResult;

import java.util.List;

public interface EmpService {
  PageResult<Emp> getEmpList(EmpQueryDto empQueryDto);
}
