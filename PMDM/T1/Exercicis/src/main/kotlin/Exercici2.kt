/*
ENUNCIADO

Argumento de entrada:numero

bucle de numero fin s a 0

utilizar when
si numero es par --> println del numero

Si caracter ASXII corresponde es A,E,I,O,U escribir el caracter

si no ponemos numero es null
*/

fun main(args: Array<String>) {
  if (args.isEmpty()) println("Has d'indicar un argument")
  else {
    for (i in args[0].toInt() downTo 0) {
      when {
        i % 2 == 0 -> println("$i es parell")
        i.toChar() == 'A' || i.toChar() == 'E' ||
            i.toChar() == 'I' || i.toChar() == 'O' ||
            i.toChar() == 'U' -> println(
          "$i es el caracter ${i.toChar()}"
        )
      }
    }
  }
}