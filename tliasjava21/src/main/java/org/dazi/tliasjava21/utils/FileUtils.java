package org.dazi.tliasjava21.utils;

public class FileUtils {

  // 获取文件名
  public static String getFileName(String filePath) {
    return filePath.substring(filePath.lastIndexOf("\\") + 1);
  }

  // 获取文件路径
  public static String getFilePath(String filePath) {
    return filePath.substring(0, filePath.lastIndexOf("\\"));
  }

  // 获取文件后缀名
  public static String getFileSuffix(String fileName) {
    return fileName.substring(fileName.lastIndexOf(".") + 1);
  }

  // 获取文件后缀名，带有点
  public static String getFileSuffix(String fileName, boolean needDot) {
    return fileName.substring(fileName.lastIndexOf(".") + (needDot ? 0 : 1));
  }

}
