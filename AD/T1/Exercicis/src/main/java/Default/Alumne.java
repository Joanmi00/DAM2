package Default;

import java.io.Serializable;

public class Alumne implements Serializable {
private String nom;
private int edat;
private String cicle;
private double nota;

public Alumne(String nom, int edat, String cicle, double nota) {
  this.setNom(nom);
  this.setEdat(edat);
  this.setCicle(cicle);
  this.setNota(nota);
}

@Override
public String toString() {
  return "nom='" + nom + '\'' +
             ", edat=" + edat +
             ", cicle='" + cicle + '\'' +
             ", nota=" + nota;
}

public String getNom() {
  return nom;
}

public void setNom(String nom) {
  this.nom = nom;
}

public int getEdat() {
  return edat;
}

public void setEdat(int edat) {
  this.edat = edat;
}

public String getCicle() {
  return cicle;
}

public void setCicle(String cicle) {
  this.cicle = cicle;
}

public double getNota() {
  return nota;
}

public void setNota(double nota) {
  this.nota = nota;
}
}
