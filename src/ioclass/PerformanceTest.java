package ioclass;

import java.io.*;

/**
 * 原始流、缓冲流的性能分析
 * 分别使用原始的字节流、字节缓冲流复制一个很大的视频
 * <p>
 * 测试步骤
 * 1. 使用低级的字节流，按照一个一个字节的形式复制文件【最差】
 * 2. 使用低级的字节流按照字节数组的形式复制文件【其次】
 * 3. 使用高级的缓冲字节流按照一个一个字节的形式复制文件【再次】
 * 4. 使用高级的缓冲字节流按照字节数组的形式复制文件【最好】
 */

public class PerformanceTest {

  public static String VIDEO_FILE_PATH = "D:\\program\\javastart2025\\src\\ioclass\\testVideo.mp4";
  public static String VIDEO_FILE_DEST_DIR = "D:\\program\\javastart2025\\src\\ioclass\\";

  public static void main(String[] args) {
    File destDir = new File(VIDEO_FILE_DEST_DIR);
    if (!destDir.exists()) {
      destDir.mkdirs();
    }

    test4();
    test3();
    test2();
    test1();
  }

  // 使用低级的字节流，按照一个一个字节的形式复制文件
  public static void test1() {
    long startTimeMillis = System.currentTimeMillis();
    try (FileInputStream input = new FileInputStream(VIDEO_FILE_PATH); FileOutputStream output = new FileOutputStream(VIDEO_FILE_DEST_DIR + "testVideo_01.mp4");) {

      int byteRead;
      while ((byteRead = input.read()) != -1) {
        output.write(byteRead);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    long endTimeMillis = System.currentTimeMillis();
    long diffTimeMillis = endTimeMillis - startTimeMillis;
    System.out.println("test1 使用低级的字节流，按照一个一个字节的形式复制文件");
    System.out.println("test1 耗时：" + diffTimeMillis + "ms");
  }

  // 使用低级的字节流按照字节数组的形式复制文件
  public static void test2() {
    long startTimeMillis = System.currentTimeMillis();
    try (FileInputStream input = new FileInputStream(VIDEO_FILE_PATH); FileOutputStream output = new FileOutputStream(VIDEO_FILE_DEST_DIR + "testVideo_02.mp4");) {

      byte[] bytes = new byte[1024];
      int bytesRead;
      while ((bytesRead = input.read(bytes)) != -1) {
        output.write(bytes, 0, bytesRead);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    long endTimeMillis = System.currentTimeMillis();
    long diffTimeMillis = endTimeMillis - startTimeMillis;
    System.out.println("test2 使用低级的字节流按照字节数组的形式复制文件");
    System.out.println("test2 耗时：" + diffTimeMillis + "ms");
  }

  // 使用高级的缓冲字节流按照一个一个字节的形式复制文件
  public static void test3() {
    long startTimeMillis = System.currentTimeMillis();
    try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(VIDEO_FILE_PATH)); BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(VIDEO_FILE_DEST_DIR + "testVideo_03.mp4"));) {
      int byteRead;
      while ((byteRead = input.read()) != -1) {
        output.write(byteRead);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    long endTimeMillis = System.currentTimeMillis();
    long diffTimeMillis = endTimeMillis - startTimeMillis;
    System.out.println("test3 使用高级的缓冲字节流按照一个一个字节的形式复制文件");
    System.out.println("test3 耗时：" + diffTimeMillis + "ms");
  }

  // 使用高级的缓冲字节流按照字节数组的形式复制文件
  public static void test4() {
    long startTimeMillis = System.currentTimeMillis();
    try (
        BufferedInputStream input = new BufferedInputStream(new FileInputStream(VIDEO_FILE_PATH));
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(VIDEO_FILE_DEST_DIR + "testVideo_04.mp4"));
        ) {
      byte[] bytes = new byte[1024];
      int bytesRead;
      while ((bytesRead = input.read(bytes)) != -1) {
        output.write(bytes, 0, bytesRead);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    long endTimeMillis = System.currentTimeMillis();
    long diffTimeMillis = endTimeMillis - startTimeMillis;
    System.out.println("test4 使用高级的缓冲字节流按照字节数组的形式复制文件");
    System.out.println("test4 耗时：" + diffTimeMillis + "ms");
  }
}
