package org.dazi.javaspringboot.service;

import org.dazi.javaspringboot.User;
import java.util.List;

/**
 * @author wei
 */
public interface UserService {

  public List<User> findUserList();

}
