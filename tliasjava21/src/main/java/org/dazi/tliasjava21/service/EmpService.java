package org.dazi.tliasjava21.service;

import org.dazi.tliasjava21.dao.EmpQueryDto;
import org.dazi.tliasjava21.dao.EmpWithDeptAndExpr;
import org.dazi.tliasjava21.pojo.PageResult;

public interface EmpService {
  PageResult<EmpWithDeptAndExpr> getEmpList(EmpQueryDto empQueryDto);
}
