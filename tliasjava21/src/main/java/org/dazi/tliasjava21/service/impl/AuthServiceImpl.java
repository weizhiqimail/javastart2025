package org.dazi.tliasjava21.service.impl;

import org.dazi.tliasjava21.mapper.DeptMapper;
import org.dazi.tliasjava21.pojo.Emp;
import org.dazi.tliasjava21.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  @Autowired
  private DeptMapper deptMapper;

  @Override
  public Emp login(String username, String password) throws Exception {
    Emp emp = deptMapper.queryEmpByUsernameAndPassword(username, password);


    return null;
  }

}
