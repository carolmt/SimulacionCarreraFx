import java.util.Random;

public class Coordenada {
    private int coordenadaX;
    private int coordenadaY;

    public Coordenada(int coordenadaX, int coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    @Override
    public String toString() {
        return "(" + coordenadaX + "," + coordenadaY + ")";
    }

    public static Coordenada generarCoordenadaAleatoriaSeparada(Coordenada coordenadaJugador, int separacionMin) {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(30);
            y = random.nextInt(30);
        } while (Math.abs(x - coordenadaJugador.coordenadaX) < separacionMin || Math.abs(y - coordenadaJugador.coordenadaY) < separacionMin);

        return new Coordenada(x, y);
    }
}
