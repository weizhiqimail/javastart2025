package org.dazi.tliasjava21.service;

import org.dazi.tliasjava21.dao.DeptCreateDto;
import org.dazi.tliasjava21.dao.DeptUpdateDto;
import org.dazi.tliasjava21.pojo.Dept;

import java.util.List;

public interface DeptService {

  List<Dept> getDeptList();

  void deleteDept(int deptId);

  void addDept(DeptCreateDto dept);

  void updateDept(DeptUpdateDto dept, Integer deptId);

  Dept getDept(Integer deptId);
}
