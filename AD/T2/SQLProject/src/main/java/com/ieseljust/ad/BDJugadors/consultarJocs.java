package com.ieseljust.ad.BDJugadors;

import java.sql.*;

public class consultarJocs {
public static void main(String[] args) {
  Connection conn = null;
  Statement st = null;
  
  String sentSQL;
  try {
    Class.forName("com.mysql.cj.jdbc.Driver");
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
  } catch (SQLException ex) {
    System.out.println("Error " + ex.getMessage());
  } catch (ClassNotFoundException ex) {
    System.out.println("No s'ha trobat el controlador JDBC (" + ex.getMessage() + ")");
  }
}
}