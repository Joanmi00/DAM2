import java.util.*

// 1. Demane a l'usuari per teclat varies paraules, fins que escriga "desc" o "asc".
// 2. Mostre les paraules en ordre ascendent o descendent, en funcio de lo que se ha escrit.

fun main() {
  val reader = Scanner(System.`in`)
  var linia: String
  val strArray: MutableList<String> = mutableListOf()

  println("Se te demanara que escrigues linies. Quan escriques 'asc' o 'desc', la introduccio finalitzara.")
  while (true) {
    print(">> ")
    linia = reader.nextLine()
    if (linia != "asc" && linia != "desc") {
      strArray.add(linia)
    } else break
  }

  escriuLlista(*strArray.toTypedArray(), ordre = linia)
}

fun escriuLlista(vararg llista: String, ordre: String) {
  if (ordre == "asc") {
    for (item in llista) println(item)
  } else if (ordre == "desc") {
    for (i in llista.size - 1 downTo 0) println(llista[i])
  }
}
