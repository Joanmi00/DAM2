package practica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import static practica.Dibujable.*;
import static practica.Utilidades.*;

public class Lienzo {

static ArrayList<Figura> listaFiguras = new ArrayList<>();
static final Random rnd = new Random();

public static void main(String[] args) {
  // La aplicación creará 10 figuras de tipo y en posiciones aleatorias para comenzar a trabajar.
  for (int i = 0; i < 10; i++) {
    switch (Utilidades.numAleatorioRangoInt(1, 4)) {
      case 1: // Circulo
        listaFiguras.add(new Circulo(i, rand100(), rand100(), ROJO, AZUL, rand100()));
        break;
      
      case 2: // Cuadrado
        listaFiguras.add(new Cuadrado(i, rand100(), rand100(), ROJO, AZUL, rand100()));
        break;
      
      case 3: // Rectangulo
        listaFiguras.add(new Rectangulo(i, rand100(), rand100(), ROJO, AZUL, rand100(), rand100()));
        break;
      
      case 4: // Triangulo
        listaFiguras.add(new Triangulo(i, rand100(), rand100() * 100, ROJO, AZUL, rand100(), rand100()));
        break;
    }
  }
  
  do {
    Menu();
    switch (leerEntero("[Selecciona una opcion]\n>> ")) {
      case 0: // EXIT
        System.out.println("\nADIOS");
        System.exit(0);
        break;
      
      case 1:
        listar();
        break;
      
      case 2:
        dibujar();
        break;
      
      case 3:
        perimetros();
        break;
      
      case 4:
        areas();
        break;
      
      case 5:
        int escalaIntroducida = leerEntero("¿Cual es el porcentaje por el cual quieres escalar la figura?\n>> ");
        escalar(escalaIntroducida);
        break;
      
      case 6:
        int id = leerEntero("¿Cual es la id de la figura que quieres desplazar?\n>> ");
        int x = leerEntero("¿Cual es el nuevo valor de X?\n>> ");
        int y = leerEntero("¿Cual es el nuevo valor de Y?\n>> ");
        mover(id, new Punto(x, y));
        break;
      
      case 7: // TODO Desplazar
        int id2 = leerEntero("¿Cual es la id de la figura que quieres desplazar?\n>> ");
        int x2 = leerEntero("¿Cuanto quieres desplazar en HORIZONTAL?\n>> ");
        int y2 = leerEntero("¿Cuanto quieres desplazar en VERTICAL?\n>> ");
        desplazarh(id2, x2);
        desplazarv(id2, y2);
        break;
      
      case 8: // TODO Ordenar
        // Aparecerá un submenú, que nos pregunta por que criterio queremos comparar
        // (area, perímetro o posición), mostrando a continuación
        // todas las figuras ordenadas por dicho criterio.
        // El submenú debe preguntar si el orden de las figuras es ascendente o descendente
        break;
      
      default:
        System.out.println("ERROR");
    }
  } while (true);
  
}

// Dará información de todas las figuras
public static void listar() {
  for (Figura figura : listaFiguras) System.out.println(figura);
}

// Dibujará la figura cuyo id haya sido introducido
public static void dibujar() {
  int idElegida = leerEntero("¿Cual es la id de la figura que quieres describir?\n>> ");
  for (Figura figura : listaFiguras) {
    if (figura.getId() == idElegida) {
      System.out.println(figura);
      return;
    }
  }
  System.out.println("El id introducido no coincide con el de ninguna de las figuras.");
}

// mostrará el perímetro de todas las figuras
public static void perimetros() {
  System.out.println("\nId | Perimetro\n----------");
  for (Figura figura : listaFiguras)
    System.out.println(figura.getId() + "  | " + String.format("%.2f", figura.perimetro()));
}

// mostrará el área de todas las figuras
public static void areas() {
  System.out.println("\nId | Area\n----------");
  for (Figura figura : listaFiguras)
    System.out.println(figura.getId() + "  | " + String.format("%.2f", figura.area()));
}

// dado el identificador de una figura mostrará su distancia con el resto de figuras
public static void distancia(int id) {
}

// escalara la figura cuyo id haya sido introducido
public static void escalar(int porcentaje) {
  int id = leerEntero("¿Cual es la id de la figura que quieres escalar?\n>> ");
  for (Figura figura : listaFiguras) {
    if (figura.getId() == id) {
      System.out.println("El area de la figura de id " + id + " es " + String.format("%.2f", figura.area()) + ", y su perimetro es " + String.format("%.2f", figura.perimetro()));
      figura.escalar(porcentaje);
      System.out.println("Ahora, el area de la figura de id " + id + " es " + String.format("%.2f", figura.area()) + ", y su perimetro es " + String.format("%.2f", figura.perimetro()));
      return;
    }
  }
  System.out.println("El id introducido no coincide con el de ninguna de las figuras.");
}

// mover figura a un punto especifico
public static void mover(int id, Punto punto) {
  for (Figura figura : listaFiguras) {
    if (figura.getId() == id) {
      System.out.println("La posicion de la figura de id " + id + " era " + figura.getOrigen());
      figura.mover(punto);
      System.out.println("Ahora, la posicion de la figura de id " + id + " es " + figura.getOrigen());
      return;
    }
  }
  System.out.println("El id introducido no coincide con el de ninguna de las figuras.");
}

// desplazar la figura en vertical
public static void desplazarv(int id, double y) {
  for (Figura figura : listaFiguras) {
    if (figura.getId() == id) {
      System.out.println("La posicion de la figura de id " + id + " era " + figura.getOrigen());
      figura.desplazarv(y);
      System.out.println("Ahora, la posicion de la figura de id " + id + " es " + figura.getOrigen());
      return;
    }
  }
  System.out.println("El id introducido no coincide con el de ninguna de las figuras.");
}

// desplazar la figura en horizontal
public static void desplazarh(int id, double x) {
  for (Figura figura : listaFiguras) {
    if (figura.getId() == id) {
      System.out.println("La posicion de la figura de id " + id + " era " + figura.getOrigen());
      figura.desplazarh(x);
      System.out.println("Ahora, la posicion de la figura de id " + id + " es " + figura.getOrigen());
      return;
    }
  }
  System.out.println("El id introducido no coincide con el de ninguna de las figuras.");
}

// ORDENAR
public static void ordenar() {
  Collections.sort(listaFiguras);
}

// Numero aleatorio entre 0 y 100 a 2 decimales
public static double rand100() {
  return getRandomValue(rnd, 0, 100, 2);
}
}
