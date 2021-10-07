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

/*
 *Intefície que s'assegura que els mètode que la
 * implementen ofereixen un mètode anomenat "render",
 * per dibuixar a un objecte de tipus Graphics.
 */
interface Renderizable {
  fun render(g: Graphics)
}