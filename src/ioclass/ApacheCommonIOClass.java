package ioclass;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ApacheCommonIOClass {


  public static void main(String[] args) throws IOException {
    FileUtils.copyFile(new File("D:\\program\\javastart2025\\src\\ioclass\\gbkFile.txt"), new File("D:\\program\\javastart2025\\src\\ioclass\\gbkFile2.txt"));
  }

}
