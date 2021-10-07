package pkg2020_ad_p1_warship;

import Utils.ConsoleColors;

import java.util.Objects;

/**
 * @author Alfre
 */
public class Board {

// Constantes del tablero
private static int BOARD_DIM = 10;
private static int BOARD_BOATS_COUNT = 5;

// Propiedades de la clase
private Cell[][] cells;
private Boat[] boats;
private int[] dimensiones = {5, 4, 3, 2, 2};

private boolean end_game;

public Board() {
  // Crea la matriz de celdas del tablero
  setCells(new Cell[getBoardDim()][getBoardDim()]);
  // inicializa la matriz a agua
  for (int i = 0; i < getBoardDim(); i++) {
    for (int j = 0; j < getBoardDim(); j++) {
      getCells()[i][j] = new Cell(i, j);
    }
  }
  
  setEnd_game(false);
}

// comprueba si ha acabado el juego
private void testEnd() {
  for (Boat boat : getBoats()) {
    if (boat.getEstado() != Boat.getBoatSunken())
      return;
  }
  setEnd_game(true);
}

// Crea los botes y los posiciona
public void initBoats() {
  setBoats(new Boat[getBoardBoatsCount()]);
  for (int i = 0; i < getBoardBoatsCount(); i++) {
    getBoats()[i] = new Boat();
    getBoats()[i].setBoat(getDimensiones()[i], this);
    getBoats()[i].viewCells(); //Muestra por pantalla la posición que ocupan
  }
}

//Devuelve el objeto Cell que ocupa una fila y coulmna
public Cell getCell(int fila, int columna) {
  return getCells()[fila][columna];
}

//Devuelve un valor válido dentro del tablero
public int fitValueToBoard(int value) {
  if (value <= 0) return 0;
  if (value > getBoardDim() - 1) return getBoardDim() - 1;
  return value;
}

//El jugador lanza una bomba sobre el tablero
public int shot(int fila, int columna) {
  System.out.print(ConsoleColors.PURPLE + "---- ");
  
  //Sacammos el objeto Boat que hay en la celda bombardeada
  Boat boat = getCells()[fila][columna].getBoat();
  if (boat != null) {
    //Si en la celda hay un barco, llamamos a su método touch (tocado)
    boat.touchBoat(fila, columna);
    testEnd();
    
  } else { // marco la casilla como disparada
    getCells()[fila][columna].setFired();
  }
  System.out.print(ConsoleColors.GREEN + " [" + fila + "], [" + columna + "] --> " +
                       getCells()[fila][columna].getContainsString());
  System.out.println(ConsoleColors.PURPLE + " ----" + ConsoleColors.RESET);
  return getCells()[fila][columna].getContains();
}

// indica si una cel·la ha estat o no disparada, per no repetir la jugada
public boolean fired(int fila, int columna) {
  return getCells()[fila][columna].getContains() != Cell.CELL_WATER &&
             getCells()[fila][columna].getContains() != Cell.CELL_BOAT;
}

// Para mostrar el tablero por pantalla
public void paint() {
  // Cabecera ...
  System.out.print("      ");
  for (int k = 0; k < Board.getBoardDim(); k++) {
    System.out.print(ConsoleColors.BLUE + k + " ");
  }
  System.out.println();
  char c = 'A';
  for (int i = 0; i < Board.getBoardDim(); i++) {
    System.out.print((ConsoleColors.BLUE + c++) + " <-- " + ConsoleColors.RESET);
    for (int j = 0; j < Board.getBoardDim(); j++) {
      System.out.print(getCells()[i][j].getContainsString() + " ");
    }
    System.out.println(ConsoleColors.BLUE + " -->");
  }
  
  System.out.print("      ");
  for (int k = 0; k < Board.getBoardDim(); k++) {
    System.out.print(ConsoleColors.BLUE + k + " ");
  }
  System.out.println(ConsoleColors.RESET);
}

// Para mostrar el tablero por pantalla durante el juego (sin mostrar los barcos)
public void paintGame() {
  // Cabecera ...
  System.out.print("  <-- ");
  for (int k = 0; k < Board.getBoardDim(); k++) {
    System.out.print(k + " ");
  }
  System.out.println(" -->");
  char c = 'A';
  for (int i = 0; i < Board.getBoardDim(); i++) {
    System.out.print((c++) + " <-- ");
    for (int j = 0; j < Board.getBoardDim(); j++) {
      if (Objects.equals(getCells()[i][j].getContainsString(), Cell.CELL_BOAT_CHAR))
        System.out.print("_ ");
      else
        System.out.print(getCells()[i][j].getContainsString() + " ");
    }
    System.out.println(" -->");
  }
}


// GETTERS Y SETTERS

public static int getBoardDim() {
  return BOARD_DIM;
}

public static void setBoardDim(int boardDim) {
  BOARD_DIM = boardDim;
}

public static int getBoardBoatsCount() {
  return BOARD_BOATS_COUNT;
}

public static void setBoardBoatsCount(int boardBoatsCount) {
  BOARD_BOATS_COUNT = boardBoatsCount;
}

public Cell[][] getCells() {
  return cells;
}

public void setCells(Cell[][] cells) {
  this.cells = cells;
}

public Boat[] getBoats() {
  return boats;
}

public void setBoats(Boat[] boats) {
  this.boats = boats;
}

public int[] getDimensiones() {
  return dimensiones;
}

public void setDimensiones(int[] dimensiones) {
  this.dimensiones = dimensiones;
}

public boolean isEnd_game() {
  return end_game;
}

public void setEnd_game(boolean end_game) {
  this.end_game = end_game;
}
}
