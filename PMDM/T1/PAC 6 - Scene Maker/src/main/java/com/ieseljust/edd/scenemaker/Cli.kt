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
import java.lang.Exception
import java.util.*
import javax.swing.JFrame

// Imports per a entrada de dades
// Imports per gestionar el color de les imatges
// Imports per a gestió de llistes
class Cli {
  /*
 * Classe principal de l'aplicació. S'encarrega de la interacció amb l'usuari i
 * de la generació de l'escena amb les imatges.
 */
  fun run(args: Array<String>) {
    /*
	 * Mètode llançador de la classe. S'encarrega de mantindre la CLI activa,
	 * preguntant a l'usuari i executant les ordres que aquest introdueix.
	 */
    val keyboard = Scanner(System.`in`)
    
    // Dimensions de la finestra
    var width: Int
    var height: Int
    try {
      // Si s'especifiquen les dimensions, les inicialitzem
      width = args[0].toInt()
      height = args[1].toInt()
    } catch (e: Exception) {
      // Si no s'especifiquen, la imatge serà de 800x600
      width = 800
      height = 600
    }
    
    // Inicialitzem l'escena, amb una finestra de width x height
    // Escena serà una classe que mantindrà la llista
    // de figures a representar.
    var appEscena = Escena(width, height)
    
    // Iniciem el bucle infinit fins que escriga "quit".
    var figura: String
    do {
      // Preguntem la següent figura a emmagatzemar
      print("# Figura: ")
      val ordre = keyboard.nextLine()
      
      // Separem l'ordre introduida pel teclat en la forma: "Figura Posicio Mida Color"
      val components = ordre.split(" ").toTypedArray()
      figura = components[0]
      when (figura) {
        "dimensions" -> try {
          appEscena.tamX = components[1].toInt()
          appEscena.tamY = components[2].toInt()
        } catch (e: Exception) {
          // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
          println(
            "\u001B[31m Error de sintaxi. La sintaxi correcta és:\n dimensions x y\u001B[0m"
          )
        }
        "rectangle" -> when (components.size) {
          1 -> try {
            // Si tot és correcte creem la figura rectangle
            val nouRect = Rectangle()
            // I l'afegim a la llista
            appEscena.add(nouRect)
          } catch (e: Exception) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\nrectangle x y width height color\u001B[0m")
          }
          3 -> try {
            // Si tot és correcte creem la figura rectangle
            val nouRect = Rectangle(components[1].toInt(), components[2].toInt()) // Y
            // I l'afegim a la llista
            appEscena.add(nouRect)
          } catch (e: Exception) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\nrectangle x y width height color\u001B[0m")
          }
          4 -> try {
            // Si tot és correcte creem la figura rectangle
            val nouRect = Rectangle(
              components[1].toInt(), components[2].toInt(),  // Y
              getColor(components[3])
            ) // C
            // I l'afegim a la llista
            appEscena.add(nouRect)
          } catch (e: Exception) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\nrectangle x y width height color\u001B[0m")
          }
          6 -> try {
            // Si tot és correcte creem la figura rectangle
            val nouRect = Rectangle(
              components[1].toInt(), components[2].toInt(), components[3].toInt(), components[4].toInt(),  // H
              getColor(components[5])
            ) // C
            // I l'afegim a la llista
            appEscena.add(nouRect)
          } catch (e: Exception) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\nrectangle x y width height color\u001B[0m")
          }
          else -> println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\nrectangle x y width height color\u001B[0m")
        }
        "quadrat" -> when (components.size) {
          1 -> try {
            // Si tot és correcte creem la figura quadrat
            val nouQuadr = Quadrat()
            // I l'afegim a la llista
            appEscena.add(nouQuadr)
          } catch (e: Exception) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\nquadrat x y width height color\u001B[0m")
          }
          3 -> try {
            // Extraiem les dimensions
            // Si tot és correcte creem la figura quadrat
            val nouQuadr = Quadrat(components[1].toInt(), components[2].toInt())
            // I l'afegim a la llista
            appEscena.add(nouQuadr)
          } catch (e: Exception) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\nquadrat x y width height color\u001B[0m")
          }
          4 -> try {
            // Extraiem les dimensions
            // Si tot és correcte creem la figura quadrat
            val nouQuadr = Quadrat(
              components[1].toInt(), components[2].toInt(),
              getColor(components[3])
            )
            // I l'afegim a la llista
            appEscena.add(nouQuadr)
          } catch (e: Exception) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\nquadrat x y width height color\u001B[0m")
          }
          5 -> try {
            // Extraiem les dimensions
            // Si tot és correcte creem la figura quadrat
            val nouQuadr = Quadrat(
              components[1].toInt(), components[2].toInt(), components[3].toInt(),
              getColor(components[4])
            )
            // I l'afegim a la llista
            appEscena.add(nouQuadr)
          } catch (e: Exception) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\nquadrat x y width height color\u001B[0m")
          }
          else -> println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\nquadrat x y width height color\u001B[0m")
        }
        "linia" -> when (components.size) {
          1 -> try {
            // Extraiem les dimensions
            // Si tot és correcte creem la figura Linia
            val novaLinia = Linia()
            // I l'afegim a la llista
            appEscena.add(novaLinia)
          } catch (e: Exception) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\nlinia x y x2 y2 color\u001B[0m")
          }
          3 -> try {
            // Extraiem les dimensions
            // Si tot és correcte creem la figura Linia
            val novaLinia = Linia(components[1].toInt(), components[2].toInt())
            // I l'afegim a la llista
            appEscena.add(novaLinia)
          } catch (e: Exception) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\nlinia x y x2 y2 color\u001B[0m")
          }
          4 -> try {
            // Extraiem les dimensions
            // Si tot és correcte creem la figura Linia
            val novaLinia = Linia(
              components[1].toInt(), components[2].toInt(),
              getColor(components[3])
            )
            // I l'afegim a la llista
            appEscena.add(novaLinia)
          } catch (e: Exception) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\nlinia x y x2 y2 color\u001B[0m")
          }
          5 -> try {
            // Extraiem les dimensions
            // Si tot és correcte creem la figura Linia
            val novaLinia = Linia(
              components[1].toInt(), components[2].toInt(), components[3].toInt(), components[4].toInt(),
              getColor(components[5])
            )
            // I l'afegim a la llista
            appEscena.add(novaLinia)
          } catch (e: Exception) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\nlinia x y x2 y2 color\u001B[0m")
          }
          else -> println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\nlinia x y x2 y2 color\u001B[0m")
        }
        "cercle" -> when (components.size) {
          1 -> try {
            // Extraiem les dimensions
            // Si tot és correcte creem la figura cercle
            val nouRect = Cercle()
            // I l'afegim a la llista
            appEscena.add(nouRect)
          } catch (e: Exception) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\ncercle x y radi color\u001B[0m")
          }
          3 -> try {
            // Extraiem les dimensions
            // Si tot és correcte creem la figura cercle
            val nouRect = Cercle(components[1].toInt(), components[2].toInt())
            // I l'afegim a la llista
            appEscena.add(nouRect)
          } catch (e: Exception) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\ncercle x y radi color\u001B[0m")
          }
          4 -> try {
            // Extraiem les dimensions
            // Si tot és correcte creem la figura cercle
            val nouRect = Cercle(
              components[1].toInt(), components[2].toInt(),
              getColor(components[3])
            )
            // I l'afegim a la llista
            appEscena.add(nouRect)
          } catch (e: Exception) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\ncercle x y radi color\u001B[0m")
          }
          5 -> try {
            // Extraiem les dimensions
            // Si tot és correcte creem la figura cercle
            val nouRect = Cercle(
              components[1].toInt(), components[2].toInt(), components[3].toInt(),
              getColor(components[4])
            )
            // I l'afegim a la llista
            appEscena.add(nouRect)
          } catch (e: Exception) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\ncercle x y radi color\u001B[0m")
          }
        }
        "ellipse" -> when (components.size) {
          1 -> try {
            // Extraiem les dimensions
            // Si tot és correcte creem la figura Ellipse
            val nouRect = Ellipse()
            // I l'afegim a la llista
            appEscena.add(nouRect)
          } catch (e: Exception) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\nellipse x y radi color\u001B[0m")
          }
          3 -> try {
            // Extraiem les dimensions
            // Si tot és correcte creem la figura Ellipse
            val nouRect = Ellipse(components[1].toInt(), components[2].toInt())
            // I l'afegim a la llista
            appEscena.add(nouRect)
          } catch (e: Exception) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\nellipse x y radi color\u001B[0m")
          }
          4 -> try {
            // Extraiem les dimensions
            // Si tot és correcte creem la figura Ellipse
            val nouRect = Ellipse(
              components[1].toInt(), components[2].toInt(),
              getColor(components[3])
            )
            // I l'afegim a la llista
            appEscena.add(nouRect)
          } catch (e: Exception) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\nellipse x y radi color\u001B[0m")
          }
          5 -> try {
            // Extraiem les dimensions
            // Si tot és correcte creem la figura Ellipse
            val nouRect = Ellipse(
              components[1].toInt(), components[2].toInt(), components[3].toInt(), components[4].toInt(),
              getColor(components[5])
            )
            // I l'afegim a la llista
            appEscena.add(nouRect)
          } catch (e: Exception) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\nellipse x y radi color\u001B[0m")
          }
        }
        "get" ->        // Descarreguem una figura en el format que estem treballant des d'Internet
          // D'això s'encarrega la classe RemoteManager ja implementada
          try {
            // Descarrega una llista de figures
            val fitxer = components[1]
            val rm = RemoteManager()
            val novesFigures = rm.download(fitxer)
            appEscena = Escena()
            for (linia in novesFigures!!) {
              // Aci hem de tornar a fer el switch per "desmembrar" la línia
              val items = linia!!.split(" ").toTypedArray()
              when (items[0]) {
                "dimensions" -> {
                  appEscena.tamX = items[1].toInt()
                  appEscena.tamY = items[2].toInt()
                }
                "rectangle" -> {
                  // Si tot és correcte creem la figura rectangle
                  val nouRect = Rectangle(
                    items[1].toInt(), items[2].toInt(), items[3].toInt(), items[4].toInt(),
                    getColor(items[5])
                  )
                  // I l'afegim a la llista
                  appEscena.add(nouRect)
                }
                "quadrat" -> {
                  // Si tot és correcte creem la figura quadrat
                  val nouQuadrat = Quadrat(
                    items[1].toInt(), items[2].toInt(), items[3].toInt(),
                    getColor(items[4])
                  )
                  // I l'afegim a la llista
                  appEscena.add(nouQuadrat)
                }
                "linia" -> {
                  // Si tot és correcte creem la figura linia
                  val novaLinia = Linia(
                    items[1].toInt(), items[2].toInt(), items[3].toInt(), items[4].toInt(),
                    getColor(items[5])
                  )
                  // I l'afegim a la llista
                  appEscena.add(novaLinia)
                }
                "cercle" -> {
                  // Si tot és correcte creem la figura cercle
                  val nouCercle = Cercle(
                    items[1].toInt(), items[2].toInt(), items[3].toInt(),
                    getColor(items[4])
                  )
                  // I l'afegim a la llista
                  appEscena.add(nouCercle)
                }
                "ellipse" -> {
                  // Si tot és correcte creem la figura cercle
                  val novaEllipse = Ellipse(
                    items[1].toInt(), items[2].toInt(), items[3].toInt(), items[4].toInt(),
                    getColor(items[5])
                  )
                  // I l'afegim a la llista
                  appEscena.add(novaEllipse)
                }
              }
            }
          } catch (e: Exception) {
            println("Excepció en la càrrega del fitxer: ")
            System.err.println(e)
          }
        "remotelist" -> try {
          // Descarrega l'index de figures del servidor remot
          val rm = RemoteManager()
          val liniaFitxers = rm.download("index.php")
          val fitxers = liniaFitxers!![0]!!.split("<br/>").toTypedArray()
          for (fitxer in fitxers) {
            println(fitxer)
          }
        } catch (e: Exception) {
          println("Excepció en la càrrega del fitxer: ")
          System.err.println(e)
        }
        "list" ->        // Si l'ordre indicada és llista, imprimirem la llista de figures
          appEscena.renderText()
        "render" -> appEscena.renderScene()
        "quit" -> {
          println("Adéu!")
          System.exit(0)
        }
        else ->        // Si hem arribat aci, l'ordre no es coneix
          println("\u001B[31m Figura no reconeguda \u001B[0m")
      }
    } while (true)
  }
  
  fun getColor(color: String?): Color {
    /*
	 * Mètode auxiliar per tal de "traduir" els colors en mode text a la seua
	 * representació com a constants en awt.Color
	 */
    return when (color) {
      "roig" -> Color.RED
      "verd" -> Color.GREEN
      "blau" -> Color.BLUE
      "groc" -> Color.YELLOW
      "magenta" -> Color.MAGENTA
      "cyan" -> Color.CYAN
      "blanc" -> Color.WHITE
      "negre" -> Color.BLACK
      "gris" -> Color.GRAY
      "grisClar" -> Color.LIGHT_GRAY
      "grisFosc" -> Color.DARK_GRAY
      "rosa" -> Color.PINK
      "taronja" -> Color.ORANGE
      else -> Color.BLACK
    }
  }
  
  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      /*
	 * Mètode d'inici de l'aplicació. Creem un nou objecte de tipus Cli, i
	 * l'executem amb el mètode run.
	 *
	 * Els arguments que li passem seran les dimensions per defecte d'una imatge.
	 */
      val myCli = Cli()
      myCli.run(args)
    }
  }
}