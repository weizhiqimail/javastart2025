package org.dazi;

import java.sql.*;

public class Main {
  public static void main(String[] args) {
    connectMySQL();
  }

  public static void connectMySQL() {
    String url = "jdbc:mysql://localhost:3306/javastart";
    String user = "root";
    String password = "12345678";

    try (Connection conn = DriverManager.getConnection(url, user, password);) {
      System.out.println("连接到数据库...");
      // 通过 Connection 对象的 createStatement 方法创建一个 Statement 对象，用于执行 SQL 语句。
      Statement stmt = conn.createStatement();
      stmt.execute("USE javastart");

      ResultSet showTablesRs = stmt.executeQuery("SHOW TABLES");
      while (showTablesRs.next()) {
        System.out.println("查询到的数据表");
        System.out.println(showTablesRs.getString(1));
      }

      // 查询 user 表
      ResultSet queryUserTableRs = stmt.executeQuery("SELECT * FROM user");
      ResultSetMetaData rsmd = queryUserTableRs.getMetaData();
      int columnCount = rsmd.getColumnCount();

      for (int i = 1; i <= columnCount; i++) {
        System.out.printf(rsmd.getColumnName(i) + "\t");
      }
      System.out.println();

      while (queryUserTableRs.next()) {
        for (int i = 1; i <= columnCount; i++) {
          Object value = queryUserTableRs.getObject(i);
          System.out.printf(value + "\t");
        }
        System.out.println();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}