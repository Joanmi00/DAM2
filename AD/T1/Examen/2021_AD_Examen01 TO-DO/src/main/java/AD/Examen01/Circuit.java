package AD.Examen01;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * @author joange
 */
public class Circuit implements Serializable {
private String name;
private Location loc;
private String url;

// completar contructor
public Circuit(String name, Location loc, String url) {
  this.name = name;
  this.loc = loc;
  this.url = url;
}

public Circuit(JSONObject circuit) {
  this.name = circuit.getString("circuitName");
  this.loc = new Location(circuit.getJSONObject("Location"));
  //this.loc = new Location((JSONObject) circuit.get("Location"));
  this.url = circuit.getString("url");
}

// completar toString
@Override
public String toString() {
  return "Circuit{" +
         "name='" + name + '\'' +
         ", loc=" + loc +
         ", url='" + url + '\'' +
         '}';
}

// completar getters i setters
public String getName() {
  return name;
}

public void setName(String name) {
  this.name = name;
}

public Location getLoc() {
  return loc;
}

public void setLoc(Location loc) {
  this.loc = loc;
}

public String getUrl() {
  return url;
}

public void setUrl(String url) {
  this.url = url;
}
}
