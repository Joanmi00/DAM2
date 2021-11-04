package BDEmployees;

import Utilitats.Utilidades;

import java.sql.*;

import static BDEmployees.conexionBD.getLIMIT;

public class Empleados {

private static final String tabla = "employees";

public static void crear(Connection connection) {
  try {
    // Queremos insertar un nuevo Departamento, pidiendo al usuario los datos a insertar
    System.out.printf("Del empleado a insertar, dame los siguientes datos:");
    String emp_no = Utilidades.leerTexto("Numero de empleado: ");
    String birth_date = Utilidades.leerTexto("Cumpleaños: ");
    String first_name = Utilidades.leerTexto("Nombre: ");
    String last_name = Utilidades.leerTexto("Apellidos: ");
    String gender = Utilidades.leerTexto("Genero: ");
    String hire_date = Utilidades.leerTexto("Fecha de contratacion: ");
    
    String sentenciaPreparada = "INSERT INTO " + tabla + " VALUES (?,?)";
    
    PreparedStatement pst = connection.prepareStatement(sentenciaPreparada);
    
    pst.setString(1, emp_no);
    pst.setString(2, birth_date);
    
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
