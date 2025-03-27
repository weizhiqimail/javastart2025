package ioclass;

import java.io.*;

public class WriteReaderClass {
  public static String READ_FILE_PATH = "D:\\program\\javastart2025\\src\\ioclass\\io.txt";
  public static String WRITE_FILE_PATH = "D:\\program\\javastart2025\\src\\ioclass\\iowrite.txt";

  public static void main(String[] args) throws IOException {
    // 文件字符输入流，读取字符文件到内存中
    writeFileByBuffer();
  }

  // 读取文件：读取中文按照字符读取，不会出现乱码
  public static void readFile() throws FileNotFoundException {
    try (Reader reader = new FileReader(READ_FILE_PATH);) {
      System.out.println("使用字符输入流读取文件");
      char[] buf = new char[1024];
      int len;
      int times = 0;
      while ((len = reader.read(buf)) != -1) {
        times++;
        System.out.println("第" + times + "次读取，读取到的字符数：" + len + " 字符是：【" + new String(buf, 0, len) + "】");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }


    // 读取文件内容
    // 1. 创建字符输入流对象
    // 2. 读取文件内容
    // 3. 关闭流
  }

  // 写入文件
  public static void writeFile() throws FileNotFoundException {
    try (Writer writer = new FileWriter(WRITE_FILE_PATH, true);) {
      System.out.println("使用字符输出流写入文件");
      writer.write("hello world\n");
      writer.write("你好，世界\n");
      writer.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // 使用缓冲字节输出流
  public static void writeFileByBuffer() throws IOException {
    FileWriter fileWriter = new FileWriter(WRITE_FILE_PATH, true);
    try (BufferedWriter writer = new BufferedWriter(fileWriter);) {
      System.out.println("使用缓冲字节输出流写入文件");
      writer.write("使用缓冲字节输出流写入文件\n");
      writer.write("使用缓冲字节输出流写入文件\n");
      writer.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
