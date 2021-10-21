/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilitats;

/**
 * @author joange
 */
public class JSONLib {

    /*
    public void saveJSON(ArrayList<Modul> elsModuls, String nomFitxer) {
        try {
            
            JSONArray curs = new JSONArray();

            for (Modul m : elsModuls) {
                curs.put(m.toJSON());
            }
            
            JSONObject arrel= new JSONObject();
            arrel.put("curs", curs);
            
            FileWriter file = new FileWriter(nomFitxer);
            file.write(arrel.toString(4)); // 4 són els espais d'indentació
            file.close();
            
            
            

        } catch (JSONException ex) {
            Logger.getLogger(JSONLib.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSONLib.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    public ArrayList<Modul> loadJSON(String nomFitxer){
        ArrayList<Modul> elsModuls= new ArrayList<Modul>();
        try {
            
            FileReader file = new FileReader(nomFitxer);
            String myJson="";
            
            int i;
            while ((i=file.read()) != -1)
                myJson=myJson+((char) i);
            
            //System.out.println(myJson);
            file.close();
            
            // I fem ús del constructor de JSONObject
            // al que li passem un string amb el JSON:
            JSONObject moduls=new JSONObject(myJson);
           
            
            JSONArray curs=moduls.getJSONArray("curs");
            
            for (i = 0; i < curs.length(); i++) {
                Modul m= new Modul((JSONObject)curs.get(i));
                elsModuls.add(m);                
            }
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(JSONLib.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(JSONLib.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return elsModuls;
    }
*/
}
