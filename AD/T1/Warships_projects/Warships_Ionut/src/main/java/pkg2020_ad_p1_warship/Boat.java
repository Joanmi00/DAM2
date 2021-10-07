package pkg2020_ad_p1_warship;


/**
 * @author joange
 */
public class Boat {
// Constantes para controlar el estado general del barco
private static int BOAT_OK = 0;
private static int BOAT_TOUCHED = 1;
private static int BOAT_SUNKEN = 2;

// Constantes para controlar su orientación
private static int BOAT_DIR_HOR = 0;
private static int BOAT_DIR_VER = 1;

// Propiedades
private int dimension = 0;
private Cell[] cells;
private int estado = getBoatOk();

// Constructor
public Boat() {
  // Vacío, las propiedades se establecen en su iniciaización
}

// Para consultar el estado de un barco
public int getBoatState() {
  return getEstado();
}

// Establece la dimensión del barco y lo coloca en el tablero si cabe
public void setBoat(int dim, Board board) {
  setCells(new Cell[dim]);
  this.setDimension(dim);
  
  // Posicionamiento aleatorio
  int fila = Double.valueOf((Math.random() * (Board.getBOARD_DIM()))).intValue();
  int columna = Double.valueOf(Math.random() * (Board.getBOARD_DIM())).intValue();
  int dir = Double.valueOf(Math.random() * (getBoatDirVer() + 1)).intValue();
  
  while (!boatFits(fila, columna, dim, dir, board)) {
    fila = Double.valueOf((Math.random() * Board.getBOARD_DIM())).intValue();
    columna = Double.valueOf(Math.random() * Board.getBOARD_DIM()).intValue();
  }
  
  if (dir == getBoatDirHor()) {
    for (int i = columna; i < columna + dim; i++) {
      this.getCells()[i - columna] = board.getCell(fila, i);
      this.getCells()[i - columna].setBoat(this);
    }
  } else {
    for (int i = fila; i < fila + dim; i++) { // BOAT_DIR_VER
      this.getCells()[i - fila] = board.getCell(i, columna);
      this.getCells()[i - fila].setBoat(this);
    }
  }
}

// Controla si el bote cabe el el tablero
private boolean boatFits(int fila, int columna, int dimension, int direccion, Board board) {
  int min_col = 0, max_col = 0, min_row = 0, max_row = 0;
  
  // los barcos se colocan de fila, columna hacia la derecha o hacia abajo
  // Dependiendo de la orientación calcula el recuadro a controlar
  
  if (direccion == getBoatDirHor()) {
    if ((columna + dimension) > Board.getBOARD_DIM())
      return false; // El barco no cabe
    
    min_col = board.fitValueToBoard(columna - 1);
    max_col = board.fitValueToBoard(columna + dimension);
    
    min_row = board.fitValueToBoard(fila - 1);
    max_row = board.fitValueToBoard(fila + 1);
  }
  if (direccion == getBoatDirVer()) {
    if ((fila + dimension) > Board.getBOARD_DIM())
      return false; // El barco no cabe
    
    min_col = board.fitValueToBoard(columna - 1);
    max_col = board.fitValueToBoard(columna + 1);
    
    min_row = board.fitValueToBoard(fila - 1);
    max_row = board.fitValueToBoard(fila + dimension);
  }
  
  // Recorre la matriz que contendrá el barco para asegurarse que no hay ninguno
  for (int i = min_row; i <= max_row; i++) {
    for (int j = min_col; j <= max_col; j++) {
      if (board.getCell(i, j).getContains() == Cell.CELL_BOAT)
        return false; // Ya hay un barco
    }
  }
  return true;
}

// Cuando una shot cae sobre un barco
public int touchBoat(int fila, int columna) {
  int tocados = 0;
  // Si ya está hundido no puede empeorar
  if (getEstado() == getBoatSunken())
    return getBoatSunken();
  
  // Si no está hundido como mínimo estará tocado
  setEstado(Boat.getBoatTouched());
  
  // Comprueba si esta parte del barco aún no habia sido tocada
  // Cuenta los tocados para saber si está hundido
  for (int i = 0; i < getDimension(); i++) {
    Cell c = getCells()[i];
    if ((c.getRow() == fila) && (c.getColumn() == columna)) {
      if (c.getContains() == Cell.CELL_BOAT)
        c.setTouch();
    }
    if (c.getContains() == Cell.CELL_TOUCH)
      tocados++;
  }
  // Si todas las partes del barco están tocadas ... Cambiar estado a hundido
  if (tocados == getDimension()) {
    // Hundido ....
    for (int i = 0; i < getDimension(); i++) {
      Cell c = getCells()[i];
      c.setSunken();
    }
    setEstado(getBoatSunken());
  }
  
  return getEstado();
}

// Para mostrar por pantalla las celdas que ocupa un barco
public void viewCells() {
  System.out.print("Posiciones: {");
  for (int i = 0; i < getDimension(); i++) {
    Cell c = getCells()[i];
    System.out.print("(" + c.getRow() + ", " + c.getColumn() + ")");
  }
  System.out.println(" }");
}

public int getDimension() {
  return dimension;
}

public void setDimension(int dimension) {
  this.dimension = dimension;
}

public Cell[] getCells() {
  return cells;
}

public void setCells(Cell[] cells) {
  this.cells = cells;
}

public int getEstado() {
  return estado;
}

public void setEstado(int estado) {
  this.estado = estado;
}

public static int getBoatOk() {
  return BOAT_OK;
}

public static void setBoatOk(int boatOk) {
  BOAT_OK = boatOk;
}

public static int getBoatTouched() {
  return BOAT_TOUCHED;
}

public static void setBoatTouched(int boatTouched) {
  BOAT_TOUCHED = boatTouched;
}

public static int getBoatSunken() {
  return BOAT_SUNKEN;
}

public static void setBoatSunken(int boatSunken) {
  BOAT_SUNKEN = boatSunken;
}

public static int getBoatDirHor() {
  return BOAT_DIR_HOR;
}

public static void setBoatDirHor(int boatDirHor) {
  BOAT_DIR_HOR = boatDirHor;
}

public static int getBoatDirVer() {
  return BOAT_DIR_VER;
}

public static void setBoatDirVer(int boatDirVer) {
  BOAT_DIR_VER = boatDirVer;
}
}
