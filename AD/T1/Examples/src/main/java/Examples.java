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
import java.util.Properties;
import java.util.Random;

public class Examples {
// Carpeta padre para los archivos a manipular
public static String resources = "src/main/resources/";

public static void main(String[] args) {
  System.out.println();
  exportarTexto();
  importarTexto();
  System.out.println();
  exportarProperties();
  importarProperties();
  System.out.println();
  exportarBinarios();
  importarBinarios();
  System.out.println();
  exportarObjetos();
  importarObjetos();
  System.out.println();
  exportarJSON();
  importarJSON();
  //System.out.println();
  //exportarXML();
  //importarXML();
}

public static void exportarTexto() {
  FileWriter fw = null;
  try {
    // Usamos archivo.txt
    File f = new File(resources, "archivo.txt");
    fw = new FileWriter(f);
    BufferedWriter bw = new BufferedWriter(fw);
    
    // Obtenemos y escribimos en el archivo.txt.
    int[] unoACinco = {1, 2, 3, 4, 5};
    for (int i = 0; i < unoACinco.length; i++) {
      // pos
      bw.write(i + ";");
      // Nº
      bw.write(unoACinco[i] + ";");
      // random
      Random r = new Random();
      bw.write(r.nextInt(9) + "\n");
    }
    
  } catch (IOException e) {
    e.printStackTrace();
  } finally {
    try {
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

public static void importarTexto() {
  FileReader fr = null;
  BufferedReader br = null;
  try {
    File f = new File(resources, "archivo.txt");
    fr = new FileReader(f);
    br = new BufferedReader(fr);
    
    while (br.ready()) {
      String[] linea = br.readLine().split(" ");
      for (String palabra : linea) {
        System.out.print(palabra + " ");
      }
      System.out.println();
    }
  } catch (IOException e) {
    e.printStackTrace();
  } finally {
    try {
      fr.close();
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

public static void exportarProperties() {
  // Usa FileOutputStream
  FileOutputStream fos = null;
  
  Properties prop = new Properties();
  // Obtenemos y preparamos para escribir en el archivo las propiedades y sus variables
  prop.setProperty("variable_a_exportar1", "valor_de_variable1");
  prop.setProperty("variable_a_exportar2", "valor_de_variable2");
  prop.setProperty("variable_a_exportar3", "valor_de_variable3");
  
  try {
    fos = new FileOutputStream(resources + "/archivo.properties");
    // Guardamos la configuracion del tablero en el fichero 'archivo.properties'
    prop.store(fos, "Fichero de configuracion");
  } catch (IOException e) {
    e.printStackTrace();
  } finally {
    try {
      fos.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

public static void importarProperties() {
  FileInputStream fis = null;
  try {
    Properties prop = new Properties();
    fis = new FileInputStream(resources + "/archivo.properties");
    prop.load(fis);
    
    // Obtenemos y escribimos en el archivo warship las propiedades de la partida
    System.out.println(prop.getProperty("variable_a_exportar1"));
    //String variable_a_importar1 = prop.getProperty("var1");
    //Clase.setAtributo(variable_a_importar1);
    System.out.println(prop.getProperty("variable_a_exportar2"));
    System.out.println(prop.getProperty("variable_a_exportar3"));
  } catch (IOException e) {
    e.printStackTrace();
  } finally {
    try {
      fis.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

public static void exportarBinarios() {
  FileOutputStream fis = null;
  DataOutputStream dos = null;
  try {
    // Usamos archivo.txt
    File f = new File(resources, "archivo.dat");
    fis = new FileOutputStream(f);
    dos = new DataOutputStream(fis);
    
    // Obtenemos y escribimos en el archivo.txt.
    int[] unoACinco = {1, 2, 3, 4, 5};
    for (int i = 0; i < unoACinco.length; i++) {
      // pos
      dos.writeBytes(i + ";");
      // Nº
      dos.writeBytes(unoACinco[i] + ";");
      // random
      Random r = new Random();
      dos.writeBytes(r.nextInt(9) + "\n");
    }
  } catch (IOException e) {
    e.printStackTrace();
  } finally {
    try {
      fis.close();
      dos.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

public static void importarBinarios() {
  FileReader fr = null;
  try {
    // Usamos archivo.txt
    File f = new File(resources, "archivo.dat");
    fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    // BufferedReader br = new BufferedReader(new InputStreamReader(f));
    
    while (br.ready()) {
      String[] linea = br.readLine().split(" ");
      for (String palabra : linea) {
        System.out.print(palabra + " ");
      }
      System.out.println();
    }
    
    br.close();
  } catch (IOException e) {
    e.printStackTrace();
  } finally {
    try {
      fr.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

public static void exportarObjetos() {
  FileOutputStream fos = null;
  ObjectOutputStream oos = null;
  try {
    File f = new File(resources, "archivo.obj");
    fos = new FileOutputStream(f, false);
    oos = new ObjectOutputStream(fos);
    
    oos.writeObject("Objeto1");
    oos.writeObject("Objeto2");
    oos.writeObject("Objeto3");
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
}

public static void importarObjetos() {
  try {
    File f = new File(resources, "archivo.obj");
    FileInputStream fis = new FileInputStream(f);
    ObjectInputStream ois = new ObjectInputStream(fis);
    
    while (fis.available() > 0) {
      System.out.println(ois.readObject());
    }
    
    fis.close();
    ois.close();
  } catch (IOException | ClassNotFoundException e) {
    e.printStackTrace();
  }
}

public static void exportarJSON() {
  try {
    FileWriter file = new FileWriter(new File(resources, "archivo.json"));
    
    JSONObject objetoJSON = new JSONObject();
    objetoJSON.put("variable1", 1);
    objetoJSON.put("variable2", 2);
    objetoJSON.put("variable3", 3);
    
    JSONArray jsonArrayNumeros = new JSONArray();
    int[] unoACinco = {1, 2, 3, 4, 5};
    for (int numero : unoACinco) {
      jsonArrayNumeros.put(numero);
    }
    objetoJSON.put("arrayNumeros", jsonArrayNumeros);
    
    JSONObject raiz = new JSONObject();
    raiz.put("raiz", objetoJSON);
    
    JSONObject objetoJSON2 = new JSONObject();
    objetoJSON2.put("Variable4", raiz);
    
    file.write(objetoJSON2.toString(2));  // 2 son los espacios de identacion
    file.close();
  } catch (JSONException | IOException ex) {
    ex.printStackTrace();
  }
}

public static void importarJSON() {
  try {
    FileReader file = new FileReader(new File(resources, "archivo.json"));
    
    StringBuilder myJson = new StringBuilder();
    int i;
    while ((i = file.read()) != -1)
      myJson.append((char) i);
    
    System.out.println(myJson);
    file.close();
  } catch (JSONException | IOException ex) {
    ex.printStackTrace();
  }
}

// ESTO ES IMPORTAR, NO EXPORTAR
public static void exportarXML() {
  ArrayList<String> elsResultados = new ArrayList<>();
  try {
    // Creem una instància de DocumentBuilderFactory
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    // Per tal de poder crear un DocumentBuilder
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    //I utilitzem el mètode "parse" de DocumentBuilder per obtindre el document
    Document doc = dBuilder.parse(new File(resources, "archivo.json"));
    
    NodeList resultats = doc.getElementsByTagName("Result");
    
    for (int i = 0; i < resultats.getLength(); i++) {
      Element result = (Element) resultats.item(i);
      // USAR CLASE ADECUADA
      //ResultadoCarrera rc = new ResultadoCarrera(result);
      //elsResultados.add(rc);
    }
    
    System.out.println(elsResultados);
  } catch (ParserConfigurationException | IOException | SAXException e) {
    e.printStackTrace();
  }
  
  /*try {
    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    
    Element arrel = doc.createElement("svg");
    arrel.setAttribute("height", String.valueOf(escena.getX()));
    arrel.setAttribute("width", String.valueOf(escena.getY()));
    doc.appendChild(arrel);
    List<Figura> figuras = escena.LlistaFigures;
    for (Figura f : figuras) {
      
      arrel.appendChild(f.getAsXml(f, doc));
      
    }
    
    Transformer trans = TransformerFactory.newInstance().newTransformer();
    DOMSource source = new DOMSource(doc);
    StreamResult result = new StreamResult(new FileOutputStream(file));
    
    trans.transform(source, result);
  } catch (ParserConfigurationException | TransformerException e) {
    e.printStackTrace();
  }*/
}

public static void importarXML() {
  ArrayList<String> elsResultados = new ArrayList<>();
  try {
    // Creem una instància de DocumentBuilderFactory
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    // Per tal de poder crear un DocumentBuilder
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    //I utilitzem el mètode "parse" de DocumentBuilder per obtindre el document
    Document doc = dBuilder.parse(new File(resources, "archivo.json"));
    
    NodeList resultats = doc.getElementsByTagName("Result");
    
    for (int i = 0; i < resultats.getLength(); i++) {
      Element result = (Element) resultats.item(i);
      // USAR CLASE ADECUADA
      //ResultadoCarrera rc = new ResultadoCarrera(result);
      //elsResultados.add(rc);
    }
    
    System.out.println(elsResultados);
  } catch (ParserConfigurationException | IOException | SAXException e) {
    e.printStackTrace();
  }
}
}
