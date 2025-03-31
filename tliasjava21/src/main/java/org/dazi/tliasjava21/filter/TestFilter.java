package org.dazi.tliasjava21.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

// 拦截所有的请求
//@WebFilter(urlPatterns = "/session/*")
@Slf4j
public class TestFilter implements Filter {

  // 过滤器初始化，web 服务器启动的时候，执行一次
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    log.info("TestFilter init");
    Filter.super.init(filterConfig);
  }

  // 拦截到请求之后会执行多次，拦截后调用 `chain.doFilter(request, response)` 放行执行后续的操作
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    log.info("TestFilter doFilter");
    chain.doFilter(request, response);
  }

  // 销毁的时候执行，web 服务器关闭的时候，执行一次
  @Override
  public void destroy() {
    log.info("TestFilter destroy");
    Filter.super.destroy();
  }
}
