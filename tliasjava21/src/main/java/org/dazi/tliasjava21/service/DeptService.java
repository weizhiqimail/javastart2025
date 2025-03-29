package org.dazi.tliasjava21.service;

import org.dazi.tliasjava21.pojo.Dept;

import java.util.List;

public interface DeptService {

  List<Dept> getDeptList();

  void deleteDept(int deptId);

  Dept addDept(Dept dept);

  void updateDept(String name, Integer deptId);

  Dept getDept(Integer deptId);
}
