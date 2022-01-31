import java.util.concurrent.*;

public class MonCallableMain {

  public static void main(String[] args) {
    ExecutorService ex = Executors.newSingleThreadExecutor();
    Future<Integer> res = ex.submit(new MonCallable());

    while (!res.isDone()) {
      System.out.println("Attente du résultat...");
      try {
        Thread.sleep(100);
      } catch (InterruptedException ignored) {}
    }

    try {
      int resultat = res.get();
      System.out.println("Résultat : " + resultat);
    } catch (InterruptedException | ExecutionException ignored) {}

    ex.shutdown();
  }
}