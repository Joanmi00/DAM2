package Utilitats;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author joange
 */
public class XMLLib {

public Document ObreXML(String nom) throws IOException, SAXException, ParserConfigurationException, FileNotFoundException {
  
  // Creem una instància de DocumentBuilderFactory
  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
  // Amb la instància de DocumentBuilderFactory creem un DocumentBuilder
  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
  //I utilitzem el mètode "parse" de DocumentBuilder per obtindre el document
  Document doc = dBuilder.parse(new File(nom));
  
  return doc;
}

public void mostrarXML(Document doc) {
  Element arrel = doc.getDocumentElement();
  //System.out.println(arrel.getTextContent());
  NodeList elsModuls = arrel.getElementsByTagName("modul");
  
  for (int i = 0; i < elsModuls.getLength(); i++) {
    
    Element e = (Element) elsModuls.item(i);
    
    //System.out.println(e.getNodeName());
    
    String nom = e.getElementsByTagName("nom").item(0).getTextContent();
    String hores = e.getElementsByTagName("hores").item(0).getTextContent();
    String qualificacio = e.getElementsByTagName("qualificacio").item(0).getTextContent();
    
    System.out.println("Modul " + (i + 1) + ": " + nom + ", " + hores + ", " + qualificacio);
  }
}

/**
 * Funció que rep un Document XML i retorna un array
 * amb objectes de tipus mòdul
 * @param doc El document XML ja obert i carregat
 * @return El Array de Moduls
 */
    /*
    public ArrayList<Modul> cargarXML(Document doc){
        // To - DO
         Element arrel=doc.getDocumentElement();
        
        //System.out.println(arrel.getTextContent());
        
        ArrayList<Modul> moduls= new ArrayList<>();
        
        NodeList elsModuls=arrel.getElementsByTagName("modul");
        
        for (int i = 0; i < elsModuls.getLength(); i++) {
            
            Element e =(Element)elsModuls.item(i);
            
            //System.out.println(e.getNodeName());
            
            String nom=e.getElementsByTagName("nom").item(0).getTextContent();
            String hores=e.getElementsByTagName("hores").item(0).getTextContent();
            String qualificacio=e.getElementsByTagName("qualificacio").item(0).getTextContent();
            
            //System.out.println("Modul " + (i+1)+ ": " + nom + ", " + hores + ", " + qualificacio);
            
            Modul m= new Modul(nom, Integer.parseInt(hores), Double.parseDouble(qualificacio));
            
            moduls.add(m);
            
        }
        return moduls;
    }
    
    */

/**
 * Funció que rep un Document XML i retorna un array
 * amb objectes de tipus mòdul
 * @param doc El document XML ja obert i carregat
 * @return El Array de Moduls
 */
    /*
    public ArrayList<Modul> cargarXML_V2(Document doc){
        // To - DO
         Element arrel=doc.getDocumentElement();
        
        //System.out.println(arrel.getTextContent());
        
        ArrayList<Modul> moduls= new ArrayList<>();
        
        NodeList elsModuls=arrel.getElementsByTagName("modul");
        
        for (int i = 0; i < elsModuls.getLength(); i++) {
            
            Element e =(Element)elsModuls.item(i);
            
            Modul m= new Modul(e);
            
            moduls.add(m);
            
        }
        return moduls;
    }
    */
    
    /*
    
    public void saveXML(ArrayList<Modul> elsModuls, String nomFitxer){
        
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            
            Element arrel= doc.createElement("curs");
            doc.appendChild(arrel);
            
            
            for (Modul m : elsModuls) {
                // afegim un mòdul dins del "curs"
                Element modul=doc.createElement("modul");
                arrel.appendChild(modul);
                
                Element nom=doc.createElement("nom");
                modul.appendChild(nom);  
//                Node valor=(Node)doc.createTextNode(m.getModul());
//                nom.appendChild(valor);
                nom.appendChild(doc.createTextNode(m.getModul()));
                nom.setAttribute("convalidable", "true");
                
                Element hores=doc.createElement("hores");
                modul.appendChild(hores);             
                hores.appendChild(doc.createTextNode(String.valueOf(m.getHores())));
                
                Element qual=doc.createElement("qualificacio");
                modul.appendChild(qual);             
                qual.appendChild(doc.createTextNode(m.getNota()+""));
                
                
            }
            
            Transformer trans = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new FileOutputStream(nomFitxer));
            
            
            trans.transform(source, result);
            
            
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLLib.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(XMLLib.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XMLLib.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XMLLib.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    */
}
