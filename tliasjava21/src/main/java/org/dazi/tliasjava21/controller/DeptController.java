package org.dazi.tliasjava21.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "部门模块", description = "增删改查部门信息")
@RestController
public class DeptController {

  @Autowired
  private DeptService deptService;

  @Operation(summary = "获取部门列表", description = "获取所有部门信息")
  @GetMapping("/depts")
  public Result getDeptList() {
    List<Dept> deptList = deptService.getDeptList();
    return Result.success(deptList);
  }

  // 接收参数方式1
  @Operation(summary = "删除部门：通过 HttpServletRequest 获取参数", description = "根据ID删除部门")
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
  @Operation(summary = "删除部门：通过 @RequestParam 获取参数", description = "根据ID删除部门")
  @DeleteMapping("/depts2")
  public Result deleteDept2(@RequestParam("id") Integer deptId) {
    System.out.println("删除部门，ID：" + deptId);
    deptService.deleteDept(deptId);
    return Result.success();
  }

}
