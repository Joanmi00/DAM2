@file:JvmName("Cercle")

package com.ieseljust.kscenemaker

import java.awt.Color
import java.awt.Graphics

class Cercle : Figura {
  // Inicialitzem les variables en la delcaració mateix
  // No utilitzarem cap constructor primari
  private var radi: Int = 50
  
  // Constructors secundaris
  constructor() : super() //Sense arguments
  
  constructor(radi: Int) : super() {
    this.radi = radi
  }
  
  constructor(x: Int, y: Int, radi: Int) : super(x, y) {
    this.radi = radi
  }
  
  constructor(x: Int, y: Int, radi: Int = 50, color: Color = Color.BLACK) : super(x, y, color) {
    this.radi = radi
  }
  
  override fun describeMe() {
    /*
    * Mètode que mostra en mode text una descripció de la figura per la consola.
    * S'utilitzarà per al mètode llista de la CLI.
    */
    println("cercle $x $y $radi $color")
  }
  
  override fun render(g: Graphics) {
    /*
     * Mètode que dibuixa sobre un context gràfic la figura cercle.
     * S'utilitza per al mètode render() de App.
     *
     * Per dibuixar altres primitives de la classe Graphics, podeu consultar
     * https://docs.oracle.com/javase/10/docs/api/java/awt/Graphics.html
     *
     * Fixeu-vos que això són classes de java que estem utilitzant
     * directament des de Kotlin!
     */
    
    // Establim el color interior
    g.color = color
    // Dibuixem un cercle en la posició i mida indicades
    g.fillOval(x - radi, y - radi, 2 * radi, 2 * radi)
  }
}