package pkg2020_ad_p1_warship;

import Utils.ConsoleColors;
import Utils.Leer;

import java.io.*;
import java.util.Properties;
import java.util.Random;

/**
 * @author Alfre
 */
public class WarShip {

static int MAX_JUGADAS = 100;

private final Random r;
private final Board board;
// private WarShip ws;

public WarShip() {
  r = new Random(System.currentTimeMillis());
  board = new Board(); // Crea tablero
  board.initBoats(); // Sortea los barcos por el tablero
}

private void autoPlay() {
  // Abrir fichero
  // Guardamos la configuracion del tablero en un fichero 'moviments_out.txt'
  try {
    // Usamos archivo warship
    File f = new File("moviments_out.txt");
    FileWriter fw = new FileWriter(f);
    BufferedWriter bw = new BufferedWriter(fw);
    
    
    board.paint();
    
    // Vamos a realizar 50 jugadas aleatorias ...
    for (int i = 1; i <= MAX_JUGADAS; i++) {
      System.out.println(ConsoleColors.GREEN_BRIGHT + "JUGADA: " + i);
      
      int fila, columna;
      do {
        fila = r.nextInt(Board.getBoardDim());
        columna = r.nextInt(Board.getBoardDim());
      } while (board.fired(fila, columna));
      
      int resultat = board.shot(fila, columna);
      if (resultat != Cell.CELL_WATER) {
        board.paint();
      } else {
        System.out.println("(" + fila + "," + columna + ") --> AGUA");
      }
      
      // Obtenemos y escribimos en el archivo warship las propiedades de la partida
      // Numero de movimiento = i
      bw.write(i + ";");
      // fila
      bw.write(fila + ";");
      // columna
      bw.write(columna + ";");
      // resultat
      bw.write(resultat + "\n");
      
      if (board.isEnd_game()) {
        System.out.printf("Joc acabat amb %2d jugades\n", i);
        break;
      }
    }
    bw.close();
  } catch (IOException e) {
    e.printStackTrace();
  }
}

private void play() {
  // Guardamos la configuracion del tablero en un fichero 'moviments_out.txt'
  try {
    // Usamos archivo warship
    File f = new File("moviments_out.txt");
    FileWriter fw = new FileWriter(f);
    BufferedWriter bw = new BufferedWriter(fw);
    
    
    int num_jugadas = 0;
    boolean rendit = false;
    
    String jugada;
    int fila = -1, columna = -1;
    do {
      do {
        jugada = Leer.leerTexto("Dime la jugada en dos letras A3, B5... de A0 a J9: ").toUpperCase();
        if (jugada.equalsIgnoreCase("00")) {
          System.out.println("Jugador rendit");
          rendit = true;
          break;
        }
        if (jugada.length() == 0 || jugada.length() > 2) {
          System.out.println("Format incorrecte.");
          continue;
        }
        
        fila = jugada.charAt(0) - 'A';
        columna = jugada.charAt(1) - '0';
        
      } while (board.fired(fila, columna));
      int resultat = board.shot(fila, columna);
      
      // Obtenemos y escribimos en el archivo warship las propiedades de la partida
      // Numero de movimiento = i
      bw.write((num_jugadas + 1) + ";");
      // fila
      bw.write(fila + ";");
      // columna
      bw.write(columna + ";");
      // resultat
      bw.write(resultat + "\n");
      
      // acaba el joc
      if (rendit) {
        break;
      }
      
      num_jugadas++;
      
      if (resultat != Cell.CELL_WATER) {
        board.paintGame();
      } else {
        System.out.println("(" + fila + "," + columna + ") --> AGUA");
      }
      
      if (board.isEnd_game()) {
        System.out.printf("Joc acabat amb %2d jugades\n", num_jugadas);
        break;
      }
      
      
    } while (num_jugadas < MAX_JUGADAS);
    
    bw.close();
  } catch (IOException e) {
    e.printStackTrace();
  }
}

private void exportar() {
  // Guardamos la configuracion del tablero en un fichero 'warship.properties'
  
  Properties prop = new Properties();
  
  // Obtenemos y escribimos en el archivo warship las propiedades de la partida
  prop.setProperty("board_tam", String.valueOf(Board.getBoardDim()));
  prop.setProperty("num_boats", String.valueOf(Board.getBoardBoatsCount()));
  prop.setProperty("max_jugadas", String.valueOf(MAX_JUGADAS));
  
  // Usamos archivo warship
  try {
    prop.store(new FileOutputStream("warship.properties"), "Fichero de configuracion");
  } catch (IOException e) {
    e.printStackTrace();
  }
  
  /* Guardamos los barcos en boat_out.txt
   *
   * El formato será: boat;dimension;direccion;fila;columna
   * donde la dimensión será un entero que indicará la dimensión.
   * La dirección será 0 horizontal y 1 vertical.
   * La fila y la columna enteros que indican la posición.
   * Ejemplo:
   *
   * 0;5;0;8;0
   * 1;4;0;4;1
   * 2;3;0;2;5
   * 3;2;1;4;9
   * 4;2;0;9;6
   * 5;2;0;2;0
   */
  try {
    // Usamos archivo boat_out.txt
    File f = new File("boat_out.txt");
    FileWriter fw = new FileWriter(f);
    BufferedWriter bw = new BufferedWriter(fw);
    
    // Obtenemos y escribimos en el archivo boat_out.txt las propiedades de la partida
    Boat[] barcosAux = board.getBoats();
    for (int i = 0; i < Board.getBoardBoatsCount(); i++) {
      // ID
      bw.write(i + ";");
      // Dimension
      bw.write(barcosAux[i].getDimension() + ";");
      // Direccion
      if (barcosAux[i].getDireccion() == 0)
        bw.write("0" + ";");
      else
        bw.write("1" + ";");
      // Fila
      bw.write(barcosAux[i].getFila() + ";");
      // Columna
      bw.write(barcosAux[i].getColumna() + "\n");
    }
    
    bw.close();
  } catch (IOException e) {
    e.printStackTrace();
  }
}

private void importar() {
  try {
    // Usamos archivo warship
    Properties prop = new Properties();
    prop.load(new FileInputStream("warship.properties"));
    
    // Obtenemos y escribimos en el archivo warship las propiedades de la partida
    int boardTam = Integer.parseInt(prop.getProperty("board_tam"));
    Board.setBoardDim(boardTam);
    
    int numBoats = Integer.parseInt(prop.getProperty("num_boats"));
    Board.setBoardBoatsCount(numBoats);
    
    MAX_JUGADAS = Integer.parseInt(prop.getProperty("max_jugadas"));
  } catch (IOException e) {
    e.printStackTrace();
  }
  
  // boat_in.txt
  try {
    File f = new File("boat_in.txt");
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    
    board.setBoats(new Boat[Board.getBoardBoatsCount()]);
    while (fr.ready()) {
      String[] linea = br.readLine().split(";");
      int id = Integer.parseInt(linea[0]);
      int dim = Integer.parseInt(linea[1]);
      int dir = Integer.parseInt(linea[2]);
      int fila = Integer.parseInt(linea[3]);
      int columna = Integer.parseInt(linea[4]);
      
      // Crear nuevo barco
      board.getBoats()[id] = new Boat();
      // Dimension
      board.getBoats()[id].setCells(new Cell[dim]);
      board.getBoats()[id].setDimension(dim);
      
      // Posicionamiento y Direccion
      board.getBoats()[id].setFila(fila);
      board.getBoats()[id].setColumna(columna);
      board.getBoats()[id].setDireccion(dir);
    }
    
    br.close();
  } catch (IOException e) {
    e.printStackTrace();
  }
  
  // moviments_in.txt
  int num_movimiento = 0;
  try {
    File f = new File("moviments_in.txt");
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    
    while (fr.ready()) {
      String[] linea = br.readLine().split(";");
      num_movimiento = Integer.parseInt(linea[0]);
      int fila = Integer.parseInt(linea[1]);
      int columna = Integer.parseInt(linea[2]);
      int resultado = Integer.parseInt(linea[3]);
      
      System.out.println(ConsoleColors.GREEN_BRIGHT + "JUGADA: " + num_movimiento);
      
      board.fired(fila, columna);
      if (resultado != Cell.CELL_WATER)
        board.paint();
      else
        System.out.println("(" + fila + "," + columna + ") --> AGUA");
      
      if (board.isEnd_game()) {
        System.out.printf("Joc acabat amb %2d jugades\n", num_movimiento);
        break;
      }
    }
    
    br.close();
  } catch (IOException e) {
    e.printStackTrace();
  }
  
  // seguir jugando
  try {
    // Usamos archivo warship
    File f = new File("moviments_out.txt");
    FileWriter fw = new FileWriter(f);
    BufferedWriter bw = new BufferedWriter(fw);
    
    boolean rendit = false;
    
    String jugada;
    int fila = -1, columna = -1;
    do {
      do {
        jugada = Leer.leerTexto("Dime la jugada en dos letras A3, B5... de A0 a J9: ").toUpperCase();
        if (jugada.equalsIgnoreCase("00")) {
          System.out.println("Jugador rendit");
          rendit = true;
          break;
        }
        if (jugada.length() == 0 || jugada.length() > 2) {
          System.out.println("Format incorrecte.");
          continue;
        }
        
        fila = jugada.charAt(0) - 'A';
        columna = jugada.charAt(1) - '0';
        
      } while (board.fired(fila, columna));
      int resultat = board.shot(fila, columna);
      
      // Obtenemos y escribimos en el archivo warship las propiedades de la partida
      // Numero de movimiento = i
      bw.write((num_movimiento + 1) + ";");
      // fila
      bw.write(fila + ";");
      // columna
      bw.write(columna + ";");
      // resultat
      bw.write(resultat + "\n");
      
      // acaba el joc
      if (rendit) {
        break;
      }
      
      num_movimiento++;
      
      if (resultat != Cell.CELL_WATER) {
        board.paintGame();
      } else {
        System.out.println("(" + fila + "," + columna + ") --> AGUA");
      }
      
      if (board.isEnd_game()) {
        System.out.printf("Joc acabat amb %2d jugades\n", num_movimiento);
        break;
      }
      
    } while (num_movimiento < MAX_JUGADAS);
    
    bw.close();
  } catch (IOException e) {
    e.printStackTrace();
  }
}

public static void main(String[] args) {
  WarShip ws = new WarShip();
  
  int opcio;
  do {
    System.out.println(ConsoleColors.GREEN + "--    Escollir   --");
    System.out.println(ConsoleColors.GREEN + "1. Joc automàtic...");
    System.out.println(ConsoleColors.GREEN + "2. Joc manual......");
    System.out.println(ConsoleColors.GREEN + "3. Exportar configuracio......");
    System.out.println(ConsoleColors.GREEN + "4. Importar configuracio......");
    opcio = Leer.leerEntero(ConsoleColors.CYAN + "Indica el tipus de joc que vols: " + ConsoleColors.RESET);
  } while (opcio < 1 || opcio > 4);
  
  switch (opcio) {
    case 1:
      ws.autoPlay();
      break;
    case 2:
      ws.play();
      break;
    case 3:
      ws.exportar();
      break;
    case 4:
      ws.importar();
      break;
  }
}
}
