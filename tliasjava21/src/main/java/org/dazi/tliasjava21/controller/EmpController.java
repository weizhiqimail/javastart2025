package org.dazi.tliasjava21.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.dazi.tliasjava21.dao.EmpQueryDto;
import org.dazi.tliasjava21.pojo.Result;
import org.dazi.tliasjava21.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "员工模块", description = "增删改查员工信息")
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

  @Autowired
  private  EmpService empService;

  @Operation(summary = "获取员工列表", description = "获取所有员工信息")
  @PostMapping
  public Result getEmpList(@RequestBody EmpQueryDto empQueryDto) {
    log.info("获取员工列表，查询条件: {}", empQueryDto);
    return Result.success(empService.getEmpList(empQueryDto));
  }

}
