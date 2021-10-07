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
import java.util.function.Consumer
import javax.swing.JFrame

class Renderer : Canvas {
  // Contingut de l'escena a dibuixar
  var Scene: ArrayList<Figures>? = null
  var w: Int? = null
  var h: Int? = null
  
  // Constructor buit
  internal constructor() {}
  internal constructor(x: Int?, y: Int?) {
    // Constructor inicialitzant les dimensions
    w = x
    h = y
  }
  
  internal constructor(Scene: ArrayList<Figures>?) {
    // Constructor passnt-li l'escena.
    this.Scene = Scene
  }
  
  fun Render(Scene: ArrayList<Figures>?): Int {
    /*
	 *Crea el JFrame i el Canvas per dibuixar la imatge i mostrar-la per pantalla.
	 */
    val frame = JFrame("SceneMaker")
    println(w.toString() + " " + h)
    val canvas: Canvas = Renderer(Scene)
    canvas.setSize(w!!, h!!)
    frame.add(canvas)
    frame.pack()
    frame.isVisible = true
    repaint()
    return 1
  }
  
  // @Override
  override fun paint(g: Graphics) {
    /*
	Amb aquest mètode sobrecrivim el mètode `paint`per defecte de
	la classe "canvas".

	Dins d'ell, haurem d'invocar el mètode `render` de les figures
	que desitgem dibuixar.
	
	*/
    if (Scene != null) {
      Scene!!.forEach(Consumer { Figures: Figures -> Figures.render(g) })
    }
  }
  
  companion object {
    /*
 *Aquesta classe s'encarrega de generar els elements gràfics necessaris per
 * tal de mostrar una finestra i dibuixar en ella l'escena.
 *
 *En principi, haurem de tocar poc d'aquest fitxer.
 */
    private const val serialVersionUID = 1L
  }
}