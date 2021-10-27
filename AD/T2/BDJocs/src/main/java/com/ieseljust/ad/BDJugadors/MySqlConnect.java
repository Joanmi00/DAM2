package com.ieseljust.ad.BDJugadors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlConnect {
public static void main(String[] args) {
  Connection conn;
  
  try {
    // Carreguem el driver JDBC
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    // Creem la connexió a la base de dades
    String connectionUrl = "jdbc:mysql://localhost:3308/BDJocs" +
                           "?useUnicode=true&characterEncoding=UTF-8" +
                           "&user=root" +
                           "&password=root";
    conn = DriverManager.getConnection(connectionUrl);
    ResultSet rs = conn.prepareStatement("show tables").executeQuery();
    
    System.out.println("\nTaules de la base de dades:\n");
    
    while (rs.next()) {
      String s = rs.getString(1);
      System.out.println(s);
    }
    
    System.out.println("\nRegistres de la taula Genere:\n");
    
    rs = conn.prepareStatement("select * from Genere").executeQuery();
    
    while (rs.next()) {
      String id = rs.getString(1);
      String nom = rs.getString(2);
      String des = rs.getString(3);
      System.out.println(id + " " + nom + " " + des);
    }
  } catch (SQLException | ClassNotFoundException e) {
    e.printStackTrace();
  }
}
}
