package predet;

import java.io.Serializable;

class Modul implements Serializable {
private String nom;
private int hores;
private double nota;

public Modul() {
  // Constructor buit
}

public Modul(String nom, int hores, double nota) {
  this.setNom(nom);
  this.setHores(hores);
  this.setNota(nota);
}

public String getModul() {
  return getNom();
}

public String getNom() {
  return nom;
}

public void setNom(String nom) {
  this.nom = nom;
}

public int getHores() {
  return this.hores;
}

public void setHores(int hores) {
  this.hores = hores;
}

public double getNota() {
  return this.nota;
}

public void setNota(double nota) {
  this.nota = nota;
}
}