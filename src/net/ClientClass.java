package net;

import java.io.*;
import java.net.Socket;

public class ClientClass {

  public static void main(String[] args) throws IOException {
    try {
      Socket socket = new Socket("127.0.0.1", 9999);
      OutputStream outputStream = socket.getOutputStream();
      String message = "Hello, Server!\n";
      // 将消息转换为字节数组并通过输出流发送给服务端
      outputStream.write(message.getBytes());
      System.out.println("Message sent to server: " + message);
      outputStream.flush(); // 确保数据发送
      socket.close(); // 关闭 Socket，避免服务器端异常
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
