package AD.Examen01;

import Utilitats.Colors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;

/**
 * @author joange
 */
public class Main {

/**
 * @param args the command line arguments
 */
public static final Location TAVERNES = new Location(39.08357, -0.24115, "Tavernes de la Valldigna", "Espanya");

public static void main(String[] args) {
  // EXERCICI 1
  System.out.println("------------------ Exercici 1 -------------------");
  ArrayList<Circuit> elsCircuits = carregaCircuitsJSON("circuits.json");
  
  //Descomentar al implementar la classe Circuit
  for (Circuit c : elsCircuits) {
    System.out.print(Colors.Blue + "Circuit: <" + Colors.Reset + c.getName() + "> == ");
    System.out.println(Colors.Blue + "Ubicació: " + Colors.Reset + c.getLoc().getCoord());
  }
  
  imprimirCercanos(elsCircuits, TAVERNES, 1000);
  
  guardarObjectes(elsCircuits, "circuits.obj");
  
  System.out.println("----------------- FI Exercici 1 ------------------");
  
  // EXERCICI 2
  System.out.println("------------------ Exercici 2 -------------------");
  
  ArrayList<ResultadoCarrera> elsResultados = carregaResultadosXML("monaco_2017.xml");
  
  for (ResultadoCarrera r : elsResultados) {
    System.out.println(r);
  }
  
  saveAsCSV("monaco_2017.csv", elsResultados);
  
  System.out.println("----------------- FI Exercici 2 ------------------");
}

public static ArrayList<Circuit> carregaCircuitsJSON(String nomJSON) {
  ArrayList<Circuit> elsCircuits = new ArrayList<>();
  try {
    FileReader fr = new FileReader(nomJSON);
    
    StringBuilder myJson = new StringBuilder();
    int i;
    while ((i = fr.read()) != -1)
      myJson.append((char) i);
    
    JSONObject json = new JSONObject(new String(myJson));
    
    // amb el mètode getJSONArray obtenim el primer
    // element "curs", que era una llista
    JSONArray jsonArray = json.getJSONArray("Circuits");
    // I ara recorrem aquesta llista:
    for (int j = 0; j < jsonArray.length(); j++) {
      // Agafem cada element de l'array amb "get"
      JSONObject circuit = jsonArray.getJSONObject(j);
      elsCircuits.add(new Circuit(circuit));
    }
    
    fr.close();
  } catch (JSONException | IOException ex) {
    ex.printStackTrace();
  }
  
  return elsCircuits;
}

/**
 * rep l’array anterior, una Localització i una quantitat. Mostrarà aquells circuits que
 * la seua distància a la localització passada sigui menor que la quantitat del tercer
 * argument. Per a provar-ho, al projecte s’ha creat la següent variable:
 * public static final Location TAVERNES =
 * new Location(39.08357, -0.24115, "Tavernes de la Valldigna", "Espanya");
 * Es demana provar-ho mostrant els circuits que disten de TAVERNES menys que 1000 km.
 */
public static void imprimirCercanos(ArrayList<Circuit> elsCircuits, Location l, double km) {
  for (Circuit circuit : elsCircuits) {
    if (circuit.getLoc().distanciaTo(l) < km)
      System.out.println(circuit);
  }
}

public static void guardarObjectes(ArrayList<Circuit> elsCircuits, String nomObjectes) {
  try {
    File f = new File(nomObjectes);
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
    
    // oos.writeObject(elsCircuits);
    
    for (Circuit c : elsCircuits) {
      oos.writeObject(c);
    }
    
    oos.close();
  } catch (IOException e) {
    e.printStackTrace();
  }
}

public static ArrayList<ResultadoCarrera> carregaResultadosXML(String nomXML) {
  ArrayList<ResultadoCarrera> elsResultados = null;
  try {
    Document doc = ObreXML(nomXML);
    
    NodeList resultats = doc.getElementsByTagName("Result");
    
    for (int i = 0; i < resultats.getLength(); i++) {
    
    }
    
  } catch (IOException | ParserConfigurationException | SAXException e) {
    e.printStackTrace();
  }
  /*try {
    File file = new File(nomXML);
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
    Document doc = builder.parse(file);
    Element arrel = doc.getDocumentElement();
    // Obtindrem una llista de nodes (Pas 1)
    NodeList moduls = arrel.getElementsByTagName("modul");
    
    // Per a cada node (Pas 2)
    for (int i = 0; i < moduls.getLength(); i++) {
      Element el = (Element) moduls.item(i);
      
      // Mostra el nom del node (Pas 3)
      System.out.println(el.getNodeName() + " " + (i + 1));
      
      // I mostrem el valor de les diferents etiquetes (Passos 4, 5 i 6)
      
      System.out.println("Nom: " + el.getElementsByTagName("nom").item(0).getFirstChild().getNodeValue());
      
      System.out.println("Hores: " + el.getElementsByTagName("hores").item(0).getFirstChild().getNodeValue());
      System.out.println("Qualificació: " + el.getElementsByTagName("qualificacio").item(0).getFirstChild().getNodeValue());
      System.out.println();
      
    }
  } catch (Exception e) {
    e.printStackTrace();
  }*/
  
  return elsResultados;
}

public static void saveAsCSV(String nomFitxer, ArrayList<ResultadoCarrera> elsResultats) {
  
}

public static Document ObreXML(String nom) throws IOException, ParserConfigurationException, FileNotFoundException, SAXException {
  
  // Creem una instància de DocumentBuilderFactory
  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
  // Per tal de poder crear un DocumentBuilder
  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
  //I utilitzem el mètode "parse" de DocumentBuilder per obtindre el document
  Document doc = dBuilder.parse(new File(nom));
  
  return doc;
}
}
