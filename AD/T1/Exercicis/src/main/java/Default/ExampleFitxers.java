package Default;

import java.io.*;
import java.util.ArrayList;

public class ExampleFitxers {
public static void main(String[] args) {
  ArrayList<Alumne> elsAlumnes;
  
  elsAlumnes = llegirFitxer("alumnes.txt");
  
  /*for (Alumne alumne : elsAlumnes) {
      System.out.println("\n" + alumne);
    }*/
  
  //guardarFicheroBinario(elsAlumnes, "alumnes.dat");
  
  //Clase alumnes debe implementar serializable
  //guardarFicheroObjetos(elsAlumnes, "alumnes.obj");
  
  //guardarFicheroObjetos_v2(elsAlumnes, "alumnesArray.obj");
  
  mostrarFicheroObjetos("alumnes.obj");
}

public static ArrayList<Alumne> llegirFitxer(String nomFitxer) {
  ArrayList<Alumne> elsAlumnes = new ArrayList<>();
  
  try {
    File f = new File(nomFitxer);
    FileReader fr = new FileReader(f);
    BufferedReader bfr = new BufferedReader(fr);
    
    while (bfr.ready()) {
      String linea = bfr.readLine();
      // Maria Sanchez,22,DAM,7.23
      
      String[] items = linea.split(",");
      // [Maria Sanchez|22|DAM|7.23]
      
      Alumne a = new Alumne(items[0], Integer.parseInt(items[1]), items[2], Double.parseDouble(items[3]));
      
      elsAlumnes.add(a);
    }
    
  } catch (IOException e) {
    e.printStackTrace();
  }
  
  return elsAlumnes;
}

public static void guardarFicheroString(ArrayList<Alumne> elsAlumnes, String nomFitxer) {
  try {
    File f = new File(nomFitxer);
    FileWriter fw = new FileWriter(f);
    BufferedWriter bw = new BufferedWriter(fw);
    
    for (Alumne alumne : elsAlumnes) {
      bw.write(String.valueOf(alumne));
    }
    
    bw.close();
  } catch (IOException e) {
    e.printStackTrace();
  }
}

public static void guardarFicheroBinario(ArrayList<Alumne> elsAlumnes, String nomFitxer) {
  try {
    File f = new File(nomFitxer);
    FileOutputStream fos = new FileOutputStream(f);
    DataOutputStream dos = new DataOutputStream(fos);
    
    for (Alumne alumne : elsAlumnes) {
      dos.writeBytes(String.valueOf(alumne));
      //System.out.println("\n" + alumne);
    }
    
    dos.close();
  } catch (IOException e) {
    e.printStackTrace();
  }
}

public static void guardarFicheroObjetos(ArrayList<Alumne> elsAlumnes, String nomFitxer) {
  try {
    File f = new File(nomFitxer);
    FileOutputStream fos = new FileOutputStream(f);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    
    for (Alumne alumne : elsAlumnes) {
      oos.writeObject(alumne);
      // System.out.println("\n" + alumne);
    }
    
    oos.close();
  } catch (IOException e) {
    e.printStackTrace();
  }
}

public static void guardarFicheroObjetos_v2(ArrayList<Alumne> elsAlumnes, String nomFitxer) {
  try {
    File f = new File(nomFitxer);
    FileOutputStream fos = new FileOutputStream(f);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    
    oos.writeObject(elsAlumnes);
    
    oos.close();
  } catch (IOException e) {
    e.printStackTrace();
  }
}

public static void mostrarFicheroObjetos(String nomFitxer) {
  try {
    File f = new File(nomFitxer);
    FileInputStream fis = new FileInputStream(f);
    ObjectInputStream ois = new ObjectInputStream(fis);
    
    while (fis.available() > 0) {
      Alumne a = (Alumne) ois.readObject();
      System.out.println(a);
    }
    
    ois.close();
  } catch (IOException | ClassNotFoundException e) {
    e.printStackTrace();
  }
}
}