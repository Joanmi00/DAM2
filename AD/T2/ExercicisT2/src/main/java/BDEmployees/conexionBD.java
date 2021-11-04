package BDEmployees;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class conexionBD {

private static Connection connection = null;
private static final int LIMIT = 10;
// Carpeta padre para los archivos a manipular
private static final String resources = "src/main/resources/";

public static void connect() {
  try {
    // Carreguem el driver JDBC
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    Properties prop = new Properties();
    prop.load(new FileInputStream(resources + "/archivo.properties"));
    
    String host = prop.getProperty("host");
    String port = prop.getProperty("port");
    String BD = prop.getProperty("BD");
    
    // Creem la connexió a la base de dades
    String connectionUrl = "jdbc:mysql://" + host + ":" + port + "/" + BD;
    
    connection = DriverManager.getConnection(connectionUrl, prop);
    System.out.println("La conexion de SQLite a la BD ha sido establecida.");
    
  } catch (SQLException | ClassNotFoundException | IOException e) {
    e.printStackTrace();
  }
}

public static void disConnect() {
  try {
    
    if (connection != null) {
      connection.close();
      System.out.println("La conexion de SQLite a la BD se ha cerrado");
    } else {
      System.out.println("No existe la conexion");
    }
    
  } catch (SQLException e) {
    e.printStackTrace();
  }
}

public static Connection getConnection() {
  return connection;
}

public static int getLIMIT() {
  return LIMIT;
}
}
