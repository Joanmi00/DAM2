package practica;

public class Rectangulo extends Figura {
private double base;
private double altura;

public Rectangulo(int id, double x, double y, String colorBorde, String colorRelleno, double base, double altura) {
  super(id, x, y, colorBorde, colorRelleno);
  this.setBase(base);
  this.setAltura(altura);
}

@Override
public double area() {
  return getBase() * getAltura();
}

@Override
public double perimetro() {
  return (2 * getBase()) + (2 * getAltura());
}

/**
 * Modifica el tamaño de la figura. (100 lo deja igual, 50 a la mitad, 200 el doble y así con cualquier porcentaje).
 */
@Override
public void escalar(int porcentaje) {
  this.setBase(this.getBase() * porcentaje / 100);
  this.setAltura(this.getAltura() * porcentaje / 100);
  
  System.out.println("El rectangulo se ha escalado un " + porcentaje + "%");
}

@Override
public String toString() {
  return "El Rectangulo de id " + this.getId() + " tiene su origen en " + this.getOrigen();
}

// GETTERS Y SETTERS

public double getBase() {
  return base;
}

public void setBase(double base) {
  this.base = base;
}

public double getAltura() {
  return altura;
}

public void setAltura(double altura) {
  this.altura = altura;
}
}
