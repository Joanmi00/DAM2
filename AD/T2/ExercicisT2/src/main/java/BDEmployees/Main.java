package BDEmployees;

import Utilitats.Utilidades;

import java.sql.Connection;

public class Main {
public static void main(String[] args) {
  System.out.println("-------------------------------\n");
  conexionBD.connect();
  Connection connection = conexionBD.getConnection();
  
  do {
    System.out.println("\n============= MENU ============" +
                       "\n0. Salir del programa" +
                       "\n1. Mantenimiento tabla de Departamentos" +
                       "\n2. Mantenimiento tabla de Empleados");
    
    switch (Utilidades.leerEntero("\n[Selecciona una opcion]\n>> ")) {
      case 0: // SALIR
        System.out.println("\nADIOS");
        conexionBD.disConnect();
        System.exit(0);
        break;
      
      case 1:
        System.out.println("\n>Mantenimiento tabla de Departamentos:");
        switchDepartamentos(connection);
        break;
      
      case 2:
        System.out.println("\n>Mantenimiento tabla de Empleados");
        switchEmpleados(connection);
        break;
      
      default:
        System.out.println("\nERROR");
        break;
    }
  } while (true);
}

public static void switchDepartamentos(Connection laConnexion) {
  boolean bucle = true;
  do {
    System.out.println("\n============= DEPARTAMENTOS ============" +
                       "\n0. Volver a Menu Principal" +
                       "\n1. Crear Departamento" +
                       "\n2. Modificar Departamento" +
                       "\n3. Eliminar Departamento" +
                       "\n4. Buscar Departamento");
    
    switch (Utilidades.leerEntero("\n[Selecciona una opcion]\n>> ")) {
      case 0: // SALIR
        System.out.println("\nVolviendo a Menu Principal...");
        bucle = false;
        break;
      
      case 1:
        System.out.println("\n-Crear Departamento:");
        Departamentos.crear(laConnexion);
        break;
      
      case 2:
        System.out.println("\n-Modificar Departamento");
        Departamentos.modificar(laConnexion);
        break;
      
      case 3:
        System.out.println("\n-Eliminar Departamento");
        Departamentos.eliminar(laConnexion);
        break;
      
      case 4:
        System.out.println("\n-Buscar Departamento");
        Departamentos.buscar(laConnexion);
        break;
      
      default:
        System.out.println("\nERROR");
        break;
    }
  } while (bucle);
}

public static void switchEmpleados(Connection laConnexion) {
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
}