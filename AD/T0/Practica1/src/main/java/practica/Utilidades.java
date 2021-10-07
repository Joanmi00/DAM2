package practica;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utilidades {
private final static BufferedReader entradaConsola = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

// PERSONALES

public static void Menu() {
  System.out.println("\n============= MENU ============");
  System.out.println("0. Salir del programa");
  System.out.println("1. Listar");
  System.out.println("2. Dibujar");
  System.out.println("3. Perimetros");
  System.out.println("4. Areas");
  System.out.println("5. Escalar");
  System.out.println("6. Mover");
  System.out.println("7. Desplazar");
  System.out.println("8. Ordenar ");
  System.out.println("===============================");
}

public static void Esqueleto() {
  do {
    Utilidades.Menu();
    if (Utilidades.leerEntero("[Selecciona una opcio]\n>> ") == 0) { //  EIXIR
      System.out.println("\nADEU");
      System.exit(0);
    } else {
      System.out.println("\nERROR");
    }
  } while (true);
}

// RANDOMS

public static int numAleatorioRangoInt(int min, int max) {
  return (int) ((Math.random() * (max - min)) + min);
}

public static double numAleatorioRangoDouble(double min, double max) {
  return (Math.random() * (max - min)) + min;
}

public static double getRandomValue(final Random random,
                                    final int lowerBound,
                                    final int upperBound,
                                    final int decimalPlaces) {
  
  if (lowerBound < 0 || upperBound <= lowerBound || decimalPlaces < 0) {
    throw new IllegalArgumentException("Put error message here");
  }
  
  final double dbl =
      ((random == null ? new Random() : random).nextDouble() //
           * (upperBound - lowerBound))
          + lowerBound;
  return Double.parseDouble(String.format("%." + decimalPlaces + "f", dbl));
/* Test Code:

final Random rnd = new Random();

for(int decpl = 0; decpl < 3; decpl++){
  for(int low = 0; low < 2; low++){
    for(int high = low + 1; high < low + 3; high++){
      System.out.println("Random Value between " + low + " and "
                             + high + " with " + decpl + " decimal places:");
      System.out.println(getRandomValue(rnd, low, high, decpl));
    }
  }
}
*/
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
      System.out.println("Tienes que introducir un numero correcto");
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
      System.out.println("Tienes que introducir un numero correcto");
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
      System.out.println("Tienes que introducir un numero correcto");
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
  // Retornara true si si introdueix "true" o "TRUE" i false en qualsevol altre cas
  return n;
}
}
