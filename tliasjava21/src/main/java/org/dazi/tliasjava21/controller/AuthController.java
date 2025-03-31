package org.dazi.tliasjava21.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.dazi.tliasjava21.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "用户认证模块", description = "用户登陆、注册、注销等校验")
@Slf4j
@RequestMapping("/auth")
@RestController
public class AuthController {

  @Operation(summary = "用户登录", description = "用户登录")
  @PostMapping
  public Result authLogin() {
    return Result.success("登陆成功");
  }

}
