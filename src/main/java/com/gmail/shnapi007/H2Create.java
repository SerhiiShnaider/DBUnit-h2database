package com.gmail.shnapi007;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class H2Create extends H2Base {

  public static void main(String[] args) {

    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {

      System.out.println("Connecting to database...");

      try (Statement stmt = conn.createStatement()) {
        String sql = "CREATE TABLE   USER " +
            "(id INTEGER not NULL, " +
            " first VARCHAR(255), " +
            " last VARCHAR(255), " +
            " age INTEGER ) ";

        stmt.executeUpdate(sql);
        System.out.println("Created table in given database...");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("Goodbye!");
  }

}
