
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author joange
 */
public class ExempleFitxers {

public static void main(String[] args) {
  
  ArrayList<Alumne> elsAlumnes;
  
  elsAlumnes = llegirFitxer("alumnes.txt");
  
  for (Alumne alumne : elsAlumnes) {
    System.out.println(alumne);
  }

//        guardarFicheroBinario(elsAlumnes, "alumnes.dat");
  
  guardarFicheroObjetos(elsAlumnes, "alumnes.obj");
  
  guardarFicheroObjetos_v2(elsAlumnes, "alumnesArray.obj");
  
  
  System.out.println("-------------------------------------");
  leerObj_y_Mostrar("alumnes.obj");
  
  
}


public static ArrayList<Alumne> llegirFitxer(String nomFitxer) {
  FileReader fr = null;
  ArrayList<Alumne> elsAlumnes = new ArrayList<Alumne>();
  try {
    
    File f = new File(nomFitxer);
    fr = new FileReader(f);
    BufferedReader bfr = new BufferedReader(fr);
    
    while (bfr.ready()) {
      String linea = bfr.readLine();
      // Maria Sanchez,22,DAM,7.23
      
      String[] items = linea.split(",");
      // [Maria Sanchez|22|DAM|7.23]
      
      //Alumne a = new Alumne(items[0],Integer.parseInt(items[1]),items[2],Double.parseDouble(items[3]));
      
      elsAlumnes.add(a);
      
    }
    
    
  } catch (FileNotFoundException ex) {
    System.out.println(ex.getMessage());
  } catch (IOException ex) {
    System.out.println(ex.getMessage());
  } finally {
    try {
      fr.close();
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }
  
  return elsAlumnes;
}


public static void guardarFicheroBinario(ArrayList<Alumne> elsAlumnes, String nomFitxer) {
  FileOutputStream fos = null;
  try {
    File f = new File(nomFitxer);
    fos = new FileOutputStream(f);
    DataOutputStream dos = new DataOutputStream(fos);
    
    
    for (Alumne alumne : elsAlumnes) {
      //dos.writeUTF(alumne.getNom());
      //dos.writeInt(alumne.getEdat());
      //dos.writeUTF(alumne.getCicle());
      //dos.writeDouble(alumne.getNota_m());
    }
    
    dos.close();
  } catch (FileNotFoundException ex) {
    System.out.println(ex.getMessage());
  } catch (IOException ex) {
    Logger.getLogger(ExempleFitxers.class.getName()).log(Level.SEVERE, null, ex);
  } finally {
    try {
      fos.close();
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }
}


public static void guardarFicheroObjetos(ArrayList<Alumne> elsAlumnes, String nomFitxer) {
  
  FileOutputStream fos = null;
  try {
    File f = new File(nomFitxer);
    fos = new FileOutputStream(f);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    
    for (Alumne a : elsAlumnes) {
      oos.writeObject(a);
    }
    
    
    oos.close();
    
  } catch (FileNotFoundException ex) {
    System.out.println(ex.getMessage());
  } catch (IOException ex) {
    System.out.println(ex.getMessage());
  } finally {
    try {
      fos.close();
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }
  
  
}

public static void guardarFicheroObjetos_v2(ArrayList<Alumne> elsAlumnes, String nomFitxer) {
  
  FileOutputStream fos = null;
  try {
    File f = new File(nomFitxer);
    fos = new FileOutputStream(f);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    
    oos.writeObject(elsAlumnes);
    
    
    oos.close();
    
  } catch (FileNotFoundException ex) {
    System.out.println(ex.getMessage());
  } catch (IOException ex) {
    System.out.println(ex.getMessage());
  } finally {
    try {
      fos.close();
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }
  
  
}


/**
 * Lee del fichero de objetos y lo muestra por pantalla
 *
 * @param nomFitxer Nombre del fichero de objetos
 */
public static void leerObj_y_Mostrar(String nomFitxer) {
  FileInputStream fis = null;
  try {
    
    File f = new File(nomFitxer);
    fis = new FileInputStream(f);
    ObjectInputStream ois = new ObjectInputStream(fis);
    
    while (fis.available() > 0) {
      Alumne a = (Alumne) ois.readObject();
      System.out.println(a);
    }
    
    
    ois.close();
    
    
  } catch (FileNotFoundException ex) {
    System.out.println(ex.getMessage());
  } catch (IOException ex) {
    System.out.println(ex.getMessage());
  } catch (ClassNotFoundException ex) {
    Logger.getLogger(ExempleFitxers.class.getName()).log(Level.SEVERE, null, ex);
  } finally {
    try {
      fis.close();
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }
  
  
}
}
