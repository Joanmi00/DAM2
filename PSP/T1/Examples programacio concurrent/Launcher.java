public class Launcher {
  public static void main(String[] args) {
    try {
      String app = "konsole";
      ProcessBuilder pb;
      System.out.println("Starting " + app);
      pb = new ProcessBuilder(app);
      pb.start();
      System.out.println(app + " launch finished");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
