package AD.Examen01;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ResultadoCarrera {

private Driver d;
private String constructor;
private int initialPos;
private int finalPos;
private long timeMillis;
private int completedLaps;
private int rankFastesLap;
private boolean finisher;

public ResultadoCarrera(Driver d, String constructor, int initialPos, int finalPos, long timeMillis, int completedLaps, int rankFastesLap, boolean finisher) {
  this.d = d;
  this.constructor = constructor;
  this.initialPos = initialPos;
  this.finalPos = finalPos;
  this.timeMillis = timeMillis;
  this.completedLaps = completedLaps;
  this.rankFastesLap = rankFastesLap;
  this.finisher = finisher;
}

/**
 * <Result number="44" position="7" positionText="7" points="6">
 * <Driver driverId="hamilton" code="HAM" url="http://en.wikipedia.org/wiki/Lewis_Hamilton">
 * <PermanentNumber>44</PermanentNumber>
 * <GivenName>Lewis</GivenName>
 * <FamilyName>Hamilton</FamilyName>
 * <DateOfBirth>1985-01-07</DateOfBirth>
 * <Nationality>British</Nationality>
 * </Driver>
 * <Constructor constructorId="mercedes" url="http://en.wikipedia.org/wiki/Mercedes-Benz_in_Formula_One">
 * <Name>Mercedes</Name>
 * <Nationality>German</Nationality>
 * </Constructor>
 * <Grid>13</Grid>
 * <Laps>78</Laps>
 * <Status statusId="1">Finished</Status>
 * <Time millis="6300141">+15.801</Time>
 * <FastestLap rank="5" lap="54">
 * <Time>1:15.825</Time>
 * <AverageSpeed units="kph">158.433</AverageSpeed>
 * </FastestLap>
 * </Result>
 */
public ResultadoCarrera(Element result) {
  // Obtindrem una llista de nodes
  NodeList results = result.getElementsByTagName("Result");
  
  // Construir per a cada node
  for (int i = 0; i < results.getLength(); i++) {
    Element el = (Element) results.item(i);
    
    this.d = new Driver((Element) el.getElementsByTagName("Driver").item(0));
    this.constructor = el.getElementsByTagName("Constructor").item(0).getFirstChild().getNodeValue();
    this.initialPos = Integer.parseInt(el.getElementsByTagName("Grid").item(0).getFirstChild().getNodeValue());
    this.finalPos = Integer.parseInt(el.getAttribute("position"));
    
    //this.timeMillis = 0;
    Element aux1 = (Element) (el.getElementsByTagName("FastestLap").item(0));
    this.timeMillis = Long.parseLong(aux1.getAttribute("millis"));
    
    this.completedLaps = Integer.parseInt(el.getElementsByTagName("Laps").item(0).getFirstChild().getNodeValue());
    
    //this.rankFastesLap = 0;
    Element aux2 = (Element) (el.getElementsByTagName("FastestLap").item(0));
    this.rankFastesLap = Integer.parseInt(aux2.getAttribute("rank"));
    
    Element aux3 = (Element) (el.getElementsByTagName("Status").item(0));
    this.finisher = Boolean.parseBoolean(aux3.getAttribute("statusId"));
  }
}

public String toCSV() {
  return this.d + ";" + this.constructor + ";" + this.initialPos + ";" + this.finalPos + ";" + this.timeMillis
         + ";" + this.completedLaps + ";" + this.rankFastesLap + ";" + this.finisher;
}

public static String toHHMMSSmmm(long millis) {
  long mmm = millis % 1000;
  long seconds = millis / 1000;
  long s = seconds % 60;
  long m = (seconds / 60) % 60;
  long h = (seconds / (60 * 60)) % 24;
  return String.format("%02d:%02d:%02d:%03d", h, m, s, mmm);
  
}

@Override
public String toString() {
  String resul = "Resultado de Carrera:\n\t" + d.getName() + " " + d.getSurname() + " conduciendo un " + constructor +
                 "\n\tParte de la posicion: " + initialPos + " y termina en la " + finalPos +
                 "\n\tHa completado " + completedLaps + " vueltas";
  if (this.finisher)
    resul += " tardando " + toHHMMSSmmm(timeMillis);
  else
    resul += " sin completar la carrera";
  
  resul += "\n\tSu clasificacion en vuelta rápida personal=" + rankFastesLap;
  return resul;
}

public Driver getD() {
  return d;
}

public String getConstructor() {
  return constructor;
}

public int getInitialPos() {
  return initialPos;
}

public int getFinalPos() {
  return finalPos;
}

public long getTimeMillis() {
  return timeMillis;
}

public int getCompletedLaps() {
  return completedLaps;
}

public int getRankFastesLap() {
  return rankFastesLap;
}

public boolean isFinisher() {
  return finisher;
}
}
