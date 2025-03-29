package org.dazi.tliasjava21.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.dazi.tliasjava21.pojo.Dept;
import org.dazi.tliasjava21.pojo.Result;
import org.dazi.tliasjava21.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

  @Autowired
  private DeptService deptService;

  @GetMapping("/depts")
  public Result getDeptList() {
    List<Dept> deptList = deptService.getDeptList();
    return Result.success(deptList);
  }

  // 接收参数方式1
  @DeleteMapping("/depts1")
  public Result deleteDept1(HttpServletRequest request) {
    String id = request.getParameter("id");
    if (id == null || id.isEmpty()) {
      return Result.error("ID cannot be null or empty");
    }
    int deptId = Integer.parseInt(id);
    System.out.println("删除部门，ID：" + deptId);
    deptService.deleteDept(deptId);
    return Result.success();
  }

  // 接收参数方式1
  @DeleteMapping("/depts2")
  public Result deleteDept2(@RequestParam("id") Integer deptId) {
    if (deptId == null ) {
      return Result.error("ID cannot be null or empty");
    }
    System.out.println("删除部门，ID：" + deptId);
    deptService.deleteDept(deptId);
    return Result.success();
  }

}
