package com.ieseljust.ad.figures;

// Llibreríes per a poder dibuixar 

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

/**
 * Cercle.java: Especialització de figura que dibuixa un cercle.
 * A més dels atributs heretats de figura, incorpora un nou atribut que representa el radi.
 * Haurà d’implementar alguns mètodes addicionals per obtenir una
 * representació de la figura en diferents formats (text, XML, JSON),
 * i incorporar les llibreríes pertinents.
 */

// Definim la classe cercle a partir de la classe figura
// Heretarem per tant, la posició i el color
class Cercle extends Figura implements Serializable {

// Té un nou atribut que serà el radi
private Integer radi;

// Constructors
Cercle() {
  // Sense paràmetres:
  super(); // Invoca al constructor del pare
  this.radi = 0;
}

Cercle(int x, int y, int radi, String color) {
  // Amb paràmetres:
  super(x - radi, y - radi, color); // Invoquem al constructor pare
  this.radi = radi; // Indiquem el valor del rado
  // Nota: La posició del cercle serà el seu punt central, per
  // aquest motiu restem el radi a X i a Y
}

public void renderText() {
  // Escriu les propietats de la figura
  System.out.println("Cercle en (" + this.posicio.getX() + "," + this.posicio.getY() + ") de radi " + this.radi + " i color " + this.color);
}


public void render(GraphicsContext gc) {
  // Dibuixem el cercle amb el seu color, la posició i el radi
  Color color = Color.web(this.color);
  gc.setFill(color);
  
  // Per dibuixar al canvas de JavaFX no hi ha una primitiva per dibuixar cercles,
  // per tant, hem de dibuixar un òval. Aquesta figura espera que li indiquem els diàmetres major i menor,
  // pel que caldrà multiplicar per 2 el radi.
  gc.fillOval(this.posicio.getX(), this.posicio.getY(), this.radi * 2, this.radi * 2);
}

@Override
public void getAsText(Figura f, String nom) {
  FileWriter fw = null;
  BufferedWriter bw = null;
  try {
    fw = new FileWriter(nom, true);
    bw = new BufferedWriter(fw);
    bw.write("cercle " + (f.posicio.getX() + this.radi) + " " + (f.posicio.getY() + this.radi) + " " + this.radi
             + " " + f.color);
    bw.newLine();
    
  } catch (IOException ex) {
  } finally {
    try {
      bw.close();
      fw.close();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
}

@Override
public Element getAsXml(Figura f, Document doc) {
  Element nuevocer = doc.createElement("circle");
  nuevocer.setAttribute("cx", String.valueOf(f.posicio.getX() + this.radi));
  nuevocer.setAttribute("cy", String.valueOf(f.posicio.getY() + this.radi));
  nuevocer.setAttribute("fill", this.color);
  nuevocer.setAttribute("r", String.valueOf(this.getRadi()));
  
  return nuevocer;
}

@Override
public JSONObject getAsJson() {
  JSONObject figura = new JSONObject();
  figura.put("x", this.posicio.getX());
  figura.put("y", this.posicio.getY());
  figura.put("r", this.getRadi());
  figura.put("fill", this.color);
  
  JSONObject cercle = new JSONObject();
  cercle.put("cercle", figura);
  return cercle;
}

public Integer getRadi() {
  return radi;
}

public void setRadi(Integer radi) {
  this.radi = radi;
}
}
