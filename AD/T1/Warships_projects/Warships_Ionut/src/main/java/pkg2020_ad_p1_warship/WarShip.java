package pkg2020_ad_p1_warship;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Random;

import Utils.ConsoleColors;
import Utils.Leer;

/**
 * @author joange
 */
public class WarShip {
public static Properties config = new Properties();

public static OutputStream configOutput = null;

/**
 * @param args the command line arguments
 */
final static int MAX_JUGADAS = 100;

public static int getMaxJugadas() {
  return MAX_JUGADAS;
}

private Random r;
private Board board;
private WarShip ws;

public WarShip() {
  r = new Random(System.currentTimeMillis());
  board = new Board();
  board.initBoats();
  GuardarPropTablero();
  
}

private void autoPlay() {
  
  board.paint();
  
  // Vamos a realizar 50 jugadas aleatorias ...
  for (int i = 1; i <= MAX_JUGADAS; i++) {
    System.out.println(ConsoleColors.GREEN_BRIGHT + "JUGADA: " + i);
    
    int fila, columna;
    do {
      fila = r.nextInt(Board.getBOARD_DIM());
      columna = r.nextInt(Board.getBOARD_DIM());
    } while (board.fired(fila, columna));
    
    if (board.shot(fila, columna) != Cell.CELL_WATER) {
      board.paint();
    } else {
      System.out.println("(" + fila + "," + columna + ") --> AGUA");
    }
    
    if (board.getEnd_Game()) {
      System.out.printf("Joc acabat amb %2d jugades\n", i);
      break;
    }
  }
}

private void play() {
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
    
    // acaba el joc
    if (rendit) {
      break;
    }
    
    num_jugadas++;
    
    if (board.shot(fila, columna) != Cell.CELL_WATER) {
      board.paintGame();
    } else {
      System.out.println("(" + fila + "," + columna + ") --> AGUA");
    }
    
    if (board.getEnd_Game()) {
      System.out.printf("Joc acabat amb %2d jugades\n", num_jugadas);
      break;
    }
    
  } while (num_jugadas < MAX_JUGADAS);
  
}

public void GuardarPropTablero() {
  try {
    configOutput = new FileOutputStream("warship.properties");
    config.setProperty("board_tam", String.valueOf(board.getBOARD_DIM()));
    config.setProperty("num_boats", String.valueOf(board.getBOARD_BOATS_COUNT()));
    config.setProperty("max_value", String.valueOf(ws.getMaxJugadas()));
    
  } catch (Exception e) {
    System.out.println("Error para guardar el fichero de configuración");
  } finally {
    try {
      configOutput.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
  
}

public static void main(String[] args) {
  // TODO code application logic here
  WarShip ws = new WarShip();
  
  int opcio;
  do {
    System.out.println(ConsoleColors.GREEN + "--    Escollir   --");
    System.out.println("Cargar fichero de configuración");
    System.out.println(ConsoleColors.GREEN + "1. Joc automàtic...");
    System.out.println(ConsoleColors.GREEN + "2. Joc manual......");
    opcio = Leer.leerEntero(ConsoleColors.CYAN + "Indica el tipus de joc que vols: " + ConsoleColors.RESET);
  } while (opcio < 1 || opcio > 2);
  
  switch (opcio) {
    case 1:
      ws.autoPlay();
      break;
    case 2:
      ws.play();
      break;
  }
  
}

}
