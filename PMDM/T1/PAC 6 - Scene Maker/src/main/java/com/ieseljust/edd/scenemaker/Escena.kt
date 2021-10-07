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
import java.util.ArrayList
import javax.swing.JFrame

internal class Escena {
  // GETTERS I SETTERS
  /*
   * Aquesta classe representa una escena, entesa com un conjunt d'objectes que
   * formen una imatge.
   *
   * L'escena tindrà unes dimensions, que determinaran el marc per dibuixar
   * posteriorment.
   */
  var tamX: Int
  var tamY: Int
  
  // Les figures de l'escena s'emmagatzemen en una llista
  private val LlistaFigures: ArrayList<Figures>
  
  constructor() {
    // Constructor. Pr defecte creem un tamany de 800x600;
    tamX = 800
    tamY = 600
    
    // Inicialitzem la llista de figures
    LlistaFigures = ArrayList()
  }
  
  constructor(x: Int, y: Int) {
    // Constructor (sobrecarregat), quan se'ns indica
    // un tamany per al marc.
    tamX = x
    tamY = y
    
    // Inicialitzem la llista de figures
    LlistaFigures = ArrayList()
  }
  
  // Mètodes accessors
  fun add(figura: Figures) {
    /*
	 * Aquest mètode afig un objecte de tipus Rectangle a l'escena.
	 */
    
    // Comprovem que la figura cau dins la imatge
    if (figura.x < tamX && figura.y < tamY) {
      LlistaFigures.add(figura)
      println("\u001B[32m OK \u001B[0m")
    } else {
      // En cas contrari, mostrem l'error
      println("\u001B[31m La imatge cau fora de l'escena. \u001B[0m")
    }
  }
  
  fun renderText() {
    /* Mostra la llista de figures i les seues propietats */
    
    // Recorrem la llista de figures i invoquem
    // el mètode describeMe de cadascuna d'elles.
    for (f in LlistaFigures) {
      f.describeMe()
    }
  }
  
  fun renderScene() {
    /*
	 * Aquest mètode s'encarrega de dibuixar l'escena. Per a això, crearà un objecte
	 * de la classe renderer, que s'inicialitza amb les dimensions de la imatge, i
	 * seguidament, li proporciona la llista de figures que es volen dibuixar.
	 * Aquest mètode Render de la classe Renderer ja s'encarregarà de crear la
	 * imatge, i invocar al mètode `render` de cada rectangle per tal que es dibuixe
	 * en l'àrea de dibuix.
	 */
    val dr = Renderer(tamX, tamY)
    dr.Render(LlistaFigures)
  }
}