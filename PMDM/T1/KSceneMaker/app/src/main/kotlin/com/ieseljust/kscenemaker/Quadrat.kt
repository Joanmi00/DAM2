@file:JvmName("Quadrat")

package com.ieseljust.kscenemaker

import java.awt.Color
import java.awt.Graphics

class Quadrat : Figura {
  // Inicialitzem les variables en la delcaració mateix
  // No utilitzarem cap constructor primari
  private var costat: Int = 100
  
  // Constructors secundaris
  constructor() : super() //Sense arguments
  
  constructor(x: Int, y: Int, costat: Int = 100, color: Color = Color.BLACK) : super(x, y, color) {
    this.costat = costat
  }
  
  override fun describeMe() {
    /*
    * Mètode que mostra en mode text una descripció de la figura per la consola.
    * S'utilitzarà per al mètode llista de la CLI.
    */
    println("quadrat $x $y $costat $color")
  }
  
  override fun render(g: Graphics) {
    /*
     * Mètode que dibuixa sobre un context gràfic la figura quadrat.
     * S'utilitza per al mètode render() de App.
     *
     * Per dibuixar altres primitives de la classe Graphics, podeu consultar
     * https://docs.oracle.com/javase/10/docs/api/java/awt/Graphics.html
     *
     * Fixeu-vos que això són classes de java que estem utilitzant
     * directament des de Kotlin!
     */
    
    g.color = color             // Establim el color interior
    g.fillRect(x, y, costat, costat)    // Dibuixem un quadrat en la posició i mida indicades
  }
}