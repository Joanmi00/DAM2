package ExamplesProgramacioConcurrent;

public class RuntimeDemo {
// r serà una referència a l'entorn d'execució actual
protected Runtime r = Runtime.getRuntime();

public static void main(String[] args) throws Exception {
  RuntimeDemo rd = new RuntimeDemo();
  
  rd.mostraInfo();
  System.out.println("\nEstat inicial:");
  
  // Anem a crear uns quants objectes per plenar memòria
  rd.mostraEntorn();
  for (int i = 0; i <= 10_000_000; i++) {
    new Object();
  }
  
  System.out.println("\nEstat després de crear 10.000.000 de objectes:");
  rd.mostraEntorn();
  
  // I ara invoquem el recol·lector de fem, perquè ens netege les referències
  rd.netejaFem();
  /*
   * int cont = 0; for (long i = 0; i < 10_000_000_00; i++) { cont++; }
   * System.out.println(cont);
   */
  
  // I tornem a obtindre les mateixes dades
  System.out.println("\nEstat després de cridar el recol·lector de fem:");
  rd.mostraEntorn();
}

protected void mostraInfo() {
  // r.availableProcessors() ens diu els processadors que tenim disponibles
  System.out.println("Processadors disponibles: " + this.r.availableProcessors());
}

protected void mostraEntorn() {
  // r.totalMemory() ens indica la quantitat de memòria reservada per a la JVM
  System.out.println("Memòria Total: " + this.r.totalMemory());
  
  // r.freeMemory() ens indica la memòria lliure en la JVM
  System.out.println("Memòria Lliure: " + this.r.freeMemory());
  
  // Per calcular la memòria ocupada, restem la memòria lliure a la memòria total
  System.out.println("Memòria ocupada: " + (this.r.totalMemory() - this.r.freeMemory()));
}

protected void netejaFem() {
  this.r.gc();
}
}
