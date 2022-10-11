public class GameExetutor {

    public static void controlador(String[] args) {
        Lock lock = new ReentrantLock();

        Player player1 = new Player("ping", lock);
        Player player2 = new Player("pong", lock);

        player1.setNextPlayer(player2);
        player2.setNextPlayer(player1);

        System.out.println("Game starting...!");

        player1.setPlay(true);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(player1);
        executor.execute(player2);

        sleep(2);

        executor.shutdownNow();

        System.out.println("Game finished!");
    }

    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}