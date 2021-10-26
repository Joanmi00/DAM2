import java.util.concurrent.TimeUnit;

public class Launcher3 {
  public static void main(String[] args) {
    try {
      String app = "konsole";
      ProcessBuilder pb;
      Process p;
      Boolean isProcessDead;

      pb = new ProcessBuilder(app);
      System.out.println("Iniciant " + app);
      p = pb.start();
      System.out.println(app + " s'ha carregat. Esperant 3 segons");

      // WaitFor retorna un booleà dient si el procés està en execució al cap dels
      // segons que li diem
      isProcessDead = p.waitFor(3, TimeUnit.SECONDS);

      if (!isProcessDead) {
        // Destruim el procés si aquest segueix "viu"
        System.out.println("Destruint l'aplicació " + app);
        p.destroy();
      }

      // Esperem que el procés estiga destruit
      // per a això, cal comprovar el mètode isAlive
      // Mentre el procés estiga viu escriurem un missatge
      // El fet d'utilitzar el comptador és per no
      // sobrecarregar l'eixida

      int comptador = 0;
      while (p.isAlive()) {
        comptador++;
        if (comptador == 10000) {
          System.out.println("El procés segueix viu..");
          comptador = 0;
        }
      }

      System.out.println("El procés s'ha detsruit.");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
