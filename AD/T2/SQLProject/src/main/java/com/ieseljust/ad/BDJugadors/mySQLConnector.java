package com.ieseljust.ad.BDJugadors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mySQLConnector {
public void probarConnexio() {
  try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String connectionUrl = "jdbc:mysql://localhost:3308/BDJocs" +
                           "?useUnicode=true&characterEncoding=UTF-8" +
                           "&user=root" +
                           "&password=root";
    
    Connection conn = DriverManager.getConnection(connectionUrl);
    
    System.out.println("Ens hem conectat");
    
    ResultSet rs = conn.prepareStatement("show tables").executeQuery();
    
    System.out.println("\nTaules de la BBDD Jocs:\n");
    
    while (rs.next()) {
      String s = rs.getString(1);
      System.out.println(s);
    }
    
    System.out.println("\nRegistres de la taula Genere:\n");
    
    rs = conn.prepareStatement("select * from Genere").executeQuery();
    
    while (rs.next()) {
      String id = rs.getString(1);
      String nom = rs.getString(2);
      String desc = rs.getString(3);
      System.out.println(id + " " + nom + " " + desc);
    }
  } catch (ClassNotFoundException | SQLException e) {
    e.printStackTrace();
  }
}
}
