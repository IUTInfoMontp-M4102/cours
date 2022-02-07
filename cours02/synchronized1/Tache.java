public class Tache implements Runnable {
  public static String chaine = "";
  public static int cpt = 0;
  private int id;

  public Tache(int id) {
    this.id = id;
  }

  public void run() {
    for (int i = 0; i < 10; i++) {
      chaine += "T" + id + " ";
      cpt++;
    }
  }
}