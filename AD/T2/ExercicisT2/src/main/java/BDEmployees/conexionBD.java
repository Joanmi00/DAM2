package BDEmployees;

import java.sql.*;

public class conexionBD {

private static Connection laConnexio = null;
private static final int LIMIT = 10;
private static final String BD = "employeesMini";
private static final String encoding = "UTF-8";
private static final String user = "root";
private static final String pass = "root";

public static void connect() {
  try {
    // Carreguem el driver JDBC
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    // Creem la connexió a la base de dades
    String connectionUrl = "jdbc:mysql://localhost:3308/" + BD +
                           "?useUnicode=true&characterEncoding=" + encoding +
                           "&user=" + user +
                           "&password=" + pass;
    
    laConnexio = DriverManager.getConnection(connectionUrl);
    System.out.println("La conexion de SQLite a la BD ha sido establecida.");
    
  } catch (SQLException | ClassNotFoundException e) {
    e.printStackTrace();
  }
}

public static void disConnect() {
  try {
    
    if (laConnexio != null) {
      laConnexio.close();
      System.out.println("La conexion de SQLite a la BD se ha cerrado");
    } else {
      System.out.println("No existe la conexion");
    }
    
  } catch (SQLException e) {
    e.printStackTrace();
  }
}

public static Connection getConnection() {
  return laConnexio;
}

public static int getLIMIT() {
  return LIMIT;
}
}
