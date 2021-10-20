package AD.Examen01;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * @author joange
 */
public class Location implements Serializable {

public static final int RADI_TERRA = 6371;//en kilómetros
private double lat;
private double lng;
private String locality;
private String country;

public Location(double lat, double lng, String locality, String country) {
  this.lat = lat;
  this.lng = lng;
  this.locality = locality;
  this.country = country;
}

public Location(JSONObject localitat) {
  this.lat = localitat.getDouble("lat");
  this.lng = localitat.getDouble("long");
  this.locality = localitat.getString("locality");
  this.country = localitat.getString("country");
}

@Override
public String toString() {
  return "Location{" + "lat=" + lat + ", lng=" + lng + ", locality=" + locality + ", country=" + country + '}';
}

public String getCoord() {
  return "(" + String.valueOf(lat) + ", " + String.valueOf(lng) + ")";
}

/**
 * Calcula la distància entre dos Localitzacions
 *
 * @param altre
 * @return
 */
public double distanciaTo(Location altre) {
  double dLat = Math.toRadians(this.lat - altre.lat);
  double dLng = Math.toRadians(this.lng - altre.lng);
  double sindLat = Math.sin(dLat / 2);
  double sindLng = Math.sin(dLng / 2);
  double va1 = Math.pow(sindLat, 2)
               + Math.pow(sindLng, 2)
                 * Math.cos(Math.toRadians(this.lat))
                 * Math.cos(Math.toRadians(altre.lat));
  double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
  double distancia = RADI_TERRA * va2;
  
  return distancia;
}

public double getLat() {
  return lat;
}

public void setLat(double lat) {
  this.lat = lat;
}

public double getLng() {
  return lng;
}

public void setLng(double lng) {
  this.lng = lng;
}

public String getLocality() {
  return locality;
}

public void setLocality(String locality) {
  this.locality = locality;
}

public String getCountry() {
  return country;
}

public void setCountry(String country) {
  this.country = country;
}
}
