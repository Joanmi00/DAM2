package BDJugadors;

import Utilitats.Utilidades;

import java.sql.*;

public class InserirDadesUsuari {
public static void main(String[] args) {
  Connection con;
  // Statement st = null;
  // String sentSQL;
  
  try {
    
    // Ens connectem
    Class.forName("com.mysql.cj.jdbc.Driver");
    String connectionUrl = "jdbc:mysql://localhost:3308/BDJocs" +
                           "?useUnicode=true&characterEncoding=UTF-8" +
                           "&user=root" +
                           "&password=root";
    con = DriverManager.getConnection(connectionUrl);
    
    // Volem inserir un nou joc però demanant-li
    // al l'usuari les dades a inserir
    int codi_joc = Utilidades.leerEntero("Dis-me el codi del joc: ");
    String nom = Utilidades.leerTexto("Dis-me el nom del Joc: ");
    String desc = Utilidades.leerTexto("Dis-me la descripció del Joc: ");
    int genere = Utilidades.leerEntero("Dis-me el genere del joc: ");
    
    String sentenciaPreparada = "INSERT INTO Joc VALUES (?,?,?,?)";
    // sentSQL = "INSERT INTO Joc VALUES (" +
    //           codi_joc + "," +
    //           nom + "," +
    //           desc + "," +
    //           genere + ");";
    //
    // st.executeUpdate(sentSQL);
    
    PreparedStatement pst = con.prepareStatement(sentenciaPreparada);
    
    pst.setInt(1, codi_joc);
    pst.setString(2, nom);
    pst.setString(3, desc);
    pst.setInt(4, genere);
    
    int res = pst.executeUpdate();
    
    System.out.println("Inserides " + res + " files.");
    
  } catch (SQLException | ClassNotFoundException e) {
    e.printStackTrace();
  }
}
}
