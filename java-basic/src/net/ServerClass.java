package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClass {

  public static void main(String[] args) throws IOException {
    try {
      ServerSocket serverSocket = new ServerSocket(9999);
      System.out.println("Server is listening on port 9999");
      while (true) {
        // 接受客户端的连接请求，返回一个 socket 对象与客户端进行通信
        Socket socket = serverSocket.accept();
        System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());
        // 创建一个 BufferedReader 对象，用于读取客户端发送的数据
        // 获取客户端的输入流
        InputStream inputStream = socket.getInputStream();
        // 使用 InputStreamReader 将字节流转换为字符流
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        // 使用 BufferedReader 可以按行读取数据
        BufferedReader reader = new BufferedReader(inputStreamReader);
        // 从客户端读取一行数据
        String request = reader.readLine();
        if (request != null) {
          System.out.println("Received message from client: " + request);
        } else {
          System.out.println("Client disconnected");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}

