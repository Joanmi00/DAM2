package BDEmployees;

import Utilitats.Utilidades;

import java.sql.*;

public class Empleados {

private static final String tabla = "employees";

public static void menu(Connection laConnexion) {
  boolean bucle = true;
  do {
    System.out.println("\n============= DEPARTAMENTOS ============" +
                       "\n0. Volver a Menu Principal" +
                       "\n1. Crear Empleado" +
                       "\n2. Modificar Empleado" +
                       "\n3. Eliminar Empleado" +
                       "\n4. Buscar Empleado");
    
    switch (Utilidades.leerEntero("\n[Selecciona una opcion]\n>> ")) {
      case 0: // SALIR
        System.out.println("\nVolviendo a Menu Principal...");
        bucle = false;
        break;
      
      case 1:
        System.out.println("\n-Crear Empleado:");
        Empleados.crear(laConnexion);
        break;
      
      case 2:
        System.out.println("\n-Modificar Empleado");
        Empleados.modificar(laConnexion);
        break;
      
      case 3:
        System.out.println("\n-Eliminar Empleado");
        Empleados.eliminar(laConnexion);
        break;
      
      case 4:
        System.out.println("\n-Buscar Empleado");
        Empleados.buscar(laConnexion);
        break;
      
      default:
        System.out.println("\nERROR");
        break;
    }
  } while (bucle);
}

public static void crear(Connection connection) {
  try {
    // Queremos insertar un nuevo Departamento, pidiendo al usuario los datos a insertar
    System.out.println("Del empleado a insertar, dame los siguientes datos:");
    int emp_no = Utilidades.leerEntero("Numero de empleado: ");
    Date birth_date = Date.valueOf(Utilidades.leerTexto("Cumpleaños (ej. 1956-02-26): "));
    String first_name = Utilidades.leerTexto("Nombre: ");
    String last_name = Utilidades.leerTexto("Apellido: ");
    String gender;
    do {
      gender = Utilidades.leerTexto("Genero (F/M): ").toUpperCase();
    } while (!gender.equals("M") && !gender.equals("F") );
    Date hire_date = Date.valueOf(Utilidades.leerTexto("Fecha de contratacion (ej. 1956-02-26): "));
    
    String sentenciaPreparada = "INSERT INTO " + tabla + " VALUES (?,?,?,?,?,?)";
    PreparedStatement pst = connection.prepareStatement(sentenciaPreparada);
    pst.setInt(1, emp_no);
    pst.setDate(2, birth_date);
    pst.setString(3, first_name);
    pst.setString(4, last_name);
    pst.setString(5, gender);
    pst.setDate(6, hire_date);
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
    
    String sentenciaPreparada = "UPDATE " + tabla + " SET  dept_no = (?), dept_name = (?) WHERE dept_no = (?);";
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
    String dept_no = Utilidades.leerTexto("Dime el numero del empleado a eliminar: ");
    
    String sentenciaPreparada = "DELETE FROM " + tabla + " WHERE emp_no = (?);";
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
    String dept_no = Utilidades.leerTexto("Dime el numero del departamento a buscar: ");
    
    String sentenciaPreparada = "SELECT * FROM " + tabla + " WHERE dept_no = ?;";
    PreparedStatement pst = connection.prepareStatement(sentenciaPreparada);
    pst.setString(1, dept_no);
    ResultSet res = pst.executeQuery();
    
    if (res.next()) {
      System.out.println("Numero: " + res.getString("dept_no") + "\t");
      System.out.println("Nombre: " + res.getString("dept_name"));
    } else System.out.println("No hay ningun departamento con ese numero");
    
    res.close();
    
  } catch (SQLException e) {
    e.printStackTrace();
  }
}
}
