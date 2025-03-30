package org.dazi.tliasjava21.controller;

import com.aliyuncs.exceptions.ClientException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.dazi.tliasjava21.dao.EmpQueryDto;
import org.dazi.tliasjava21.pojo.Result;
import org.dazi.tliasjava21.service.EmpService;
import org.dazi.tliasjava21.utils.AliyunOSSUtils;
import org.dazi.tliasjava21.utils.FileUtils;
import org.dazi.tliasjava21.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Tag(name = "员工模块", description = "增删改查员工信息")
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

  @Autowired
  private EmpService empService;

  @Operation(summary = "获取员工列表", description = "获取所有员工信息")
  @PostMapping
  public Result getEmpList(@RequestBody EmpQueryDto empQueryDto) {
    log.info("获取员工列表，查询条件: {}", empQueryDto);
    throw new RuntimeException("自定义错误");
//    return Result.success(empService.getEmpList(empQueryDto));
  }

  @Operation(summary = "上传员工头像", description = "上传员工头像到本地文件系统")
  @PostMapping("/uploadAvatarToLocal")
  public Result uploadToLocal(String username, MultipartFile file) throws IOException {
    String originalFilename = file.getOriginalFilename();
    String fileSuffix = FileUtils.getFileSuffix(originalFilename, true);
    log.info("上传员工头像，username: {}", username);
    log.info("上传员工头像，文件名: {}", originalFilename);
    String fileFullName = UUIDUtils.generateUUID() + fileSuffix;
    file.transferTo(new File("D:\\program\\javastart2025\\tliasjava21\\upload\\" + fileFullName));
    return Result.success();
  }

  @Operation(summary = "上传员工头像", description = "上传员工头像到OSS")
  @PostMapping("/uploadAvatarToOSS")
  public Result uploadToOSS(String username, MultipartFile file) throws IOException, ClientException {
    new AliyunOSSUtils().uploadOSS(file);
    return Result.success();
  }
}
