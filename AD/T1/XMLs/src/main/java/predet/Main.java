package predet;

import org.w3c.dom.Document;
import java.util.ArrayList;

// https://cr.openjdk.java.net/~iris/se/11/latestSpec/api/java.xml/javax/xml/parsers/DocumentBuilder.html
// https://cr.openjdk.java.net/~iris/se/11/latestSpec/api/java.xml/javax/xml/parsers/DocumentBuilderFactory.html

public class Main {

public static void main(String[] args) {
  try {
    XMLLib llibreria = new XMLLib();
    
    Document elXml = llibreria.ObreXML("moduls.xml");
    
    //llibreria.mostrarXML(elXml);
    
    ArrayList<Modul> elsModuls = llibreria.cargarXML(elXml);
  } catch (Exception e) {
    e.printStackTrace();
  }
}
}
