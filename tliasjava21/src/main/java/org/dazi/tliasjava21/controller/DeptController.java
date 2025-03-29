package org.dazi.tliasjava21.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.dazi.tliasjava21.dao.DeptCreateDto;
import org.dazi.tliasjava21.dao.DeptUpdateDto;
import org.dazi.tliasjava21.pojo.Dept;
import org.dazi.tliasjava21.pojo.Result;
import org.dazi.tliasjava21.service.DeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wei
 */
@Tag(name = "部门模块", description = "增删改查部门信息")
@Slf4j
@RequestMapping("/deps")
@RestController
public class DeptController {
//  private static final Logger log = LoggerFactory.getLogger(DeptController.class);

  @Autowired
  private DeptService deptService;

  @Operation(summary = "获取部门列表", description = "获取所有部门信息")
  @GetMapping
  public Result getDeptList() {
    List<Dept> deptList = deptService.getDeptList();
    log.info("获取部门列表：{}", deptList);
    return Result.success(deptList);
  }

  @Operation(summary = "删除部门：通过 HttpServletRequest 获取查询参数", description = "根据ID删除部门")
  @DeleteMapping("/depts1")
  public Result deleteDept1(HttpServletRequest request) {
    String id = request.getParameter("id");
    if (id == null || id.isEmpty()) {
      return Result.error("ID cannot be null or empty");
    }
    int deptId = Integer.parseInt(id);
    log.info("/depts1 删除部门，ID：{}", deptId);
    deptService.deleteDept(deptId);
    return Result.success();
  }

  @Operation(summary = "删除部门：通过 @RequestParam 获取查询参数", description = "根据ID删除部门")
  @DeleteMapping("/depts2")
  public Result deleteDept2(@RequestParam("id") Integer deptId) {
    log.info("/depts2 删除部门，ID：{}", deptId);
    deptService.deleteDept(deptId);
    return Result.success();
  }

  // 添加部门
  @Operation(summary = "添加部门", description = "添加部门信息")
  @PostMapping
  public Result addDept(@RequestBody DeptCreateDto dept) {
    deptService.addDept(dept);
    log.info("添加部门：{}", dept);
    return Result.success();
  }

  // 修改单个部门
  @Operation(summary = "路径参数：修改部门", description = "修改部门信息")
  @PutMapping("/{deptId}")
  public Result updateDept(@PathVariable Integer deptId, @RequestBody DeptUpdateDto dept) {
    deptService.updateDept(dept, deptId);
    log.info("修改部门：deptId= {}, dept= {}", deptId, dept);
    return Result.success();
  }

  // 查询单个部门
  @Operation(summary = "路径参数：查询单个部门", description = "根据ID查询部门信息")
  @GetMapping("/{deptId}")
  public Result getDept(@PathVariable Integer deptId) {
    Dept dept = deptService.getDept(deptId);
    log.info("查询单个部门：deptId= {}, dept= {}", deptId, dept);
    return Result.success(dept);
  }

  // 删除单个部门
  @Operation(summary = "路径参数：删除单个部门", description = "根据ID删除部门信息")
  @DeleteMapping("/{deptId}")
  public Result deleteDept(@PathVariable Integer deptId) {
    deptService.deleteDept(deptId);
    log.info("删除单个部门：deptId= {}", deptId);
    return Result.success();
  }
}
