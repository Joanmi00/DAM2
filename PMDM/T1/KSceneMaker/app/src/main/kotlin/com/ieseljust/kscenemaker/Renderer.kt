@file:JvmName("Renderer")

package com.ieseljust.kscenemaker

import java.awt.Canvas
import java.awt.Graphics
import javax.swing.JFrame

//import java.util.ArrayList

class Renderer constructor(w: Int = 0, h: Int = 0) : Canvas() {
  
  /*
  Aquesta classe s'encarrega de generar els elements gràfics necessaris
  per tal de mostrar una finestra i dibuixar en ella l'escena.

  En principi, haurem de tocar poc d'aquest fitxer.
  */
  
  // private static final long serialVersionUID = 1L;
  
  // Contingut de l'escena a dibuixar
  private val w: Int
  private val h: Int
  
  private var scene: ArrayList<Figura>
  
  init {
    // Com utilitzem un constructor primari hem d'inicialitzar
    // Agafem els valors que ens passen o bé els
    // valors per defecte definits al constructor
    this.w = w
    this.h = h
    scene = arrayListOf()
  }
  
  constructor (Scene: ArrayList<Figura>) : this() {
    // Constructor secundari inicialitzant les dimensions
    this.scene = Scene
  }
  
  
  fun render(Scene: ArrayList<Figura>): Int {
    /*
    Crea el JFrame i el Canvas per dibuixar la
    imatge i mostrar-la per pantalla.
    */
    val frame = JFrame("SceneMaker")
    println("$w $h")
    val canvas: Canvas = Renderer(Scene)
    canvas.setSize(w, h)
    frame.add(canvas)
    frame.pack()
    frame.isVisible = true
    
    repaint()
    return 1
  }
  
  override fun paint(g: Graphics) {
    /*
    Amb aquest mètode sobrecrivim el mètode `paint`per defecte de
    la classe "canvas".

    Dins d'ell, haurem d'invocar el mètode `render` de les figures
    que desitgem dibuixar.
    
    */
    // if (Scene != null) : No cal, Scene és no nullable
    for (figura in scene) figura.render(g)
  }
  
}