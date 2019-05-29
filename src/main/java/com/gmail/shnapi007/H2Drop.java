package com.gmail.shnapi007;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class H2Drop extends H2Base {

  public static void main(String[] args) {

    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {

      System.out.println("Connecting to database...");

      try (Statement stmt = conn.createStatement()) {

        stmt.execute("DROP TABLE USER");
        System.out.println("Dropped table in given database...");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("Goodbye!");
  }

}
