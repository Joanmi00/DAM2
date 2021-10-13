@file:JvmName("Ellipse")

package com.ieseljust.kscenemaker

import java.awt.Color
import java.awt.Graphics

class Ellipse : Figura {
  // Inicialitzem les variables en la delcaració mateix
  // No utilitzarem cap constructor primari
  private var radiX: Int = 50
  private var radiY: Int = 50
  
  // Constructors secundaris
  constructor() : super() //Sense arguments
  
  constructor(radiX: Int, radiY: Int) : super() {
    this.radiX = radiX
    this.radiY = radiY
  }
  
  constructor(x: Int, y: Int, radiX: Int, radiY: Int) : super(x, y) {
    this.radiX = radiX
    this.radiY = radiY
  }
  
  constructor(x: Int, y: Int, radiX: Int = 50, radiY: Int = 50, color: Color = Color.BLACK) : super(x, y, color) {
    this.radiX = radiX
    this.radiY = radiY
  }
  
  
  override fun describeMe() {
    /*
    * Mètode que mostra en mode text una descripció de la figura per la consola.
    * S'utilitzarà per al mètode llista de la CLI.
    */
    println("ellipse $x $y $radiX $radiY $color")
  }
  
  override fun render(g: Graphics) {
    /*
     * Mètode que dibuixa sobre un context gràfic la figura ellipse.
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
    // Dibuixem una ellipse en la posició i mida indicades
    g.fillOval(x - radiX, y - radiY, 2 * radiX, 2 * radiY)
  }
}