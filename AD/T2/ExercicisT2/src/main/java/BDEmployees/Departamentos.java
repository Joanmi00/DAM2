package BDEmployees;

import Utilitats.Utilidades;

import java.sql.*;

public class Departamentos {

private static final String tabla = "departments";

public static void crear(Connection connection) {
  try {
    // Queremos insertar un nuevo Departamento, pidiendo al usuario los datos a insertar
    System.out.println("Del departamento a insertar, dame los siguientes datos:");
    String dept_no = Utilidades.leerTexto("Numero: ");
    String dept_name = Utilidades.leerTexto("Nombre: ");
    
    String sentenciaPreparada = "INSERT INTO " + tabla + " VALUES (?,?);";
    
    PreparedStatement pst = connection.prepareStatement(sentenciaPreparada);
    
    pst.setString(1, dept_no);
    pst.setString(2, dept_name);
    
    int res = pst.executeUpdate();
    
    System.out.println("\nInsertadas " + res + " filas.");
    
  } catch (SQLException e) {
    e.printStackTrace();
  }
}

public static void modificar(Connection connection) {
  try {
    // Queremos modificar un departamento existente, pidiendo al usuario los datos a modificar
    System.out.println("Del departamento a modificar, dame los siguientes datos:");
    String old_dept_no = Utilidades.leerTexto("Numero actual: ");
    String dept_no = Utilidades.leerTexto("Numero nuevo: ");
    String dept_name = Utilidades.leerTexto("Nombre nuevo: ");
    
    String sentenciaPreparada = "UPDATE " + tabla + " SET  `dept_no` = (?), `dept_name` = (?) WHERE `dept_no` = (?);";
    
    PreparedStatement pst = connection.prepareStatement(sentenciaPreparada);
    
    pst.setString(1, dept_no);
    pst.setString(2, dept_name);
    pst.setString(3, old_dept_no);
    
    int res = pst.executeUpdate();
    
    System.out.println("\nModificadas " + res + " filas.");
    
  } catch (SQLIntegrityConstraintViolationException e) {
    System.out.println("\n" + e.getMessage());
  } catch (SQLException e) {
    e.printStackTrace();
  }
}

public static void eliminar(Connection connection) {
  try {
    String dept_no = Utilidades.leerTexto("Dime el numero del departamento a eliminar: ");
    
    String sentenciaPreparada = "DELETE FROM departments WHERE dept_no = (?);";
    
    PreparedStatement pst = connection.prepareStatement(sentenciaPreparada);
    
    pst.setString(1, dept_no);
    
    int res = pst.executeUpdate();
    
    System.out.println("\nEliminadas " + res + " filas.");
    
  } catch (SQLException e) {
    e.printStackTrace();
  }
}

public static void buscar(Connection connection) {
  try {
    String sentSQL = "SELECT * FROM departments";
    
    Statement st = connection.createStatement();
    
    ResultSet res = st.executeQuery(sentSQL);
    
    while (res.next()) {
      System.out.println("Numero: " + res.getString("dept_no") + "\t");
      System.out.println("Nom: " + res.getString("dept_name"));
    }
    
    res.close();
    
  } catch (SQLException throwables) {
    throwables.printStackTrace();
  }
}
}
