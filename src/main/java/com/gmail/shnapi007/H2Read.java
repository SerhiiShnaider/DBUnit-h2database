package com.gmail.shnapi007;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class H2Read extends H2Base {

  public static void main(String[] args) {

    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
      Class.forName(JDBC_DRIVER);

      System.out.println("Connecting to database...");

      try (Statement stmt = conn.createStatement()) {
        String sql = "SELECT id, first, last, age FROM USER";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {

          System.out.print("ID: " + rs.getInt("id"));
          System.out.print(", Age: " + rs.getInt("age"));
          System.out.print(", First: " + rs.getString("first"));
          System.out.println(", Last: " + rs.getString("last"));
        }
        rs.close();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("Goodbye!");
  }

}
