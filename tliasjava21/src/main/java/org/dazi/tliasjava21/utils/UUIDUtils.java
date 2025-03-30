package org.dazi.tliasjava21.utils;

public class UUIDUtils {
  public static String generateUUID() {
    return java.util.UUID.randomUUID().toString().replace("-", "");
  }
}
