package BDEmployees;

import java.sql.*;

import static BDEmployees.conexionBD.getLIMIT;

public class Empleados {

private static final String tabla = "employees";

public static void crear(Connection laConnexio) {
  Statement st;
  String sentSQL;
  
  try {
    sentSQL = "SELECT count(*) FROM " + tabla + " LIMIT " + getLIMIT() + ";";
    st = laConnexio.createStatement();
    ResultSet rs = st.executeQuery(sentSQL);
    
    System.out.println(rs);
    
    while (rs.next()) {
      System.out.print("Joc: " + rs.getString(2) + "\n\t");
      System.out.println("Genere: " + rs.getInt(4));
    }
  } catch (SQLException e) {
    e.printStackTrace();
  }
}

public static void modificar(Connection laConnexio) {
}

public static void eliminar(Connection laConnexio) {
}

public static void buscar(Connection laConnexio) {
}
}
