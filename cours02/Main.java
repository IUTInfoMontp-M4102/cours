import java.util.concurrent.locks.*;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    ReadWriteLock rwLock = new ReentrantReadWriteLock();  // paire de verrous
    Lock rdLock = rwLock.readLock();
    Lock wrLock = rwLock.writeLock();

    Thread t1 = new Thread(new Lecteur(rdLock));    // verrou en lecture
    Thread t2 = new Thread(new Lecteur(rdLock));
    Thread t3 = new Thread(new Redacteur(wrLock));  // verrou en écriture
    Thread t4 = new Thread(new Redacteur(wrLock));

    t1.start(); t2.start(); t3.start(); t4.start();
    t1.join(); t2.join(); t3.join(); t4.join();

    System.out.printf("\n%d\n", Redacteur.cpt);
  }
}