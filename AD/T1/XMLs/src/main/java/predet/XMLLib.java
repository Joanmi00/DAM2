package predet;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XMLLib {

public Document ObreXML(String nom) throws IOException, SAXException, ParserConfigurationException {
  // Creem una instància de DocumentBuilderFactory
  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
  // Amb la instància de DocumentBuilderFactory creem un DocumentBuilder
  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
  //I utilitzem el mètode "parse" de DocumentBuilder per obtindre el document
  
  return dBuilder.parse(new File(nom));
  
  // Hacer metodo en una linea:
  // return (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(nom);
}

public void MostraXML(Document doc) {
  Element arrel = doc.getDocumentElement();
  
  // Obtindrem una llista de nodes (Pas 1)
  NodeList moduls = arrel.getElementsByTagName("modul");
  
  // Per a cada node (Pas 2)
  for (int i = 0; i < moduls.getLength(); i++) {
    Element el = (Element) moduls.item(i);
    
    // Mostra el nom del node (Pas 3)
    System.out.println(el.getNodeName() + " " + (i + 1));
    
    // I mostrem el valor de les diferents etiquetes (Passos 4, 5 i 6)
    
    // String nom = el.getElementsByTagName("nom").item(0).getFirstChild().getTextContent();
    String nom = el.getElementsByTagName("nom").item(0).getTextContent();
    String hores = el.getElementsByTagName("hores").item(0).getFirstChild().getNodeValue();
    String qualificacio = el.getElementsByTagName("qualificacio").item(0).getFirstChild().getNodeValue();
    System.out.println("Modul " + (i + 1) + ": " + nom + ", " + hores + ", " + qualificacio);
  }
}

/**
 * Funció que rep un Document XML i retorna un array
 * amb objectes de tipus mòdul
 *
 * @param doc El document XML ja obert i carregat
 * @return El Array de Moduls
 */
public ArrayList<Modul> cargarXML(Document doc) {
  // TODO
  return null;
}
}
