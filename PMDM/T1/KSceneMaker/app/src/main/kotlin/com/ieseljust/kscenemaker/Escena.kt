@file:JvmName("Escena")

package com.ieseljust.kscenemaker


class Escena constructor(private var tamX: Int = 800, private var tamY: Int = 600) {
  // Hem utilitzat el constructor primari, per declarar
  // els atributs, que seran mutables, per tant tindran
  // getteers i setters, i els hem donat valor per defecte.
  // Anb açò no cal utilitzar el constructor secundari (constructor)
  // ni el mètode init perquè ja estan inicialitzats.
  // Tapoc cal definir mètodes accessors, ja que
  // Kotlin els crea automàticament
  
  // Definim la llista mutable de figures
  
  // Compte! ArrayList comença en majúscula, però arrayListOf és en minúscula
  private var llistaFigures: ArrayList<Figura> = arrayListOf()
  
  fun add(figura: Figura) {
    /*
     * Aquest mètode afig un objecte de tipus Figura a l'escena.
     */
    
    // Comprovem que la figura cau dins la imatge
    if (figura.x < this.tamX && figura.y < this.tamY) {
      this.llistaFigures.add(figura)
      println("\u001B[32m OK \u001B[0m")
    } else {
      // En cas contrari, mostrem l'error
      println("\u001B[31m La imatge cau fora de l'escena. \u001B[0m")
    }
  }
  
  fun renderText() {
    /* Mostra la llista de figures i les seues propietats */
    
    println("Escena de " + this.tamX + "x" + this.tamY + "px")
    // Recorrem la llista de figures i invoquem
    // el mètode describeMe de cadascuna d'elles.
    for (figura in llistaFigures) figura.describeMe()
  }
  
  fun renderScene() {
    println("rendering...")
    /*
     * Aquest mètode s'encarrega de dibuixar l'escena. Per a això, crearà un objecte
     * de la classe renderer, que s'inicialitza amb les dimensions de la imatge, i
     * seguidament, li proporciona la llista de figures que es volen dibuixar.
     * Aquest mètode Render de la classe Renderer ja s'encarregarà de crear la
     * imatge, i invocar al mètode `render` de cada figura per tal que es dibuixe
     * en l'àrea de dibuix.
     */
    
    val dr = Renderer(this.tamX, this.tamY)
    dr.render(llistaFigures)
  }
}


