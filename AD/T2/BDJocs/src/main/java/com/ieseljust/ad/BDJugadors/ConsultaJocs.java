package com.ieseljust.ad.BDJugadors;

import java.sql.*;

public class ConsultaJocs {
public static void main(String[] args) {
  Connection conn;
  Statement st;
  String sentSQL;
  
  try {
    // Carreguem el driver JDBC
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    // Creem la connexió a la base de dades
    String connectionUrl = "jdbc:mysql://localhost:3308/BDJocs" +
                           "?useUnicode=true&characterEncoding=UTF-8" +
                           "&user=root" +
                           "&password=root";
    
    conn = DriverManager.getConnection(connectionUrl);
    
    sentSQL = "SELECT * FROM Joc";
    st = conn.createStatement();
    ResultSet rs = st.executeQuery(sentSQL);
    
    while (rs.next()) {
      System.out.print("Joc: " + rs.getString(2) + "\n\t");
      System.out.println("Genere: " + rs.getInt(4));
    }
    
    rs.close();
    conn.close();
    
  } catch (SQLException | ClassNotFoundException e) {
    e.printStackTrace();
  }
}
}
