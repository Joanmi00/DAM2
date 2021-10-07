package practica;

public class Cuadrado extends Figura {

private double lado;

public Cuadrado(int id, double x, double y, String colorBorde, String colorRelleno, double lado) {
  super(id, x, y, colorBorde, colorRelleno);
  this.lado = lado;
}

@Override
public double area() {
  return getLado() * getLado();
}

@Override
public double perimetro() {
  return 4 * lado;
}

/**
 * Modifica el tamaño de la figura. (100 lo deja igual, 50 a la mitad, 200 el doble y así con cualquier porcentaje).
 */
@Override
public void escalar(int porcentaje) {
  this.setLado(this.getLado() * porcentaje / 100);
  
  System.out.println("El cuadrado se ha escalado un " + porcentaje + "%");
}

@Override
public String toString() {
  return "El Cuadrado de id " + this.getId() + " tiene su origen en " + this.getOrigen();
}

// GETTERS Y SETTERS

public double getLado() {
  return lado;
}

public void setLado(double lado) {
  this.lado = lado;
}
}
