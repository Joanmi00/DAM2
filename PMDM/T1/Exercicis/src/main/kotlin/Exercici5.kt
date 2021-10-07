fun main() {
  testReturn2()
}

fun testReturn() {
  // Definim una llista d'enters
  val intList = listOf(1, 2, 3, 4, 5)
  // Recorrem aquesta llista amb la funció forEach.
  // Aquesta funció recorre tots els elements de la llista
  // i executa la funció lambda sobre cada element:
  intList.forEach {
    // Si l'element és divisible per 2, fem un return
    if (it % 2 == 0) return
    println("$it no és divisible");
  }
  println("Finalitzant testReturn")
}

fun testReturn2() {
  val intList = listOf(1, 2, 3, 4, 5)
  intList.forEach {
    // Fem un return explícitament de forEach
    if (it % 2 == 0) return@forEach
    println("$it no és divisible");
  }
  println("Finalitzant testReturn2")
}