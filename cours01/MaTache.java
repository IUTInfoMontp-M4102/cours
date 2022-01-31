public class MaTache implements Runnable {
  private int id;

  public MaTache(int id) {
    this.id = id;
  }

  public void run() {
    for (int i = 0; i < 5; i++) {
      String blank = " ".repeat(id);
      System.out.println("Tache " + id + "\t" + blank + i);
      try {
        Thread.sleep(50); // millisecondes
      } catch (InterruptedException ignored) { }
    }
  }
}
