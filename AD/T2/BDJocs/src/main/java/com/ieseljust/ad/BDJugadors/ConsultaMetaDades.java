package com.ieseljust.ad.BDJugadors;

import Utilitats.ConsoleColors;

import java.sql.*;
import java.util.ArrayList;

public class ConsultaMetaDades {
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
    
    
    // Obtenim les metadades de la BD amb getMetaDada
    DatabaseMetaData dbmd = conn.getMetaData();
    
    // Pintem la capçalera de la taula de resultats
    System.out.println(dbmd.getDriverName());
    System.out.println(dbmd.getDatabaseProductName());
    System.out.println(dbmd.getURL());
    System.out.println(dbmd.getUserName());
    
    
    // I recorrem els resultats amb un resultset:
    ResultSet rsmd = dbmd.getTables("BDJocs", null, null, null);
    System.out.println("\n================= Taula BDJocs =================");
    while (rsmd.next()) {
      System.out.printf("%-15s %-15s %-15s%n",
      rsmd.getString(1),
      rsmd.getString(3),
      rsmd.getString(4));
    }
    rsmd.close(); // Tanquem el resultset
    
    
    // I recorrem els resultats amb un resultset:
    rsmd = dbmd.getColumns("BDJocs", null, "Genere", null);
    System.out.println("\n================= Columnes de Taula Genere =================");
    while (rsmd.next()) {
      System.out.printf("%-15s %-15s %-15s %-15s%n",
      rsmd.getString(3),
      rsmd.getString(4),
      rsmd.getString(6),
      rsmd.getInt(11));
    }
    rsmd.close(); // Tanquem el resultset
    
    
    /*// Calculem les claus primàries de la taula i les afegim a un ArrayList
    ResultSet rspk = dbmd.getPrimaryKeys("BDJocs", null, taula);
    ArrayList<String> pks = new ArrayList<String>();
    
    while (rspk.next())
      pks.add(rspk.getString(4));
    
    rspk.close(); // Tanquem el resultset*/
    
    
    // Calculant les claus externes i les guardem en dos arraylist,
    // Un per a la clau, i altre per a la taula a la que referencia
    ResultSet rsfk = dbmd.getImportedKeys("BDJocs", null, taula);
    ArrayList<String> fks = new ArrayList<String>();
    ArrayList<String> fksExt = new ArrayList<String>();
    
    while (rsfk.next()) {
      fks.add(rsfk.getString(8)); // Guarda el camp de la Clau Externa
      fksExt.add(rsfk.getString(3)); // Guarda la taula a que fa referéncia
    }
    rsfk.close(); // Tanquem el resultset
    
    
    // Obtenim les columnes de la taula i juntem la informació obtinguda
    ResultSet columnes = dbmd.getColumns("BDJocs", null, taula, null);
    System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "----------- TAULA " + taula + " -----------------------" + ConsoleColors.RESET);
    System.out.println(ConsoleColors.CYAN_BRIGHT + String.format("%-25s %-15s %-15s", "Atribut/Claus", "Tipus", "Pot ser nul?"));
    System.out.println("-------------------------------------------------------" + ConsoleColors.RESET);
    
    while (columnes.next()) {
      String columnName = columnes.getString(4);
      if (pks.contains(columnName))
        columnName = ConsoleColors.WHITE_UNDERLINED + ConsoleColors.WHITE_BOLD_BRIGHT + columnName + "(PK)" + ConsoleColors.RESET;
      if (fks.contains(columnName))
        columnName = ConsoleColors.CYAN_BOLD_BRIGHT + columnName + "(FK) -->      " + fksExt.get(fks.indexOf(columnName)) + ConsoleColors.RESET;
      StringStringtipus = columnes.getString(6);
      nullable = columnes.getString(18);
      System.out.println(String.format("%-25s %-15s %15s", columnName, tipus, nullable));
    }
    
  } catch (SQLException | ClassNotFoundException e) {
    e.printStackTrace();
  }
}
}
