package org.dazi.tliasjava21.service.impl;

import org.dazi.tliasjava21.mapper.DeptMapper;
import org.dazi.tliasjava21.pojo.Dept;
import org.dazi.tliasjava21.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

  @Autowired
  private DeptMapper deptMapper;

  @Override
  public List<Dept> getDeptList() {
    return deptMapper.getDeptList();
  }

  @Override
  public void deleteDept(int deptId) {
    deptMapper.deleteDept(deptId);
  }

  @Override
  public Dept addDept(Dept dept) {
    deptMapper.addDept(dept);
    return dept;
  }

  @Override
  public void updateDept(String name,Integer deptId) {
    deptMapper.updateDept(name, deptId);
  }

  @Override
  public Dept getDept(Integer deptId) {
    return deptMapper.getDept(deptId);
  }
}
