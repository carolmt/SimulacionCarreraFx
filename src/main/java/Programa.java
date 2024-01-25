import java.util.Random;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner reader = new Scanner(System.in);

        int x1 = inicio();
        int y1 = inicio();
        Jugador jugador = new Jugador(x1, y1);
        System.out.println("El jugador está en la posición (" + jugador.getCoordenadaX() + "," + jugador.getCoordenadaY() + ")");

        int x2, y2;
        do {
            x2 = inicio();
            y2 = inicio();
        } while (Math.abs(x2 - x1) < 5 || Math.abs(y2 - y1) < 5); //esta condicion es para que el enemigo no este cerca del jugador

        Enemigo enemigo = new Enemigo(x2, y2, jugador);
        System.out.println("El enemigo está en la posición (" + enemigo.getCoordenadaX() + "," + enemigo.getCoordenadaY() + ")");

        while (true) {
            System.out.print("Ingresa una dirección (w/a/s/d) para mover al jugador o 'q' para salir: ");
            String direccion = reader.nextLine();

            if (direccion.equals("q")) {
                System.out.println("Juego terminado. El jugador se ha movido " + jugador.getMovimientos().size() + " veces sin ser atrapado.");
                break;
            }

            jugador.movimiento(direccion);
        }
        reader.close();
    }

    private static int inicio() {
        return new Random().nextInt(30);
    }
}
