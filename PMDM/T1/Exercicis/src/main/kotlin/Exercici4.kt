// Fer una funcio que llisca linies per teclat i escriga la linia cada vegada
// (fa un eco de aquesta), fins que es complisca la condicio que li passem a traves d'una lambda.

fun main() {
  echo { s: String -> s == "eixir" }
  // Simplificado
  echo { it == "eixir" }
  // junto
  echo(fun(s: String): Boolean { return s == "eixir" })
}

fun echo(funcio: (String) -> Boolean) {
  while (true) {
    var cadena: String = readLine()!!
    println(cadena)
    if (funcio(cadena)) return
  }
}