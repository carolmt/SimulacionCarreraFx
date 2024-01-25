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
        //comprobamos si la nueva coordenada está dentro del mapa, si da error se queda en la misma posicion.
        Boolean limite;
        limite = limiteMapa(coordenadaX);
        if(limite == false)
            this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        Boolean limite;
        limite = limiteMapa(coordenadaY);
        if(limite == false)
            this.coordenadaY = coordenadaY;
    }

    @Override
    public String toString() {
        return "(" + coordenadaY + "," + coordenadaX + ")";
    }

    public static Coordenada generarCoordenadaAleatoriaSeparada(Coordenada coordenadaJugador, int separacionMin) {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(30);
            y = random.nextInt(30);
        } while (Math.abs(x - coordenadaJugador.coordenadaY) < separacionMin || Math.abs(y - coordenadaJugador.coordenadaX) < separacionMin);

        return new Coordenada(x, y);
    }

    //metodo para comprobar si la nueva coordenada está dentro del mapa, sino da error.
    public Boolean limiteMapa(int coordenada) {
        if(coordenada < 0 || coordenada > 30) {
            System.out.println("Error. Estás en el límite del mapa.");
            return true;
        }
        else
            return false;
    }
}
