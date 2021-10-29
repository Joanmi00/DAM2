package BDEmployees;

import java.sql.*;

public class conexionBD {
Connection laConnexio = null;
int LIMIT = 10;
String BD = "employeesMini";
String user = "root";
String pass = "root";

public void connect() {
  Connection conn;
  Statement st;
  String sentSQL;
  try {
    // Carreguem el driver JDBC
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    // Creem la connexió a la base de dades
    String connectionUrl = "jdbc:mysql://localhost:3308/" + BD +
                           "?useUnicode=true&characterEncoding=UTF-8" +
                           "&user=" + user +
                           "&password=" + pass;
    
    conn = DriverManager.getConnection(connectionUrl);
    System.out.println("La conexion a la BD ha sido establecida.");
    
    sentSQL = "SELECT count(*) FROM employees LIMIT " + LIMIT + ";";
    st = conn.createStatement();
    ResultSet rs = st.executeQuery(sentSQL);
    
    System.out.println(rs);
    
    /*while (rs.next()) {
      System.out.print("Joc: " + rs.getString(2) + "\n\t");
      System.out.println("Genere: " + rs.getInt(4));
    }*/
    
    rs.close();
    conn.close();
    
  } catch (SQLException | ClassNotFoundException e) {
    e.printStackTrace();
  }
}

public void disConnect() {
  try {
    
    if (laConnexio != null) {
      laConnexio.close();
      System.out.println("Connection to SQLite has been close.");
    }
    
  } catch (SQLException e) {
    e.printStackTrace();
  }
}

public Connection getConnection() {
  return null;
}
}
