import java.util.InputMismatchException;
import java.util.Scanner;
 
public class Menu {
 
    public static void lanzador(String[] args) {
 
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        do {
 
            System.out.println("1. Opcion de Dos Jugadores");
            System.out.println("2. Opcion de N jugadores");
            System.out.println("3. Opcion de 2 jugadores con executors");
            System.out.println("3. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");
                    Game.controlador(args);
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                    GameScale.controlador(args);
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                    GameExetutor.controlador(args);
                        break;
                    case 4:
                        salir = true;
                        System.out.println("Gracias por utilizar nuestro código");
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (Exception e) {
                System.out.println("Debes insertar un número");
            }
          sn.close();
        }while(sn.nextInt()!=3);
 
    }
 
}