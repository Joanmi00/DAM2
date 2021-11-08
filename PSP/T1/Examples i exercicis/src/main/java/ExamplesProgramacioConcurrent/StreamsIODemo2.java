import java.io.*;

public class StreamsIODemo2 {
public static void main(String[] args) {
  BufferedWriter bw = null;
  try {
    // En primer lloc, creem l'objecte ProcessBuilder,
    // i l'inicialitzem amb l'ordre que anem a utilitzar.
    ProcessBuilder pb = new ProcessBuilder("cal", "2020");
    
    // Llancem el procés, i recollim l'objecte
    // Process que ens retorna.
    Process p = pb.start();
    
    // Llegim l'eixida del procés amb getInputStream,
    // a través d'InputStreamReader i BufferedReader
    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
    
    // I bolquem l'eixida a un nou fitxer, amb un
    // BufferedWriter, i de forma molt similar
    // a l'exemple anterior
    bw = new BufferedWriter(new FileWriter("calendari2020.txt"));
    String line;
    while ((line = br.readLine()) != null) {
      bw.write(line + "\n");
    }
  } catch (Exception e) {
    e.printStackTrace();
  } finally {
    try {
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
}
