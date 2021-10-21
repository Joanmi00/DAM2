/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public Circuit(JSONObject circuit) {
  this.name = circuit.getString("circuitName");
  this.url = circuit.getString("url");
  this.loc = new Location(circuit.getJSONObject("Location"));
}

public String getName() {
  return name;
}

public Location getLoc() {
  return loc;
}

public String getUrl() {
  return url;
}

@Override
public String toString() {
  return "Circuit{" + "name=" + name + ", loc=" + loc + ", url=" + url + '}';
}

}
