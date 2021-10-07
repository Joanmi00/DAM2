package com.ieseljust.edd.scenemaker

import com.ieseljust.edd.scenemaker.Escena
import com.ieseljust.edd.scenemaker.Quadrat
import com.ieseljust.edd.scenemaker.Linia
import com.ieseljust.edd.scenemaker.Cercle
import com.ieseljust.edd.scenemaker.Ellipse
import com.ieseljust.edd.scenemaker.RemoteManager
import java.awt.Color
import kotlin.jvm.JvmStatic
import com.ieseljust.edd.scenemaker.Cli
import com.ieseljust.edd.scenemaker.Figures
import java.awt.Graphics
import com.ieseljust.edd.scenemaker.Renderizable
import java.io.BufferedReader
import java.net.MalformedURLException
import java.io.IOException
import java.awt.Canvas
import javax.swing.JFrame

class Linia : Figures {
  // Getters i Setters
  /*
      * Aquesta classe representa un element gràfic de tipus Linia
      */
  // Atributs
  var x2: Int? = null
  var y2: Int? = null
  
  // Constructors
  internal constructor() : super() {
    // Constructor per defecte sense paràmetres
    x2 = 100
    y2 = 100
  }
  
  internal constructor(x: Int, y: Int) : super(x, y) {
    // Constructor on s'especifica només pa posició
    x2 = 100
    y2 = 100
  }
  
  internal constructor(x: Int, y: Int, color: Color?) : super(x, y, color) {
    // Constructor on s'especifica la posició i el color
    x2 = 100
    y2 = 100
  }
  
  internal constructor(x: Int, y: Int, x2: Int, y2: Int, color: Color?) : super(x, y, color) {
    // Constructor on s'especifica la posició, el color i les dimensions
    this.x2 = x2
    this.y2 = y2
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
    g.drawLine(x, y, x2!!, y2!!)
  }
}