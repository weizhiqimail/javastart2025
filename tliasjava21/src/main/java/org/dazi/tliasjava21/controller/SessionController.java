package org.dazi.tliasjava21.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.dazi.tliasjava21.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "测试Session证模块", description = "测试用户登陆、注册、注销等校验")
@Slf4j
@RequestMapping("/session")
@RestController
public class SessionController {

  @GetMapping("/addCookie")
  public Result cookieTest1(HttpServletResponse response) {
    response.addCookie(new Cookie("login_username", "tlias-cookie"));
    return Result.success();
  }

  @GetMapping("/getCookie")
  public Result cookieTest2(HttpServletRequest request) {
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
      if ("login_username".equals(cookie.getName())) {
        log.info("用户已登录 cookie value =" + cookie.getValue());
      }
    }
    return Result.success();
  }

  @GetMapping("/addSession")
  public Result sessionTest1(HttpSession session) {
    log.info("HttpSession-session1: {}", session.hashCode());
    session.setAttribute("login_user", "tlias-session");
    return Result.success();
  }

  @GetMapping("/getSession")
  public Result sessionTest2(HttpSession session) {
    log.info("HttpSession-session2 getId: {}", session.getId());
    Object loginUser = session.getAttribute("login_user");
    log.info("login_user: {}", loginUser);
    return Result.success(loginUser);
  }


}
