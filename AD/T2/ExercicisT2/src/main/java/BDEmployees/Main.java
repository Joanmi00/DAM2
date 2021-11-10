package BDEmployees;

import Utilitats.Utilidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        Departamentos.menu(connection);
        break;
      
      case 2:
        System.out.println("\n>Mantenimiento tabla de Empleados");
        Empleados.menu(connection);
        break;
      
      default:
        System.out.println("\nERROR");
        break;
    }
  } while (true);
}
}
