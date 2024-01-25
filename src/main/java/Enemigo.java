import javafx.collections.ListChangeListener;

import java.util.Random;

class Enemigo extends Coordenada implements ListChangeListener<Coordenada> {
    private Jugador jugador;

    public Enemigo(int y, int x, Jugador jugador) {
        super(y, x);
        this.jugador = jugador;
        jugador.getMovimientos().addListener(this);
    }

    @Override
    public void onChanged(Change<? extends Coordenada> change) {
        while (change.next()) {
            if (change.wasAdded()) {
                moverHaciaJugador();
                System.out.println("El enemigo se ha movido a la posición " + this);
            }
        }
    }

    private void moverHaciaJugador() {
        int deltaX = jugador.getCoordenadaX() - getCoordenadaX();
        int deltaY = jugador.getCoordenadaY() - getCoordenadaY();

        if (Math.abs(deltaX) > Math.abs(deltaY)) {
            setCoordenadaX(getCoordenadaX() + (deltaX > 0 ? 2 : -2));
        } else {
            setCoordenadaY(getCoordenadaY() + (deltaY > 0 ? 2 : -2));
        }
    }

}
