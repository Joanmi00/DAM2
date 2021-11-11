package com.ieseljust.ad.myDBMS;

import java.sql.*;
import java.util.Scanner;

import static com.ieseljust.ad.myDBMS.ConsoleColors.*;
import static com.ieseljust.ad.myDBMS.Utilidades.*;

class connectionManager {

private static Connection connection = null;

private static String server = "localhost";
private static String port = "3308";
private static String user = "root";
private static String pass = "root";

/**
 * Crear una connexió a la base de dades, i retorna aquesta o null, si no s'ha pogut connectar.
 */
public static Connection connectDBMS(String serverP, String portP, String userP, String passP) {
  if (!serverP.isBlank()) setServer(serverP);
  if (!portP.isBlank()) setPort(portP);
  if (!userP.isBlank()) setUser(userP);
  if (!passP.isBlank()) setPass(passP);
  
  try {
    // Carreguem el driver JDBC
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    // Creem la connexió a la base de dades
    String connectionUrl = "jdbc:mysql://" + getServer() + ":" + getPort() + "/" +
                           "?useUnicode=true&characterEncoding=UTF-8" +
                           "&user=" + getUser() +
                           "&password=" + getPass();
    
    setConnection(DriverManager.getConnection(connectionUrl));
    System.out.println("La conexion de SQLite a la BD ha sido establecida.");
    
  } catch (SQLException | ClassNotFoundException e) {
    // e.printStackTrace();
    ERROR();
    return null;
  }
  
  // Retornar la connexió
  return getConnection();
}

public static void showInfo() {
  // TODO: Mostra la informació del servidor a partir de les metadades
  // - Nom del SGBD
  // - Driver utilitzat
  // - URL de connexió
  // - Nom de l'usuari connectat
  
  // Recordeu el tractament d'errors
}

public static void showDatabases() {
  // TODO: Mostrem les bases de dades del servidor, bé des del catàleg o amb una consulta
  
  // Recordeu el tractament d'errors
}

public static void startShell() {
  
  Scanner keyboard = new Scanner(System.in);
  String command;
  
  do {
    
    command = leerTexto(GREEN_BOLD_BRIGHT + "# (" + getUser() + ") on " +
                        getServer() + ":" + getPort() + "> " + RESET);
    
    switch (command) {
      case "sh db":
      case "show databases":
        showDatabases();
        break;
      
      case "info":
        showInfo();
        break;
      
      case "quit":
        break;
      
      default:
        // Com que no podem utilitzar expressions
        // regulars en un case (per capturar un "use *")
        // busquem aquest cas en el default:
        String[] subcommand = command.split(" ");
        switch (subcommand[0]) {
          case "use":
            // TODO: Creem un objecte de tipus databaseManager per connectar-nos a
            //  la base de dades i iniciar una shell de manipulació de BD.
            System.out.println("use");
            break;
          
          case "test":
            System.out.println("test");
            break;
          
          default:
            System.out.println(RED + "Unknown option" + RESET);
            break;
        }
    }
    
  } while (!command.equals("quit"));
  
}

// GETTERS Y SETTERS

public static Connection getConnection() {
  return connection;
}

public static void setConnection(Connection connection) {
  connectionManager.connection = connection;
}

public static String getServer() {
  return server;
}

public static void setServer(String server) {
  connectionManager.server = server;
}

public static String getPort() {
  return port;
}

public static void setPort(String port) {
  connectionManager.port = port;
}

public static String getUser() {
  return user;
}

public static void setUser(String user) {
  connectionManager.user = user;
}

public static String getPass() {
  return pass;
}

public static void setPass(String pass) {
  connectionManager.pass = pass;
}
}