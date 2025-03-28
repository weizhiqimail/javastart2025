package ioclass;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArticleReader {

  public static void main(String[] args) {
    try (

        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\program\\javastart2025\\src\\ioclass\\articleReader.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\program\\javastart2025\\src\\ioclass\\articleWrite.txt"));
    ) {
      List<String> list = new ArrayList<String>();

      String line = null;

      while((line = bufferedReader.readLine()) != null) {
        list.add(line);
      }
      Collections.sort(list);
      System.out.println(list);


      for(String str: list){
        bufferedWriter.write(str);
        bufferedWriter.newLine();
      }

      System.out.println("文件写入完成");



    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
