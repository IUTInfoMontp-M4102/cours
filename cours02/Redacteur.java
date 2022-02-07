import java.util.concurrent.locks.*;

public class Redacteur implements Runnable {
  private Lock lock;
  public static int cpt;

  public Redacteur(Lock lock) {
    this.lock = lock;     // verrou en écriture
  }

  public void run() {
    for (int i = 0; i < 10; i++) {
      lock.lock();        // prendre le verrou
      try {
        Thread.sleep(10);
        cpt += 1;
      } catch (InterruptedException e) {
      } finally {
        lock.unlock();    // rendre le verrou
      }
    }
  }
}