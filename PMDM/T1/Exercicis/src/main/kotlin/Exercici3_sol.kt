/*
A partir dels exemples de l'apartat 1.1.3, es demana fer un programa que:

Demane a l'usuari per teclat vàries paraules, fins que escriga "desc" o "asc".

Mostre les paraules escrites en ordre ascendent (si l'últim que ha escrit és "asc") o descendent (si l'últim que ha posat és "desc").

Per a açò, podeu donar una ullada a l'últim apartat del tema sobre tipus complexos de dades. El tipus de dades que ens aprofitarà serà el mutableList. Doneu una ullada a com es treballa amb ell. Una vegada creda la llista, podeu afegir elements amb el mètoda add.

Per altra banda, com que necessitareu l'operador d'estensió (spread operator) i aquest requereix aplicar-se sobre un vector, podeu convertir la llista mutable a Array amb el mètode .toTypedArray.
*/

fun escriuLlista(vararg llista: String, desc: Boolean) {
  when (desc) {
    false -> for (item in llista) println(item)
    true -> for (i in llista.size - 1 downTo 0) println(llista[i])
  }
}

fun main() {
  // Definim la llista com a una llista mutable buida d'Strings ()
  val llista: MutableList<String> = mutableListOf()
  var cadena: String
  do {
    print("Insereix una cadena: ")
    cadena = readLine()!!
    // Si la cadena no és ni "asc" ni "desc" l'afegim a la llista
    if (cadena != "asc" && cadena != "desc") llista.add(cadena)
  } while (cadena != "asc" && cadena != "desc")
  
  if (cadena == "desc") escriuLlista(*llista.toTypedArray(), desc = true)
  else escriuLlista(*llista.toTypedArray(), desc = false)
}