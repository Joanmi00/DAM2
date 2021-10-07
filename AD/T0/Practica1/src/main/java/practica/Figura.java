package practica;

public abstract class Figura implements Dibujable, Comparable<Figura> {
// ATRIBUTOS
private int id;
private Punto origen;
private String colorBorde;
private String colorRelleno;

public Figura(int id, double x, double y, String colorBorde, String colorRelleno) {
  this.setId(id);
  setOrigen(new Punto(x, y));
  this.setColorBorde(colorBorde);
  this.setColorRelleno(colorRelleno);
}

public abstract double area();

public abstract double perimetro();

public double distanciaOrigen() {
  double x = getOrigen().getX();
  double y = getOrigen().getY();
  return Math.sqrt(x * x + y * y);
}

public double distancia(Figura f) {
  // Calcula la distancia entre la figura y la que le paso como parámetro
  double x1 = this.getOrigen().getX();
  double y1 = this.getOrigen().getY();
  double x2 = f.getOrigen().getX();
  double y2 = f.getOrigen().getY();
  return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
}

public abstract void escalar(int porcentaje);

public void mover(Punto p) {
  // Cambia el punto origen de la figura
  this.getOrigen().setPunto(p);
}

public void desplazarh(double x) {
  // Desplaza la figura horizaontalmente (+ derecha, - izquierda)
  this.setOrigen(new Punto(this.getOrigen().getX() + x, this.getOrigen().getY()));
}

public void desplazarv(double y) {
  // Desplaza la figura verticalmente (+ arriba, - abajo)
  this.setOrigen(new Punto(this.getOrigen().getX(), this.getOrigen().getY() + y));
}

// Todas redefinirán toString() para poder identificar el tipo de figura, el id, y su posición.
public abstract String toString();

// Se pide que las figuras implementen la interfaz Comparable para compararlas por el área
public int compareTo(Figura f) {
  return Double.compare(this.area(), f.area());
}

// Crear un comparador para el perímetro
public int compararPerimetro(Figura f1, Figura f2) {
  return Double.compare(f1.perimetro(), f2.perimetro());
}

// Crear un comparador para la posición
public int compararPosicion(Figura f1, Figura f2) {
  return Double.compare(f1.distanciaOrigen(), f2.distanciaOrigen());
}

// GETTERS Y SETTERS

public int getId() {
  return id;
}

public void setId(int id) {
  this.id = id;
}

public String getColorBorde() {
  return colorBorde;
}

public void setColorBorde(String colorBorde) {
  this.colorBorde = colorBorde;
}

public String getColorRelleno() {
  return colorRelleno;
}

public void setColorRelleno(String colorRelleno) {
  this.colorRelleno = colorRelleno;
}

public Punto getOrigen() {
  return origen;
}

public void setOrigen(Punto origen) {
  this.origen = origen;
}
}