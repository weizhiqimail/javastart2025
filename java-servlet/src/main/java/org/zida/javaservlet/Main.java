package org.zida.javaservlet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.zida.javaservlet.home.UserInfo;

@WebServlet(name = "home", value = "/home")
public class Main extends HttpServlet {
  private String pageTitle;
  private String pageDesc;

  @Override
  public void init() {
    pageTitle = "Java Servlet 初步开始";
    pageDesc = "从 Bootstrap 和 jQuery 逐步开始";
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("text/html");

    List<UserInfo> userList = new ArrayList<>();
    UserInfo userInfo1 =new UserInfo(1, "张伟", 28, "北京市朝阳区", "软件工程师");
    userList.add(new UserInfo(1, "张伟", 28, "北京市朝阳区", "软件工程师"));
    userList.add(new UserInfo(2, "李娜", 32, "上海市浦东新区", "产品经理"));
    userList.add(new UserInfo(3, "王强", 25, "广州市天河区", "数据分析师"));
    userList.add(new UserInfo(4, "赵敏", 30, "深圳市南山区", "UI设计师"));
    userList.add(new UserInfo(5, "刘洋", 35, "杭州市西湖区", "项目主管"));
    userList.add(new UserInfo(6, "陈杰", 27, "成都市武侯区", "测试工程师"));
    userList.add(new UserInfo(7, "孙婷", 29, "重庆市渝中区", "运营专员"));
    userList.add(new UserInfo(8, "周磊", 31, "南京市鼓楼区", "网络管理员"));
    userList.add(new UserInfo(9, "胡静", 26, "武汉市洪山区", "人事助理"));
    userList.add(new UserInfo(10, "高飞", 33, "西安市雁塔区", "市场专员"));

    request.setAttribute("pageTitle", pageTitle);
    request.setAttribute("pageDesc", pageDesc);
    request.setAttribute("userList", userList);
    request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
  }

  @Override
  public void destroy() {
  }
}