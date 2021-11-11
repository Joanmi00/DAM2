package com.ieseljust.ad.myDBMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.ieseljust.ad.myDBMS.ConsoleColors.*;

public class Utilidades {
private final static BufferedReader entradaConsola = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

// PERSONALES

public static void Esqueleto() {
  do {
    System.out.println("\n============= MENU ============" +
                       "\n0. Salir del programa" +
                       "\n1. Mantenimiento tabla de Departamentos" +
                       "\n2. Mantenimiento tabla de Empleados");
    
    switch (Utilidades.leerEntero("[Selecciona una opcio]\n>> ")) {//  EIXIR
      case 0:
        System.out.println("\nADIOS");
        System.exit(0);
        break;
      
      case 1:
        System.out.println("Case 1");
        break;
      
      default:
        System.out.println("\nERROR");
        break;
    }
  } while (true);
}

public static void ERROR() {
  System.out.println(RED + "ERROR" + RESET);
}

// FER

public static void linia(int n) {
  for (int i = 0; i < n; i++)
    System.out.print("-");
  System.out.println();
}

public static void liniadoble(int n) {
  for (int i = 0; i < n; i++)
    System.out.print("=");
  System.out.println();
}

public static void liniaart(int n) {
  for (int i = 0; i < n; i++)
    System.out.print("*");
  System.out.println();
}

// LEER

public static boolean isNoZero(int n) {
  return n != 0;
}

public static String leerTexto(String mensaje) {
  String respuesta;
  do {
    try {
      System.out.print(mensaje);
      respuesta = entradaConsola.readLine();
    } catch (IOException ex) {
      return "";
    }
  } while (respuesta == null);
  return respuesta;
}

public static int leerEntero(String mensaje) {
  int n = 0;
  boolean correcto = false;
  while (!correcto) {
    try {
      n = Integer.parseInt(leerTexto(mensaje));
      correcto = true;
    } catch (NumberFormatException ex) {
      System.out.println("Tienes que introducir un número correcto");
    }
  }
  return n;
}

public static double leerDouble(String mensaje) {
  double n = 0.0;
  boolean correcto = false;
  while (!correcto) {
    try {
      n = Double.parseDouble(leerTexto(mensaje));
      correcto = true;
    } catch (NumberFormatException ex) {
      System.out.println("Tienes que introducir un número correcto");
    }
  }
  return n;
}

public static float leerFloat(String mensaje) {
  float n = 0;
  boolean correcto = false;
  while (!correcto) {
    try {
      n = Float.parseFloat(leerTexto(mensaje));
      correcto = true;
    } catch (NumberFormatException ex) {
      System.out.println("Tienes que introducir un número correcto");
    }
  }
  return n;
}

public static Date leerFecha(String mensaje) {
  Date fecha = new Date();
  DateFormat formatar = new SimpleDateFormat("dd/MM/yyyy"); // Crear un format de data
  boolean correcto = false;
  while (!correcto) {
    try {
      String entrada = leerTexto("Format DD/MM/YYYY: "); // Entrada
      fecha = formatar.parse(entrada); // Creem una data amb la entrada en el format indicat
      correcto = true;
    } catch (NumberFormatException | ParseException ex) {
      System.out.println("Tienes que introducir una fecha correcta");
    }
  }
  return fecha;
}

public static boolean leerBoolean(String mensaje) {
  boolean n;
  n = Boolean.parseBoolean(leerTexto(mensaje));
  // Retornarà true si s'introdueix "true" o "TRUE" i false en qualsevol altre cas
  return n;
}
}
