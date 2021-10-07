package practica;

public class Circulo extends Figura {
// Todas redefinirán toString() para poder identificar el tipo de figura, el id, y su posición.
// necesitaremos el radio
private double radio;

public Circulo(int id, double x, double y, String colorBorde, String colorRelleno, double radio) {
  super(id, x, y, colorBorde, colorRelleno);
  setRadio(radio);
}

@Override
public double area() {
  return Math.PI * getRadio() * getRadio();
}

@Override
public double perimetro() {
  return 2 * Math.PI * getRadio();
}

/**
 * Modifica el tamaño de la figura. (100 lo deja igual, 50 a la mitad, 200 el doble y así con cualquier porcentaje).
 */
@Override
public void escalar(int porcentaje) {
  this.setRadio(this.getRadio() * porcentaje / 100);
  
  System.out.println("El circulo se ha escalado un " + porcentaje + "%");
}

@Override
public String toString() {
  return "El Circulo de id " + this.getId() + " tiene su origen en " + this.getOrigen();
}

// GETTERS Y SETTERS

public double getRadio() {
  return radio;
}

public void setRadio(double radio) {
  this.radio = radio;
}
}
