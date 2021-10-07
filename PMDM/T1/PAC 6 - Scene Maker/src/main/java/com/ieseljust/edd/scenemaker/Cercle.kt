package com.ieseljust.edd.scenemaker

import com.ieseljust.edd.scenemaker.Figures
import java.awt.Color
import java.awt.Graphics

class Cercle : Figures {
  // Getters i Setters
  /*
      * Aquesta classe representa un element gràfic de tipus Cercle
      */
  // Atributs
  var radi: Int? = null
  
  // Constructors
  internal constructor() : super() {
    // Constructor per defecte sense paràmetres
    radi = 50
  }
  
  internal constructor(x: Int, y: Int) : super(x, y) {
    // Constructor on s'especifica només pa posició
    radi = 50
  }
  
  internal constructor(x: Int, y: Int, color: Color?) : super(x, y, color) {
    // Constructor on s'especifica la posició i el color
    radi = 50
  }
  
  internal constructor(x: Int, y: Int, radi: Int, color: Color?) : super(x, y, color) {
    // Constructor on s'especifica la posició, el color i les dimensions
    this.radi = radi
  }
  
  // Mètode Accessors
  override fun render(g: Graphics) {
    /*
	 * Mètode que dibuixa sobre un context gràfic la figura rectangle.
	 * S'utilitza per al mètode render() de la cli.
	 *
	 * Per dibuixar altres primitives de la classe Graphics, podeu consultar
	 * https://docs.oracle.com/javase/10/docs/api/java/awt/Graphics.html
	 */
    // Establim el color interior
    g.color = color
    // Dibuixem un rectangle en la posició i mida indicades
    g.fillOval(x - radi!!, y - radi!!, 2 * radi!!, 2 * radi!!)
  }
}