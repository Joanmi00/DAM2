import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
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
}

public static void exportarTexto() {
  try {
    // Usamos archivo.txt
    File f = new File(resources, "archivo.txt");
    BufferedWriter bw = new BufferedWriter(new FileWriter(f));
    
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
    
    bw.close();
  } catch (IOException e) {
    e.printStackTrace();
  }
}

public static void importarTexto() {
  try {
    File f = new File(resources, "archivo.txt");
    BufferedReader br = new BufferedReader(new FileReader(f));
    
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
  }
}

public static void exportarProperties() {
  // Usa FileOutputStream
  
  Properties prop = new Properties();
  
  // Obtenemos y preparamos para escribir en el archivo las propiedades y sus variables
  prop.setProperty("variable_a_exportar1", "valor_de_variable1");
  prop.setProperty("variable_a_exportar2", "valor_de_variable2");
  prop.setProperty("variable_a_exportar3", "valor_de_variable3");
  
  try {
    // Guardamos la configuracion del tablero en el fichero 'archivo.properties'
    prop.store(new FileOutputStream(
    resources + "/archivo.properties"),
    "Fichero de configuracion");
  } catch (IOException e) {
    e.printStackTrace();
  }
}

public static void importarProperties() {
  try {
    Properties prop = new Properties();
    prop.load(new FileInputStream(resources + "/archivo.properties"));
    
    // Obtenemos y escribimos en el archivo warship las propiedades de la partida
    System.out.println(prop.getProperty("variable_a_exportar1"));
    // String variable_a_importar1 = prop.getProperty("var1");
    // Clase.setAtributo(variable_a_importar1);
    System.out.println(prop.getProperty("variable_a_exportar2"));
    System.out.println(prop.getProperty("variable_a_exportar3"));
  } catch (IOException e) {
    e.printStackTrace();
  }
}

public static void exportarBinarios() {
  try {
    // Usamos archivo.txt
    File f = new File(resources, "archivo.dat");
    DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));
    
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
    
    dos.close();
  } catch (IOException e) {
    e.printStackTrace();
  }
}

// Creo que deberia usar InputStreamReader en vez de FileReader, aclarar y solucionar
public static void importarBinarios() {
  try {
    // Usamos archivo.txt
    File f = new File(resources, "archivo.dat");
    BufferedReader br = new BufferedReader(new FileReader(f));
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
  }
}

public static void exportarObjetos() {
  try {
    File f = new File(resources, "archivo.obj");
    FileOutputStream fos = new FileOutputStream(f, false);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    
    oos.writeObject("Objeto1");
    oos.writeObject("Objeto2");
    oos.writeObject("Objeto3");
    
    oos.close();
  } catch (IOException e) {
    e.printStackTrace();
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

// Hay que hacerlo (esta mal)
public static void exportarXML() {
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

// Hay que hacerlo
public static void importarXML() {
}
}
