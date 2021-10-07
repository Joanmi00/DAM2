package Prac2Exer1;

import utilitats.ConsoleColors;

public class Main {
public static int MAX_FILES_BY_COLUMN = 5;

public static void main(String[] args) {
  String[] nombresArchivos = {"PepeAndres.txt", "Elcapo.txt", "Nano.txt", "Tete.txt", "Pipontiac.txt", "Potilinsoa.txt"};
  
  listarLista(nombresArchivos);
  System.out.println();
  listarColumnas(nombresArchivos);
  System.out.println();
  listarTabla(nombresArchivos);
}

public static void app(String directorio, int modoVisualizacion) {

}

// Vista de lista
public static void listarLista(String[] filenames) {
  System.out.print(ConsoleColors.RED);
  
  //bucle para mostrar salidas
  for (String filename : filenames)
    System.out.println(filename);
  
  System.out.print(ConsoleColors.RESET);
}

// Vista de columnas
public static void listarColumnas(String[] filenames) {
  int columnas = (filenames.length / MAX_FILES_BY_COLUMN) + 1;
  String[][] salida = new String[MAX_FILES_BY_COLUMN][columnas];
  for (int i = 0; i < filenames.length; i++) {
    salida[i % MAX_FILES_BY_COLUMN][i / MAX_FILES_BY_COLUMN] = filenames[i];
  }
  
  System.out.print(ConsoleColors.GREEN);
  //bucle para mostrar salidas
  for (int i = 0; i < MAX_FILES_BY_COLUMN; i++) {
    for (int j = 0; j < columnas; j++)
      System.out.printf("%20.20s", salida[i][j]);
    System.out.println();
  }
  System.out.print(ConsoleColors.RESET);
}

// Vista de tabla
public static void listarTabla(String[] filenames) {
  System.out.print(ConsoleColors.BLUE);
  
  //bucle para mostrar salidas
  for (String filename : filenames) {
    System.out.printf("%20.20s", filename + " - ");
    System.out.println();
  }
  
  System.out.print(ConsoleColors.RESET);
}
}
