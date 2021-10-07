package practica;

public interface Dibujable {
/*Esta interfaz contendrá:*/

// Constantes para los colores: rojo, verde, azul, amarillo, negro, blanco.
String RESET = "\033[0m";  // Text Reset
String NEGRO = "\033[0;30m";
String ROJO = "\033[0;31m";
String VERDE = "\033[0;32m";
String AMARILLO = "\033[0;33m";
String AZUL = "\033[0;34m";
String BLANCO = "\033[0;37m";

// Métodos: dibujar(), rellenar()
static void dibujar() {
}

static void rellenar() {
}
}
