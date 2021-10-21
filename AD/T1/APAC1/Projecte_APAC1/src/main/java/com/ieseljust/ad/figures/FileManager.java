package com.ieseljust.ad.figures;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.List;

/**
 * FileManager.java: Classe que s’encarregarà de le gestió de l’emmagatzemament.
 * Serà el que haurem d’implementar, i per això li dedicarem un apartat.
 */

class FileManager {

public FileManager() {

}


private boolean validaInt(String s) {
  try {
    Integer.parseInt(s);
  } catch (NumberFormatException | NullPointerException e) {
    return false;
  }
  // only got here if we didn't return false
  return true;
}

public Boolean Exists(String file) {
  return new File(file).exists();
}

public Boolean exportText(Escena escena, String file) {
  boolean out = false;
  FileWriter fw = null;
  try {
    // Usamos archivo.txt
    fw = new FileWriter(file, true);
    BufferedWriter bw = new BufferedWriter(fw);
    
    bw.write("dimensions " + escena.getX() + " " + escena.getY());
    bw.newLine();
    
    List<Figura> figuras = escena.LlistaFigures;
    for (Figura fig : figuras) {
      fig.getAsText(fig, file);
    }
    
    out = true;
  } catch (IOException e) {
    e.printStackTrace();
  } finally {
    try {
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  return out;
}

public Escena importFromText(String file) {
  // dimensions 500 500
  // rectangle 10 10 480 480 #ccccee
  // cercle 250 250 100 #aaaaaa
  Escena escena = null;
  FileReader fr = null;
  BufferedReader br = null;
  try {
    File f = new File(file);
    fr = new FileReader(f);
    br = new BufferedReader(fr);
    escena = new Escena();
    
    while (br.ready()) {
      String[] components = br.readLine().split(" ");
      switch (components[0]) {
        case "cercle":
          // Creació d'una figura de la classe cercle
          try {
            // Extraiem les dimensions
            int x = Integer.parseInt((components[1]));
            int y = Integer.parseInt((components[2]));
            int radi = Integer.parseInt((components[3]));
            String color = components[4];
            
            // Si tot és correcte creem la figura cercle
            Cercle nouCercle = new Cercle(x, y, radi, color);
            // I l'afegim a la llista
            escena.add(nouCercle);
          } catch (Exception e) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            System.out.println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\ncercle x y radi color \u001B[0m");
          }
          break;
        
        case "rectangle":
          // Creació d'una figura de la classe rectangle
          try {
            // Extraiem les dimensions
            int x = Integer.parseInt((components[1]));
            int y = Integer.parseInt((components[2]));
            int llarg = Integer.parseInt((components[3]));
            int alt = Integer.parseInt((components[4]));
            String color = components[5];
            
            // Si tot és correcte creem la figura rectangle
            Rectangle nouRectangle = new Rectangle(x, y, llarg, alt, color);
            // I l'afegim a la llista
            escena.add(nouRectangle);
          } catch (Exception e) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            System.out.println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\nrectangle x y llargària altura color \u001B[0m");
          }
          break;
        
        case "linia":
          // Creació d'una figura de la classe rectangle
          try {
            // Extraiem les dimensions
            int x = Integer.parseInt((components[1]));
            int y = Integer.parseInt((components[2]));
            int x2 = Integer.parseInt((components[3]));
            int y2 = Integer.parseInt((components[4]));
            String color = components[5];
            
            // Si tot és correcte creem la figura linia
            Linia liniaNova = new Linia(x, y, x2, y2, color);
            // I l'afegim a la llista
            escena.add(liniaNova);
          } catch (Exception e) {
            // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
            System.out.println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\nlinia x y x2 y2 color \u001B[0m");
            //System.out.println(e);
          }
          break;
        
        case "dimensions":
          // Redimensiona el marc de la imatge
          try {
            int x = Integer.parseInt((components[1]));
            int y = Integer.parseInt((components[2]));
            escena.dimensions(x, y);
            System.out.println("\u001B[32m OK \u001B[0m");
          } catch (Exception e) {
            System.out.println("\u001B[31m Error de sintaxi. La sintaxi correcta és:\ndimensions x y \u001B[0m");
          }
          break;
      }
    }
  } catch (IOException e) {
    System.out.println("Error llegint arxiu de text");
  } finally {
    try {
      fr.close();
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  return escena;
}

public Boolean exportObj(Escena escena, String file) {
  boolean out = false;
  FileOutputStream fos = null;
  ObjectOutputStream oos = null;
  try {
    File f = new File(file);
    fos = new FileOutputStream(f, true);
    oos = new ObjectOutputStream(fos);
    
    oos.writeObject(escena.getX());
    oos.writeObject(escena.getY());
    for (Figura fig : escena.LlistaFigures) {
      oos.writeObject(fig);
    }
    
    out = true;
  } catch (IOException e) {
    e.printStackTrace();
  } finally {
    try {
      fos.close();
      oos.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  return out;
}

public Escena importFromObj(String file) {
  Escena escena = null;
  try {
    File f = new File(file);
    FileInputStream fis = new FileInputStream(f);
    ObjectInputStream ois = new ObjectInputStream(fis);
    
    int x = (Integer) ois.readObject();
    int y = (Integer) ois.readObject();
    escena.dimensions(x, y);
    while (fis.available() > 0) {
      Figura f3 = (Figura) ois.readObject();
      escena.add(f3);
    }
    
    fis.close();
    ois.close();
  } catch (IOException | ClassNotFoundException e) {
    e.printStackTrace();
  }
  
  return escena;
}

public Boolean exportSVG(Escena escena, String file) {
  /*
      <?xmlversion="1.0"encoding="UTF-8"standalone="no"?> 2 <svgheight="500"width="500">
      <rect fill="#ccccee" height="480" width="480" x="10" y="10"/>
      <circle cx="250" cy="250" fill="#aaaaaa" r="100"/>
      <line stroke="#aaaaaa" stroke-width="3" x1="50" x2="450" y1="250" y2="250"/>
      <line stroke="#aaaaaa" stroke-width="3" x1="50" x2="50" y1="50" y2="
      450"/>
      <line stroke="#aaaaaa" stroke-width="3" x1="450" x2="450" y1="40" y2= "450"/>
      </svg>
   */
  boolean out = false;
  
  try {
    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    Element arrel = doc.createElement("svg");
    
    arrel.setAttribute("height", String.valueOf(escena.getX()));
    arrel.setAttribute("width", String.valueOf(escena.getY()));
    doc.appendChild(arrel);
    
    for (Figura f : escena.LlistaFigures) {
      arrel.appendChild(f.getAsXml(f, doc));
    }
    
    Transformer trans = TransformerFactory.newInstance().newTransformer();
    DOMSource source = new DOMSource(doc);
    StreamResult result = new StreamResult(new FileOutputStream(file));
    trans.transform(source, result);
    
    out = true;
  } catch (ParserConfigurationException | FileNotFoundException | TransformerException e) {
    e.printStackTrace();
  }
  
  return out;
}

public Boolean exportJSON(Escena escena, String filename) {
  boolean out = false;
  
  try {
    FileWriter file = new FileWriter(filename);
    
    JSONObject escenajson = new JSONObject();
    escenajson.put("width", escena.getX());
    escenajson.put("height", escena.getY());
    JSONArray lesfigures = new JSONArray();
    
    escena.LlistaFigures.forEach(m -> lesfigures.put(m.getAsJson()));
    escenajson.put("figuras", lesfigures);
    
    JSONObject arrel = new JSONObject();
    
    arrel.put("escena", escenajson);
    
    file.write(arrel.toString(4)); // 4 són els espais d'indentació
    file.close();
    out = true;
  } catch (JSONException | IOException ex) {
    ex.printStackTrace();
  }
  
  return out;
}
}
