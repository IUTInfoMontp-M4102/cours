import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MonExecutor {
  public static void main(String args[]) {
    Executor executor = Executors.newFixedThreadPool(2);

    MaTache ex1 = new MaTache(1);
    MaTache ex2 = new MaTache(2);
    MaTache ex3 = new MaTache(3);

    executor.execute(ex1);
    executor.execute(ex2);
    executor.execute(ex3);
  }
}