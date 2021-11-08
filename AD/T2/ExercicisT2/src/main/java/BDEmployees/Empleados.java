package BDEmployees;

import Utilitats.Utilidades;

import java.sql.*;

import static BDEmployees.conexionBD.getLIMIT;

public class Empleados {

private static final String tabla = "employees";

public static void crear(Connection connection) {
  try {
    // Queremos insertar un nuevo Departamento, pidiendo al usuario los datos a insertar
    System.out.println("Del empleado a insertar, dame los siguientes datos:");
    String emp_no = Utilidades.leerTexto("Numero de empleado: ");
    String birth_date = Utilidades.leerTexto("Cumpleaños: ");
    String first_name = Utilidades.leerTexto("Nombre: ");
    String last_name = Utilidades.leerTexto("Apellidos: ");
    String gender = Utilidades.leerTexto("Genero (F/M): ");
    String hire_date = Utilidades.leerTexto("Fecha de contratacion: ");
    
    String sentenciaPreparada = "INSERT INTO " + tabla + " VALUES (?,?,?,?,?,?)";
    
    PreparedStatement pst = connection.prepareStatement(sentenciaPreparada);
    
    pst.setString(1, emp_no);
    pst.setString(2, birth_date);
    pst.setString(3, first_name);
    pst.setString(4, last_name);
    pst.setString(5, gender);
    pst.setString(6, hire_date);
    
    int res = pst.executeUpdate();
    
    System.out.println("\nInsertadas " + res + " filas.");
  } catch (SQLException e) {
    e.printStackTrace();
  }
}

public static void modificar(Connection connection) {
  try {
    // Queremos insertar un nuevo Departamento, pidiendo al usuario los datos a insertar
    System.out.println("Del departamento a modificar, dame los siguientes datos:");
    String old_dept_no = Utilidades.leerTexto("Numero actual: ");
    String dept_no = Utilidades.leerTexto("Numero nuevo: ");
    String dept_name = Utilidades.leerTexto("Nombre nuevo: ");
    
    String sentenciaPreparada = "UPDATE " + tabla + " SET  `dept_no` = (?), `dept_name` = (?) WHERE (`dept_no` = (?))";
    
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
}

public static void buscar(Connection connection) {
}
}
