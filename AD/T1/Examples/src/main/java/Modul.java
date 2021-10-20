import java.io.Serializable;

public class Modul implements Serializable {
String nom;
int hores;
double nota;

public Modul() {
// Constructor buit
}

public Modul(String nom, int hores, double nota) {
  this.nom = nom;
  this.hores = hores;
  this.nota = nota;
}

public String getModul() {
  return this.nom;
}

public int getHores() {
  return this.hores;
}

public double getNota() {
  return this.nota;
}
}

