import java.io.IOException;

public class RuntimeDemo2 {
  public static void main(String[] args) throws IOException {
    // r serà una referència a l'entorn d'execució actual
    Runtime r = Runtime.getRuntime();
    r.exec("konsole");
  }
}
