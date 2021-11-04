package BDEmployees;

import Utilitats.Utilidades;

import java.sql.*;

public class Departamentos {

private static final String tabla = "departments";

public static void crear(Connection connection) {
  try {
    // Queremos insertar un nuevo Departamento, pidiendo al usuario los datos a insertar
    String dept_no = Utilidades.leerTexto("Dime el numero del departamento: ");
    String dept_name = Utilidades.leerTexto("Dime el nombre del departamento: ");
    
    String sentenciaPreparada = "INSERT INTO " + tabla + " VALUES (?,?)";
    
    PreparedStatement pst = connection.prepareStatement(sentenciaPreparada);
    
    pst.setString(1, dept_no);
    pst.setString(2, dept_name);
    
    int res = pst.executeUpdate();
    
    System.out.println("Inserides " + res + " files.");
  } catch (SQLException e) {
    e.printStackTrace();
  }
}

public static void modificar(Connection connection) {
}

public static void eliminar(Connection connection) {
}

public static void buscar(Connection connection) {
}
}
