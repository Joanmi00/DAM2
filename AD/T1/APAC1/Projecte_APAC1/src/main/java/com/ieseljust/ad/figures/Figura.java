package com.ieseljust.ad.figures;

// Llibreríes per a poder dibuixar 

import javafx.scene.canvas.GraphicsContext;

/**
 * Figura.java: Es tracta de la superclasse a partir de la qual
 * es deriven les classes cercle, rectangle i línia.
 * Emmagatzema la posició (amb un objecte de tipus punt) i el color de la figura.
 * En aquesta classe no caldrà fer grans canvis,
 * però si que haurà de definir com a mètodes abstractes,
 * els que anem afegint a la resta de figures comuns a la mateixa classe Figura.
 * A més, caldrà importar algunes llibreríes, per a la seriació
 * i la manipulació de fitxers XML i JSON.
 */

abstract class Figura {
/* Aquesta classe serà una classe abstracta (amb mètodes abstractes)
   a partir de la qual extendrem la resta de classes de figures geomètriques.
*/

// La posició i el color seran atributs comuns a totes les figures
protected Punt posicio;
protected String color;

// Constructors:
// Els constructors inicialitzen la posició i el color
// La posició és de tipus punt, classe que també hem definit a l'aplicació
// El color és un string en format hexadecimal: #ff0000=roig, #00ff00=verd, #0000ff=verd

Figura() {
  // Constructor per defecte sense paràmetres
  this.posicio = new Punt();
  this.color = "#000000";
}

Figura(int x, int y) {
  // Constructor on s'especifica només pa posició
  this.posicio = new Punt(x, y);
  this.color = "#000000";
}

Figura(int x, int y, String color) {
  //  Constructor on s'especifica la posició i el color
  this.posicio = new Punt(x, y);
  this.color = color;
}

// Mètodes abastractes que hauran d'implementar les subclasses
public abstract void renderText(); // Per mostrar una descripció de la figura geomètrica

public abstract void render(GraphicsContext gc); // Per dibuixar la figura al context gràfic especificat

}
