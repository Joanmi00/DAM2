package com.ieseljust.ad.figures;

// Llibreríes per a poder dibuixar 

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Linia.java: Especialització de figura que dibuixa una línia de
 * grossosor predefinit 3 píxels. A més dels atributs heretats de figura,
 * incorpora un nou atribut de la classe punt (anomenat vector),
 * que diu el punt final de la línia.
 * Haurà d’implementar alguns mètodes addicionals per obtenir
 * una representació de la figura en diferents formats (text, XML, JSON),
 * i incorporar les llibreríes pertinents.
 */

// Definim la classe Línia a partir de la classe figura
// Heretarem per tant, la posició i el color
class Linia extends Figura {

// Té un nou atribut que serà el radi
private Punt vector;

// Constructors
Linia() {
  // Sense paràmetres:
  super(); // Invoca al constructor del pare
  this.vector = new Punt(0, 0);
}

Linia(int x, int y, int x2, int y2, String color) {
  // Amb paràmetres:
  super(x, y, color); // Invoquem al constructor pare
  this.vector = new Punt(x2, y2); // Indiquem el vector de la línia
}

public void renderText() {
  // Escriu les propietats de la figura
  System.out.println("Linia de (" + this.posicio.getX() + "," + this.posicio.getY() + ") fins a (" + this.vector.getX() + ", " + this.vector.getY() + ") i color " + this.color);
}

public void render(GraphicsContext gc) {
  // Dibuixem la linia amb el seu color
  Color color = Color.web(this.color);
  gc.setLineWidth(3); // Grossor per defecte de la línia: 3
  gc.setStroke(color);
  gc.strokeLine(this.posicio.getX(), this.posicio.getY(), this.vector.getX(), this.vector.getY());
  
}

}
