import java.io.*;
import java.util.Properties;
import java.util.Random;

public class Examples {
public static String resources = "src/main/resources/";

public static void main(String[] args) {
  System.out.println();
  exportarTexto();
  importarTexto();
  System.out.println();
  exportarProperties();
  importarProperties();
}

public static void exportarTexto() {
  try {
    // Usamos archivo.txt
    File f = new File(resources, "archivo_exp.txt");
    BufferedWriter bw = new BufferedWriter(new FileWriter(f));
    
    // Obtenemos y escribimos en el archivo.txt.
    int[] unoADiez = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    for (int i = 0; i < unoADiez.length; i++) {
      // pos
      bw.write(i + ";");
      // Nº
      bw.write(unoADiez[i] + ";");
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
  String thisLine = null;
  try {
    File f = new File(resources, "archivo_imp.txt");
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
    //String variable_a_importar1 = prop.getProperty("var1");
    // Clase.setAtributo(variable_a_importar1);
    System.out.println(prop.getProperty("variable_a_exportar2"));
    System.out.println(prop.getProperty("variable_a_exportar3"));
  } catch (IOException e) {
    e.printStackTrace();
  }
}

public static void exportarBinarios() {
}

public static void importarBinarios() {
}

public static void exportarObjetos() {
}

public static void importarObjetos() {
}

public static void exportarJSON() {
}

public static void importarJSON() {
}

public static void exportarXML() {
}

public static void importarXML() {
}

}
