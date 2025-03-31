package org.dazi.tliasjava21.service;

import org.dazi.tliasjava21.pojo.Emp;

public interface AuthService {

  public Emp login(String username, String password) throws Exception;
}
