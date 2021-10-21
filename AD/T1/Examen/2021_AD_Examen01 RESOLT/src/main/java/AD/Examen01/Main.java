package AD.Examen01;

import Utilitats.Colors;
import org.json.JSONArray;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author joange
 */
public class Main {

/**
 * @param args the command line arguments
 */
public static final Location TAVERNES = new Location(39.08357, -0.24115, "Tavernes de la Valldigna", "Espanya");

public static void main(String[] args) {
  
  System.out.println("---------- EXERCICI 1 --------");
  
  ArrayList<Circuit> elsCircuits = carregaCircuitsJSON("circuits.json");
  
  
  for (Circuit c : elsCircuits) {
    System.out.print(Colors.Blue + "Circuit: <" + Colors.Reset + c.getName() + "> == ");
    System.out.println(Colors.Blue + "Ubicació: " + Colors.Reset + c.getLoc().getCoord());
  }
  
  System.out.println("Circuits prop de Tavernes");
  imprimirCercanos(elsCircuits, TAVERNES, 1000);
  
  guardarObjectes(elsCircuits, "circuits.obj");
  
  System.out.println("-------- FI EXERCICI 1 -------");
  
  System.out.println("---------- EXERCICI 2 --------");
  ArrayList<ResultadoCarrera> elsResultados = carregaResultadosXML("monaco_2017.xml");
  for (ResultadoCarrera r : elsResultados) {
    System.out.println(r);
  }
  
  saveAsCSV("monaco_2017.csv", elsResultados);
  
  System.out.println("-------- FI EXERCICI 1 -------");
}

public static ArrayList<Circuit> carregaCircuitsJSON(String nomJSON) {
  FileReader file = null;
  ArrayList<Circuit> elsCircuits = new ArrayList<Circuit>();
  try {
    
    file = new FileReader(nomJSON);
    String myJson = "";
    int i;
    while ((i = file.read()) != -1) {
      myJson = myJson + ((char) i);
    }
    //System.out.println(myJson);
    file.close();
    // I fem ús del constructor de JSONObject
    // al que li passem un string amb el JSON:
    JSONObject arrel = new JSONObject(myJson);
    JSONArray circuits = arrel.getJSONArray("Circuits");
    for (i = 0; i < circuits.length(); i++) {
      Circuit c = new Circuit((JSONObject) circuits.get(i));
      elsCircuits.add(c);
    }
  } catch (FileNotFoundException ex) {
    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
  } catch (IOException ex) {
    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
  } finally {
    try {
      file.close();
    } catch (IOException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  return elsCircuits;
}

public static void imprimirCercanos(ArrayList<Circuit> elsCircuits, Location l, double km) {
  
  for (Circuit c : elsCircuits) {
    double distancia = c.getLoc().distanciaTo(l);
    
    if (distancia < km) {
      System.out.println("Distanca de " + c.getName() + " a " + l.getLocality() + ": " + distancia);
    }
  }
  
}

public static ArrayList<ResultadoCarrera> carregaResultadosXML(String nomXML) {
  ArrayList<ResultadoCarrera> elsResultados = new ArrayList<ResultadoCarrera>();
  try {
    Document doc = ObreXML(nomXML);
    
    NodeList resultats = doc.getElementsByTagName("Result");
    
    for (int i = 0; i < resultats.getLength(); i++) {
      
      Element result = (Element) resultats.item(i);
      
      ResultadoCarrera rc = new ResultadoCarrera(result);
      
      elsResultados.add(rc);
      
    }
    
  } catch (IOException ex) {
    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
  } catch (ParserConfigurationException ex) {
    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
  } catch (SAXException ex) {
    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
  }
  
  return elsResultados;
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

public static void saveAsCSV(String nomFitxer, ArrayList<ResultadoCarrera> elsResultats) {
  FileWriter fw = null;
  try {
    File f = new File(nomFitxer);
    fw = new FileWriter(f);
    BufferedWriter bfw = new BufferedWriter(fw);
    
    for (ResultadoCarrera r : elsResultats) {
      String res = r.getD().getName() + " " + r.getD().getSurname() + ";";
      res += r.getConstructor() + ";";
      res += r.getInitialPos() + ";" + r.getFinalPos() + ";";
      res += r.getCompletedLaps() + ";";
      if (r.isFinisher()) {
        res += ResultadoCarrera.toHHMMSSmmm(r.getTimeMillis());
      }
      
      bfw.write(res);
      bfw.newLine();
    }
    bfw.close();
    
  } catch (IOException ex) {
    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
  } finally {
    try {
      fw.close();
    } catch (IOException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
}

public static void guardarObjectes(ArrayList<Circuit> elsCircuits, String nomObjectes) {
  FileOutputStream fos = null;
  try {
    File f = new File(nomObjectes);
    fos = new FileOutputStream(f);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    
    // versió fàcil i ràpida
    // escriure tot el array de una tacad
    //    oos.writeObject(elsCircuits);
    
    // versió habitual. Escriure els cirtuits de un en un
    
    for (Circuit c : elsCircuits) {
      oos.writeObject(c);
    }
    
    oos.close();
    fos.close();
    
  } catch (FileNotFoundException ex) {
    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
  } catch (IOException ex) {
    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
  } finally {
    try {
      fos.close();
    } catch (IOException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}

}
