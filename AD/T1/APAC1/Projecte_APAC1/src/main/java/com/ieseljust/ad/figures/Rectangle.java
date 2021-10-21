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

/**
 * Rectangle.java: Especialització de figura que dibuixa un rectangle.
 * A més dels atributs heretats de figura, incorpora dos nous atributs,
 * que són l’alt i l’ample. Haurà d’implementar alguns mètodes
 * addicionals per obtenir una representació de la figura
 * en diferents formats (text, XML, JSON), i incorporar les llibreríes pertinents.
 */

// Definim la classe rectangle a partir de la classe figura
// Heretarem per tant, la posició i el color
class Rectangle extends Figura {

// Té un nou atribut que serà el radi
private Integer llarg;
private Integer alt;

// Constructors
Rectangle() {
  // Sense paràmetres:
  super(); // Invoca al constructor del pare
  this.llarg = 0;
}

Rectangle(int x, int y, int llarg, int alt, String color) {
  // Amb paràmetres:
  super(x, y, color); // Invoquem al constructor pare
  this.llarg = llarg; // Indiquem el valor de la llargària
  this.alt = alt; // Indiquem el valor de l'altura
}

public void renderText() {
  // Escriu les propietats de la figura
  System.out.println("Rectangle en (" + this.posicio.getX() + "," + this.posicio.getY() + ") de llarg " + this.llarg + ", altura " + this.alt + " i color " + this.color);
}

public void render(GraphicsContext gc) {
  // Dibuixem el rectangle amb el seu color, la posició i les dimensions
  Color color = Color.web(this.color);
  gc.setFill(color);
  
  gc.fillRect(this.posicio.getX(), this.posicio.getY(), this.llarg, this.alt);
  //gc.fillOval(this.posicio.getX(), this.posicio.getY(), this.radi*2, this.radi*2);
}

@Override
public void getAsText(Figura f, String nom) {
  FileWriter fw = null;
  BufferedWriter bw = null;
  try {
    fw = new FileWriter(nom, true);
    bw = new BufferedWriter(fw);
    bw.write("rectangle " + f.posicio.getX() + " " + f.posicio.getY() + " " + this.getLlarg() + " "
             + this.getAlt() + " " + this.color);
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
  Element nuevorect = doc.createElement("rect");
  nuevorect.setAttribute("fill", f.color);
  nuevorect.setAttribute("height", String.valueOf(this.getAlt()));
  nuevorect.setAttribute("width", String.valueOf(this.getLlarg()));
  nuevorect.setAttribute("cx", String.valueOf(f.posicio.getX()));
  nuevorect.setAttribute("cy", String.valueOf(f.posicio.getY()));
  
  return nuevorect;
}

@Override
public JSONObject getAsJson() {
  JSONObject figura = new JSONObject();
  
  figura.put("x", this.posicio.getX());
  figura.put("y", this.posicio.getY());
  figura.put("height", this.getAlt());
  figura.put("width", this.getLlarg());
  figura.put("fill", this.color);
  
  JSONObject rect = new JSONObject();
  rect.put("rectangle", figura);
  
  return rect;
}

public Integer getLlarg() {
  return llarg;
}

public void setLlarg(Integer llarg) {
  this.llarg = llarg;
}

public Integer getAlt() {
  return alt;
}

public void setAlt(Integer alt) {
  this.alt = alt;
}
}
