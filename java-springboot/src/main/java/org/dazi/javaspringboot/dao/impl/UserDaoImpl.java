package org.dazi.javaspringboot.dao.impl;

import cn.hutool.core.io.IoUtil;
import org.dazi.javaspringboot.dao.UserDao;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wei
 */
public class UserDaoImpl  implements UserDao {

  @Override
  public List<String> findUserList() {
    InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("user.txt");
    return IoUtil.readLines(inputStream, StandardCharsets.UTF_8, new ArrayList<>());
  }
}
