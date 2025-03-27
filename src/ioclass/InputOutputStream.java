package ioclass;

import java.io.*;

public class InputOutputStream {

  public static String READ_FILE_PATH = "D:\\program\\javastart2025\\src\\ioclass\\io.txt";
  public static String WRITE_FILE_PATH = "D:\\program\\javastart2025\\src\\ioclass\\iowrite.txt";

  public static void main(String[] args) throws IOException {

  }

  // 每次读取一个字符，读取汉字时会乱码
  public static void readByByte() throws IOException {
    InputStream fileInputStream = new FileInputStream(READ_FILE_PATH);
    System.out.println("每次读取一个字节，读取汉字时会乱码");
    int b;
    int times = 0;
    while ((b = fileInputStream.read()) != -1) {
      times++;
      System.out.println("第" + times + "次读取，读取到的字节数：" + b + " 字符是：【" + (char) b + "】");
    }
  }

  // 使用字节数组读取多个字节，存在截断汉字字符的可能性，所以依然不能用来读取中文
  public static void readByByteArray() throws IOException {
    InputStream fileInputStream = new FileInputStream(READ_FILE_PATH);
    System.out.println("使用字节数组读取多个字节，存在截断汉字字符的可能性，所以依然不能用来读取中文");

    byte[] bytes = new byte[4];
    int len;
    int times = 0;
    while ((len = fileInputStream.read(bytes)) != -1) {
      times++;
      System.out.println("第" + times + "次读取，读取到的字节数：" + len + " 字符是：【" + new String(bytes, 0, len) + "】");
    }
  }

  // 使用 readAllBytes 读取所有的字符，不会截断汉字。缺点是如果文件过大，会导致内存溢出的异常
  public static void readByByteAllBytes() throws IOException {
    InputStream fileInputStream = new FileInputStream(READ_FILE_PATH);
    System.out.println("使用 readAllBytes 读取所有的字符，不会截断汉字");
    byte[] bytes = fileInputStream.readAllBytes();
    System.out.println("读取到的字节数：" + bytes.length + " 字符是：【" + new String(bytes) + "】");
  }

  // 使用字节写入文件
  public static void writeFileByByte() throws IOException {
    try (OutputStream outputStream = new FileOutputStream(WRITE_FILE_PATH, true);) {
      System.out.println("使用字符写入文件");

      outputStream.write('a');
      outputStream.write('b');
      outputStream.write('c');

      byte[] bytes = "我是汉字11122333".getBytes();
      outputStream.write(bytes);
      outputStream.write("\r\n".getBytes());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
