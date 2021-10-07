package practica;

public class Punto {
// Todas redefinirán toString() para poder identificar el tipo de figura, el id, y su posición.
private double x;
private double y;

public Punto(double x, double y) {
  this.setX(x);
  this.setY(y);
}

public void setPunto(Punto p) {
  this.setX(p.x);
  this.setY(p.y);
}

@Override
public String toString() {
  return "(" + getX() + ", " + getY() + ")";
}

// GETTERS Y SETTERS

public double getX() {
  return x;
}

public void setX(double x) {
  this.x = x;
}

public double getY() {
  return y;
}

public void setY(double y) {
  this.y = y;
}
}
