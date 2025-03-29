package org.dazi.tliasjava21.controller;


import org.dazi.tliasjava21.pojo.Dept;
import org.dazi.tliasjava21.pojo.Result;
import org.dazi.tliasjava21.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

  @Autowired
  private DeptService deptService;

  @RequestMapping("/depts")
  public Result getDeptList() {
    List<Dept> deptList = deptService.getDeptList();
    return Result.success(deptList);
  }

}
