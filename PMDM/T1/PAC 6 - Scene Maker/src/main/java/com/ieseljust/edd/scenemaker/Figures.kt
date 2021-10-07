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

abstract class Figures : Renderizable {
  // Getters i Setters
  /*
    * Aquesta classe representa un element gràfic abstracte
    */
  // Atributs
  var x: Int? = null
  var y: Int? = null
  var color: Color? = null
  
  // Constructors
  constructor() {
    x = 0
    y = 0
    color = Color.black
  }
  
  constructor(x: Int, y: Int) {
    x = x
    y = y
    color = Color.black
  }
  
  constructor(x: Int, y: Int, color: Color?) {
    x = x
    y = y
    color = color
  }
  
  // Métode descriptor
  fun describeMe() {
    /*
	 * Mètode que mostra en mode text una descripció de la figura per la consola.
	 * S'utilitzarà per al mètode llista de la CLI.
	 */
    println("Figura $x $y $color")
  }
}