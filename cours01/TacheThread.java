public class Tache extends Thread {
  private int id;

  public Tache(int id) {
    this.id = id;
  }

  public void run() {
    for (int i=0; i<10; i++) {
      System.out.println(id + ": " + i);
    }
  }

  public static void main(String[] args) {
    Tache t1 = new Tache(1);
    Tache t2 = new Tache(2);
    t1.start();
    t2.start();
  }
}
