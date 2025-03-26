package fileclass;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class FileClass {

  public static String READ_DIR_PATH = "D:\\program\\javastart2025\\src";
  public static String READ_FILE_PATH = "D:\\program\\javastart2025\\src\\fileclass\\FileClass.java";
  public static String CREATE_FILE_PATH = "D:\\program\\javastart2025\\src\\fileclass\\FileClassCreate.txt";

  public static void main(String[] args) throws IOException {
    readDirectory();
  }

  // 读取文件的元数据
  public static void readFileMetadata() {
    File file1 = new File(READ_FILE_PATH);
    System.out.println("File name: " + file1.getName());
    System.out.println("File path: " + file1.getPath());
    System.out.println("File absolute path: " + file1.getAbsolutePath());
    System.out.println("File parent: " + file1.getParent());
    System.out.println("File size: " + file1.length() + " bytes");
    System.out.println("File exists: " + file1.exists());
    System.out.println("File is readable: " + file1.canRead());
    System.out.println("File is writable: " + file1.canWrite());
    System.out.println("File is executable: " + file1.canExecute());
    System.out.println("File last modified: " + file1.lastModified());
    System.out.println("File is directory: " + file1.isDirectory());
    System.out.println("File is file: " + file1.isFile());
  }

  // 创建一个文件
  public static void createFile() throws IOException {
    File createFile = new File(CREATE_FILE_PATH);
    createFile.createNewFile();
  }

  // 给文件写入内容
  public static void writeFile() throws IOException {
    FileWriter fileWriter = new FileWriter(CREATE_FILE_PATH);
    fileWriter.write("Hello, this is a test file.\n");
    fileWriter.write("This is the second line.\n");
    fileWriter.close();
  }

  // 读取文件内容
  public static void readFile() throws IOException {
    File file = new File(CREATE_FILE_PATH);
    if (!file.isDirectory()) {
      Files.lines(file.toPath()).forEach(System.out::println);
    }
  }

  // 删除文件
  public static void deleteFile() {
    File file = new File(CREATE_FILE_PATH);
    if (file.exists()) {
      file.delete();
      System.out.println("File deleted successfully.");
    } else {
      System.out.println("File does not exist.");
    }
  }

  // 读取目录下的文件，拼接文件的绝对路径
  public static void readDirectory() {
    File dir = new File(READ_DIR_PATH);
    if (dir.isDirectory()) {
      String[] files = dir.list();
      System.out.println();
      for (int i = 0; i < files.length; i++) {
        files[i] = dir.getAbsolutePath() + "\\" + files[i];
        String filePath = files[i];
        String dirPath = dir.getAbsolutePath();
        String fileIdx = String.format("%03d", i + 1);
        System.out.println(fileIdx + " " + dirPath + "\\" + filePath);
      }
    }
  }
}
