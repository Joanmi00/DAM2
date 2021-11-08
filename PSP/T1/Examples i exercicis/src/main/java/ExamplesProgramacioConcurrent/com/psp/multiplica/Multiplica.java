package ExamplesProgramacioConcurrent.com.psp.multiplica;

public class Multiplica {
public static void main(String[] args) {
  Multiplica s = new Multiplica();
  // La llista d'arguments és un vector d'strings,
  // pel que cal convertir-los a enters llargs (LONG).
  Long r = s.multiplica(Long.parseLong(args[0]), Long.parseLong(args[1]));
  
  // El resultat el bolcarem per l'eixida estàndard
  System.out.println(r);
}

public Long multiplica(long n1, long n2) {
  /*
   * Realitza la multiplicacio entre tots els números compresos entre n1 i n2
   */
  long result = 1;
  for (long i = n1; i <= n2; i++) {
    result = result * i;
  }
  return result;
}
}