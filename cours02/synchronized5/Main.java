public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Tache(1));
        Thread t2 = new Thread(new Tache(2));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(Tache.chaine);
        System.out.println(Tache.cpt);
    }
}