import java.util.concurrent.locks.*;
import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class GameExectutor {

    public static void controlador(String[] args) {
        Lock lock = new ReentrantLock();

        Player player1 = new Player("ping", lock);
        Player player2 = new Player("pong", lock);
        System.out.println("Game starting...!");
ExecutorService executor = Executors.newFixedThreadPool(2);
    
    executor.execute(player1);
    executor.execute(player2);
    
    sleep(2);
    
    executor.shutdownNow();
    
    try {
        executor.awaitTermination(5, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
        System.out.println("Main thread interrupted while waiting for players to finish");
    }

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