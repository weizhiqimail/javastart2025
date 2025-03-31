package org.dazi.tliasjava21.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/session/*")
public class TokenFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    Filter.super.init(filterConfig);
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    // 获取请求路径
    String requestURI = request.getRequestURI();
    // 获取请求方法
    String method = request.getMethod();

    // 获取请求头中的 authorization
    String authorization = request.getHeader("authorization");

    // 如果 authorization 不存在，返回错误 401
    if (authorization == null || authorization.isEmpty()) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }

    // 如果 authorization 存在，校验 authorization 是否有效，如果有效则放行，如果无效则返回错误 401

    // 处理无效逻辑

    // 有效逻辑
    chain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {
    Filter.super.destroy();
  }
}
