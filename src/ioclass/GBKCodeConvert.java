package ioclass;

import java.io.*;

public class GBKCodeConvert {

  public static void main(String[] args) {
    try(
        InputStream inputStream = new FileInputStream("D:\\program\\javastart2025\\src\\ioclass\\gbkFile.txt");
        // 这里要用  GBK 指定编码集，否则会出现乱码
        Reader reader = new InputStreamReader(inputStream, "GBK");
        BufferedReader bufferedReader = new BufferedReader(reader);
        ) {
        String line;
        while((line = bufferedReader.readLine())!= null) {
          System.out.println(line);
        }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
