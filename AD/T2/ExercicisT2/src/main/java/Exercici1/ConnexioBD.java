package Exercici1;

import java.sql.*;

public class ConnexioBD {

Connection laConnexio = null;

public void connect() {
  try {
    
    String url = "jdbc:sqlite:/src/main/resources/users.db";
    laConnexio = DriverManager.getConnection(url);
    System.out.println("Connection to SQLite has been established.");
    
  } catch (SQLException e) {
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

/**
 * @param user
 * @return 0 if user doesent exist
 * @return 1 if user does exist
 */
public boolean validaUser(String user) {
  boolean trobat = false;
  try {
    String sentSQL = "SELECT * FROM users WHERE username= '" + user + "';";
    Statement st = laConnexio.createStatement();
    ResultSet rs = st.executeQuery(sentSQL);
    
    if (rs.next()) trobat = true;
    
    rs.close();
    
  } catch (SQLException e) {
    e.printStackTrace();
  }
  
  return trobat;
}

/**
 * @param user
 * @return 0 if all correct
 * @return 1 if wrong user
 * @return 2 if wrong password
 */
public int validaPass(String user, String pass) {
  int res = -1;
  // TODO
  if (validaUser(user)) {
    try {
      String sentSQL = "SELECT * FROM users WHERE username= '" + user + "';";
      Statement st = laConnexio.createStatement();
      ResultSet rs = st.executeQuery(sentSQL);
      
      //if (rs.next()) trobat = true;
      
      rs.close();
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  return res;
}

/**
 * @param user
 * @return -1 if user has NOT been inserted
 * @return >=0 number of rows afected
 */
public int insertUser(String user, String pass) {
  int res = -1;
  
  if (!validaUser(user)) {
    try {
      String sentSQL = "INSERT INTO users values ('" + user + "','" + Xifrar.md5(pass) + "');";
      Statement st = laConnexio.createStatement();
      res = st.executeUpdate(sentSQL);
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  return res;
}
}
