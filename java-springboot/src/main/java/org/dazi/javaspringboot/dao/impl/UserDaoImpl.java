package org.dazi.javaspringboot.dao.impl;

import cn.hutool.core.io.IoUtil;
import org.dazi.javaspringboot.dao.UserDao;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wei
 */
@Component // 将当前类交给 IOC 容器处理
public class UserDaoImpl  implements UserDao {

  @Override
  public List<String> findUserList() {
    InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("user.txt");
    return IoUtil.readLines(inputStream, StandardCharsets.UTF_8, new ArrayList<>());
  }
}
