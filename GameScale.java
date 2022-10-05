import java.util.concurrent.locks.*;
import java.util.Scanner;

public class GameScale {

    private static int NUM_PLAYERS;

    public static int dameJugadores(){
            Scanner sc = new Scanner(System.in);

        // Entrada de datos numéricos
        // byte, short y float
      try{  
        System.out.println("Introduce el numero de jugadores:");
        NUM_PLAYERS = sc.nextInt();
      }catch(Exception e){
         System.out.println("No es un valor válido");
      }
      sc.close();
      return NUM_PLAYERS; 
    }
    

    public static void controlador(String[] args) {
        Lock lock = new ReentrantLock();

        int length = dameJugadores();

        Player[] players = new Player[length];

        for (int i=0; i < length; i++) {
            Player player = new Player("player"+i, lock);
            players[i] = player;
        }

        for (int i=0; i < length - 1; i++) {
            players[i].setNextPlayer(players[i+1]);
        }
        players[length - 1].setNextPlayer(players[0]);

        System.out.println("Game starting...!");

        players[0].setPlay(true);

        //Threads creation
        Thread[] threads = new Thread[length];
        for (int i=0; i < length; i++) {
            Thread thread = new Thread(players[i]);
            threads[i] = thread;
            thread.start();
        }

        //Let the players play!
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Tell the players to stop
        for (Thread thread : threads) {
            thread.interrupt();
        }

        //Don't progress main thread until all players have finished
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        }  catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Game finished!");
    }

}