import java.util.concurrent.Callable;

public class MonCallable implements Callable<Integer> {
  public Integer call() throws Exception {
    try {
      Thread.sleep(300);
    } catch(InterruptedException e) {}
      throw new Exception("Interrompu : " + e.getMessage());
    }
    return 42;
  }
}