package com.ieseljust.ad.figures;

import java.io.Serializable;

/**
 * Punt.java: Classe auxiliar per als punts de les figures, i no herata de figura.
 * En principi, no haurà d’afegir cap mètode nou, la única cosa que caldrà
 * modificar és (per a quan emmagatzem els objectes en format binari)
 * que li haurem d’indicar que la classe es pot seriar
 * (ja que en seriar un objecte, comença a seriar objectes recursivament
 * fins arribar als tipus bàsics, i ha de saber, per tant, que punt també és seriable.)
 */

class Punt implements Serializable {
// Classe que representa una ubicació a l'escena
private int x;
private int y;

Punt() {
  // Mètode Constructor
  this.x = 0;
  this.y = 0;
}

Punt(int x, int y) {
  this.x = x;
  this.y = y;
}

// Mètodes getters
public int getX() {
  return this.x;
}

public int getY() {
  return this.y;
}

// Mètode setter
public void set(int x, int y) {
  this.x = x;
  this.y = y;
}

}

