package ExamplesProgramacioConcurrent.com.psp.multiplica;

public class Multiplica2 {
public static void main(String[] args) {
  if (args.length != 2) {
    System.out.println("El programa debe recibir dos enteros como argumentos!");
    System.exit(0);
  }
  //  Integer.parseInt(args[0]);
  //  Integer.parseInt(args[1]);
  
  
  int nProcesadores = Runtime.getRuntime().availableProcessors();
  System.out.println("Numero de procesadores: " + nProcesadores);
  
  // La llista d'arguments és un vector d'strings, pel que cal convertir-los a enters llargs (LONG).
  Long r = multiplica(Long.parseLong(args[0]), Long.parseLong(args[1]));
  
  // El resultat el bolcarem per l'eixida estàndard
  System.out.println(r);
}

/**
 * Realitza la multiplicacio entre tots els números compresos entre n1 i n2
 */
public static Long multiplica(long n1, long n2) {
  long result = 1;
  
  for (long i = n1; i <= n2; i++) result = result * i;
  
  return result;
}
}