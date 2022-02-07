import java.util.concurrent.locks.*;

public class Lecteur implements Runnable {
  private Lock lock;

  public Lecteur(Lock lock) {
    this.lock = lock;   // verrou de lecture
  }

  public void run() {
    for (int i = 0; i < 10; i++) {
      lock.lock();      // prendre le verrou
      try{
        if (Redacteur.cpt % 2 == 0) {
          Thread.sleep(10);
          System.out.printf("%d ", Redacteur.cpt);
        }
      } catch (InterruptedException e) {
      } finally {
        lock.unlock();  // rendre le verrou
      }
    }
  }
}