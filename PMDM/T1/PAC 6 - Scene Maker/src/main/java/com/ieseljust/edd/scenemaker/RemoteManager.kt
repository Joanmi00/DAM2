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
import java.io.InputStreamReader
import java.net.URL
import java.util.ArrayList
import javax.swing.JFrame

class RemoteManager {
  /*
 * Aquest mètode s'encarrega de comunicar-se amb un servidor extern
 * (joamuran.net/EDD), que ens proporciona figures ja dibuixades, per tal de no
 * haver d'estar dibuixant-les cada vegada.
 */
  fun download(filename: String): ArrayList<String>? {
    /*
	Retorna una llista de cadenes de text amb el contingut del fitxer `filename`, descarregat del servidor.
	*/
    val linies = ArrayList<String>()
    return try {
      val myURL = URL("http://joamuran.net/EDD/$filename")
      
      // Determinem el tipus de fitxer
      val uc = myURL.openConnection()
      
      // Obrim el flux
      val `is` = myURL.openStream()
      val reader = InputStreamReader(`is`)
      val bReader = BufferedReader(reader)
      var line: String
      while (bReader.readLine().also { line = it } != null) {
        linies.add(line)
      }
      
      // Tanquem buffers i streams
      bReader.close()
      reader.close()
      `is`.close()
      linies
    } catch (e: MalformedURLException) {
      println("Excepció: URL mal formatada!")
      null
    } catch (e: IOException) {
      println("Excepció no controlada: $e")
      null
    }
  }
}